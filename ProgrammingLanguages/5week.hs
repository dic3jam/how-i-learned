import Data.Char
import Data.List
--class1 example
--define and type a function call charTypeFreq that will return a list of tuples from
--a string
--first half of tuple should be the GeneralCategory of a letter and second half should be how common that tuple is in the string
charTypeFreq :: String -> [(GeneralCategory, Int)]
charTypeFreq s = map (\x -> (head x, length x)) $ group $ sort $ map generalCategory s 
{--
--module Shapes 
(
--names of constructors
--no constructors Shapes()
--includes constructors Shapes(..)
Shape(Circle, Rectangle),
move,
area

--if its not up here its not exportable
where -}

--data declares constructors
data Shape = Circle FLoat Float Float
            | Rectangle FLoat Float Float 
                  deriving (Show, Eq)

-- this is better because in general want to avoid strict typing
data Shape' a = Circle a a a
--		
                | Rectangle a a a 
-- 
                deriving (Show, Eq)

area :: Shape -> Float
-- Circle __ r is creating a value with Circle constructor
area (Circle _ _ r) = pi * r ^ 2
area (Rectangle l t r b) = abs $ (l-r) * 

move :: Shape -> Float -> Float -> Shape
move (Circle x y r) dx dy = Circle (x+dx) (y+dy) r
move (Rectangle l t r b) dx dy = Rectangle (l+dx) (t+dy) (r+dx) (b+dy)

--circ :: Shape -> Float
--
-- Class 2 starter:

avgWordLength :: Floating a => String -> a
avgWordLength [] = error "Ya gotta give me something"
avgWordLength s = let fromInt = fromInteger . toInteger in
                       let wordLens = map length $ words s in
                       (fromInt $ sum wordLens) / (fromInt $ length wordLens)

-- average $ length of words $ get length of words $ break up words
-- avgWL example shows avgWordLength in more efficient way - great example of folding lambda into a tuple
-- load module loads whole thing, import only imports what is exportable
--(only do import in .hs file)
--recording from 01MAR quickly goes over modules
--module declarations limited to 1 level of inheritance
--use "new" to construct a new object
--new Circle(x,y,z,e)
--"data" used to declare a constructor
-- \* concrete type
--:kind shows the type and how the constructor works
--uppercase Map is constructor, lowercase map is a function
--
--4 different kinds of things:
--1. data types (are concrete, define constructors)
--2. type classes which are like interfaces (describe sets of behavior)
--3. type constructor ([] or Map)  
--4. concrete types :k *
--:k * -> * means derived from concrete type
--
--	:k Num
--	>> Num :: * -> Constraint
--
data Suit = Club | Diamond | Heart | Spade deriving (Show)

-- kind * -> * (type constructor
-- :k [] -> * -> *

type StringMap = Data.Map.Map String
--:k StringMap
--StringMap :: * -> *
--StringMap Int :: *

data Maybe a = Just a | Nothing
-- Just :: a -> Maybe a
-- Maybe :: * -> *
-- maybe is type not function


data Person = Person String Int Int

firstName :: Person -> String
firstName (Person s _ _) = s

age :: Person -> Int
age (Person _ a _) = a

--OR do it this way:
-- record format
data Person = Person { firstName :: String
                       , lastName :: String
                       , age :: Int
                       } deriving (Show, Eq, Read)

Person{firstName="Abe", lastName="Lincoln"

-- (:) concat operator (++)

-- this class means NOTHING like a class in imperative languages. more like a constraint
class Eq a where
    (==) :: a -> a -> Bool
    (/=) :: a -> a -> Bool
    x == y = not (x /= y)
    x /= y = not (x == y)

-- defining the behavior for defined functions of your created type class WHEN DO NOT USE DERIVING
instance Show Suit where
    show Club = "Club"
    show Diamond = "Diamond"
    show Heart = "Heart"

instance Eq Suit where
    Club == Club = True
    Diamond == Diamond = True
    _ == _ = False
