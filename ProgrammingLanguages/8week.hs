--thinking in Haskell
--do not have variables-
--instead of stepping through a lot of operatuins, use composition
--instead of doing loops, use recurskon
--all loops get transformed somehow 
--
--
--Functor - core haskell typeclass
--box
---operate on something in a box
--list Functor that holds many things
--maybe functor holds something or not
do
  s <- getLine
id :: a->a
id a = a

--the <- arrow in a do is unboxing something
--functor cannot have any side effects other than the type of whats in the box
fmap id box == box
--dur da dur the distributive property
fmap (f.g) x == fmap f . fmap g x

--LIFTIN a function
--if one side boxed and the other side is not, need to LIFT the function 
--use applicative
--
--applicative is subtype of functor
--
--pure
pure :: Applicative f => a -> f a

--an applicative essentially performs distributive multiplication of functions to values
[(++"a"),(++"b")] <*> ["abc","bcd"]
>>["abca","bcda","abcb","bcdb"]

instance Applicative IO where 
     pure = return
     a <*> b = do
        f <- a
        x <- b
        return (f x)

--Random Number Generators
--should be random :: Int - ie takes no arguments returns an Int
--BUT breaks referential transparency, also no global state, so will pass out generator with random value in tuple:
--:t random
--random :: (Random a, RandomGen g) => g -> (a,g)
--
--RandomGen

--FUNCTOR IS A BOX . can apply functions to those values using fmap or <$> 
--<$> apply to boxed value

fmap (+1) Just 2 
(+1) <$> Just 2

--Applicative boxes function too - the +1 has been put inside a maybe
Just (+1) <*> Just 2
--can only apply boxed functions to boxed values
--<*> is left associative

let func = findFunction in 
   func <*> Just 2

--might have many functions
--tree.hs has implementation of binary tree that is an instance of Functor
--
--cannot compare 2 functions function cannot be instance of Eq
--
--sequenceA - backwards of fmap
--that means it will flip the boxes
sequenceA [(+2),(*5)] 1
>> [3,5]

sequenceA :: (Traversable t, Applicative f) => t (f a) -> f (t a)
--"applied each of those functions to each of those values"
--
or <$> sequenceA [(>3),odd] <$> [1,2,3,5,8]
>>[True,False,True,True,True]

--Control modules give you new ways of doing things, Data gives you new types
--
--3 ways of defining types:
--1. Data defines actual new types
--2. types defines aliases for types for the compiler only
--3. newtype repurposes a type. grabs a type, wraps it up with something
--
--Monad from abstract algebra
>>= 
--monadic sequencing
