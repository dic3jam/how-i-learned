--Week 10 - Monads, Foldables
--Review
--
--functor fmap or <$>
--apply normal function to boxed value
--lists are functors with multiple values
--maybe functors with possible values
--
--applicative - kind of functor <*>
--apply boxed function to boxed value
--
--Monad - gives you sequencing with sense of failure
--   IO sequences failure
--   list, maybe different sense of failure
--   >>= take a boxed value pass it and pass it on
--
--Monoid - how you combine things

--Foldable is built from tree of monoids
--list, set, map 
-- * -> *
-- foldMap :: (Foldable T, Monoid m) => (a -> a) -> t a -> m
data Tree a = EmptyTree | Leaf a | Node {value::a,left::Tree a,right::Tree a} deriving (Eq)

instance Functor Tree where
   fmap _ EmptyTree = EmptyTree
   fmap f (Leaf a) = Leaf (f a)
   fmap f (Node a l r) = Node (f a) (fmap f l) (fmap f r)

instance (Semigroup a, Ord a) => Semigroup (Tree a) where
   (<>) = union

instance (Semigroup a, Ord a) => Monoid (Tree a) where
   mempty = EmptyTree
   mappend = union

instance Foldable Tree where
   foldMap _ EmptyTree = mempty
   foldMap f (Leaf a) = f a
   foldMap f (Node x l r) = foldMap f l 'mappend'
                            f x 'mappend'
                            foldMap f r

--20 mins in defines how builds from Tree type to functor, monoid, and Foldable (by defining foldMap)
--
--Monad short circuits sequencing
--introduces non-determinism
-- as in do not know which values will be computer first
[(1+),(2*)] <*> [1,2]
-- >> [1,2,2,4]
--not completed in any specific order
--
--MonadPlus - merging of Monoid and Monad
class Monad m => MonadPlus m where
   mzero :: m a
   mplus :: m a -> m a -> m a

instance MonadPlus [] where
   mzero = []
   mplus = (++)

guard :: (MonadPlus m) => Bool -> m ()
guard True = return ()
guard False = mzero

--rewatch this lecture
--
--Monads are for sequencing
--IO, Maybe are for error sequencing
--lists are non-determinism error sequencing
--writer from Control.Monad
multiply :: Int -> Int -> Writer String Int
multiply a b = writer (a*b, "Multiplied"++(show a)++" by "++(show b)++". ")
runWriter $ add 4 5 >>= multiply 3 >>= add 2
(29, "Added 4 to 5, Multiplied....."
--SEQUENCED
--use sequencing to maintain context of where you have been
--
--Wenesday's Lecture
-- ===================
-- writer - keep a hhistory of actions
-- monoid with mappend - usually done with List or String
-- using a Monoid with mappend - done with a List or String
-- adding onto the end of a list but that is a quadratic operation
-- 
newtype DiffList a = DiffList { getDiffList :: [a] -> [a] }
--trying to make adding to end of lists more efficient (since we have to traverse the whole list to do anything)
toDiffList :: [a] -> DiffList a
toDiffList xs = DiffList (xs++)

fromDiffList :: DiffList a -> [a]
fromDiffList (DiffList f) = f []

badDList :: Int -> DiffList Char
badDList 1 = toDiffList "1"
badDList n = let DiffList f = badDList (n-1) in
                 DiffList (\xs -> f (((show n) ++) xs))
---by swapping around evaluation solved performance problem of singly linked lists

badList' :: Int -> String
badList' = fromDiffList . badDList

--stack.h
--how to preserve state - deal with things that feel like they need to be mutable
--
import Control.Monad.State
-- haskell has changed this since the book was written
-- value constructor in State is not available
-- use function state to create instances
-- also to see Control.Monad.State in ghci use command:
-- :set -package mtl
-- before loading anything that import Control.Monad.State
-

type Stack = [Int]

pop :: Stack -> (Int,Stack)
pop (x:xs) = (x,xs)

push :: Stack -> Stack -> ((),Stack)
push a xs = ((),a:xs)

stackManip :: Stack -> (Int, Stack)
stacKManip stack = let
             ((),newStack1) = push 3 stack
             (a,newStack2) = pop newStack1
             in pop newStack2

-- would be nicer if we could turn it into a Monad!

newtype State s a = State { runState :: s -> (a,s) }
--takes a piece of state and gives you back a value of that state

instance Monad (State s) where
         return x = State $ \s -> (x,s)
         (State h) >>= f = State $ \s -> let (a,newState) = h s
                                             (State g) = f a
                                         in g newState

state :: (s->(a,s)) -> State s a

pop' :: State Stack Int
pop' = state $ \(x:xs) -> (x,xs)

push' :: Int -> State Stack ()
push' a = state $ \xs -> ((),a:xs)

stackManip :: State Stack Int
stackManip = do
        push 3
        a <- pop
        pop

--do block on one line use ; and {}

--Either 

data Either a b = Left a | Right b
--left is for the error case, right is for the success
--with Maybe do not know why it failed
Left "Bad" >>= \x -> return (x+2)
-- >> Left "Bad"
Right 3 >>= \x -> return (x+2)
-- >> Right 5
calc n = do
   a <- return (3+n)
   b <- if a == 0 
        then Left "Div by 0"
        else Right (div 4 a)
        return n (b-2) :: Either String Int

join :: Monad m => m (m a) -> m a
-- if double Monad something can unbox one level of it
