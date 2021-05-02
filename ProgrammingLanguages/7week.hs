--warmup 3/17

readEMP :: IO (String, String, Int, Int)
readEMP = do
        putStrLn "What is the name?"
        name <- getLine
        putStrLn "What is the SSN?"
        rawssn <- getLine
	let ssn = filter (\c -> c /= '-') rawssn
        putStrLn "What is the birthyear?"
        yearStr <- getLine
        let year = (read yearStr) :: Int
        putStrLn "What is their salary?"
        salStr <- getLine
        let salary = (read salStr) :: Int
        return (name,ssn,year,salary)

-- 25:00 value constructors, deriving with instance by hand
-- System.IO
-- Interesting type classes
-- Functor
Functor :: (* -> *) -> Constraint
fmap :: Functor f => (a -> b) -> f a -> f b

--fmap show [3]
-- >> ["3"]

--map is just fmap for the box of list
--35:00 Functor, fmap
--Maybe, Just are functors
Either :: * -> * -> *
Left "bad" :: Either [Char] b
--the b is left unbound, takes 2 concrete types
-- figure out wtf the difference between Left and Right is and relationship Functor
--
--40:00
--Functor Laws
--1. if we do nothing to a value, we get back the original (identity rule)
--2. composing functions and then lifting them is the same as composing lifted functions example at 1:10
--
--EVERY FUNCTION IS A FUNCTOR
--lifting a function
--1:00
--fmap takes a function, and a functor (some kind of box) and returns the modified va;ue inside the "same" box
--ANOTHER WAY
--takes a function and returns a new function that works on boxes
--fmap (1+) works on boxed numbers - lifting a function - (1+) works on numbers
--
--Applicative <*> - same thing as fmap but its an operator
