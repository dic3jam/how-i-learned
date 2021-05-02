--map apply over multiple values -- defined by functor - think of it like an updating loop
--fold apply into single value -- defined into foldable - think of it as a summarizing loop
--
--these 2 concepts cover most of what imperative languages are capable of
--
--fold - foreach, map for loop
--
--much more general, can do more than just loops
--
--while loops == recursion
--
import Control.Monad

when :: Applicative f => Bool -> f () -> f ()
--f () box of nothing
--while loop type construct

f x = when (x < 6) $ do { putStrLn (show x); f (x+1)}

f 2
>> 2 \n 3 \n 4 \n 5

<$> --fmap infix operator lifting operator
<*> -- applicative infix operator: apply boxed function over a functor -- lift a function

pure --applicative box

--Monad is applicative but for sequencing
>>= --Monad operator

(>>=) :: Monad m => m a -> (a -> m b) -> m b

-- && || are short circuting operations in the imperatives -- SAME here with monad
--once it reaches Nothing or the end, it stops cleanly

(>>) :: Monad m => m a -> m b -> m b

--so Just 4 >> Nothing is Nothing and Nothing >> Just 4 is nothing BECASUE

instance Monad Maybe where
   return x = Just x
   Nothing >>= f = Nothing
   Just x >>= f = f x
   fail _ = Nothing

as >>= bs 
-- these are the same
do
   a <- as
   bs a

--evolution of the do block

let x = 3; y = "!" in show x ++ y

Just 3 >>= (\x -> Just (show x ++ "!"))

Just 3 >>= (\x -> Just "!" >>= (\y -> Just (show x ++ y)))

foo :: Maybe String
foo = Just 3 >>= (\x ->
      Just "!" >>= (\y ->
      Just (show x ++ y)))

foo' :: Maybe String
foo' = do
     x <- Just 3
     y <- Just "!"
     Just (show x ++ y)

-- as soon as one fails, will stop

--20 mins in shows Monad class 
--sequencing that is allowed to fail
--
--Monad law 1 (left identity)
--return x >>= f is same as f x
--
--Monad law 2 (right identity)
--m >>= return is same as m
--
--Monad law 3 (associative)
--(m >>= f) >>= g is same as m >>= (\x -> f x >>= g)
--
--40:00 simple example of monadic sequencing
--
--do block is syntactic sugar on monadic sequencing see video from 3/29 around 40:00
--
--Monad over list 50:00

instance Monad [] where
   return x = [x]
   xs >>= f = concat (map f xs)
   fail _ = []

[3,4,5] >>= \x -> [x,-x]
-- >> [3,-3,4,-4,5,-5]

[ [1,2] >>= \n -> ['a','b'] >>= \ch -> return [n,ch] ]
-- [(1,a),(1,b),(2,a),(2,b)]
-- if it fails concatenates an empty list to the list, which returns nothing

[ (n,ch) | n <- [1,2], even n,ch <- ['a','b'] ]

--list comprehension is also a Monad
--
--Monoid 1:00

-- start with a list of values
-- binary function a -> a -> a
-- function needs to be associative

class Monoid m where
   mempty :: m
   mappend :: m -> m -> m
   mconcat :: [m] -> m
   mconcat = foldr mappend mempty

-- on its own not a part of the functor-applicative-monad triad
--laws
--
--law 1 (left hand side identity)
--mempty 'mappend' x = x
--
--law 2 (right hand side identity)
--x 'mappend' mempty = x
--
--law 3 (associative)
--(x 'mappend' y) 'mappend' z = x 'mappend' (y 'mapppend' z)
--
instance Monoid [a] where
   mempty = []
   mappend = (++)
