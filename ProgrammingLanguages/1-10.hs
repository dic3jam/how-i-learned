--Problem 1
myLast :: [a] -> a
myLast [] = error "list is empty"
myLast [x] = x
myLast (_:y) = myLast y

--Problem 2
myButLast :: [a] -> a
myButLast [] = error "list is empty"
myButLast [x] = x
myButLast (x:y) = let m = length y
                in if m == 1 
                     then x
                     else myButLast y

--Problem 3 - di not solve
--elementAt :: [a] -> Int -> a
--elementAt [] y = error "list is empty"
--elementAt [x] y = x
--elementAt [x] y = x

elementAt'' :: [a] -> Int -> a
elementAt'' (x:_) 1  = x
elementAt'' (_:xs) i = elementAt'' xs (i - 1)
elementAt'' _ _      = error "Index out of bounds"

--Problem 4 - find the number of elements in a list
myLength :: [a] -> Int
myLength [x] = 1
myLength (x:xs) = 1 + myLength xs

--Problem 5 - reverse a list
myReverse :: [a] -> [a]
myReverse [] = []
myReverse (x:xs) = myReverse xs ++ [x]

--Problem 6 - find out whether a list is a palindrome
isPalindrome :: Eq a => [a] -> Bool
isPalindrome l = if l == myReverse l then True else False

data NestedList a = Elem a | List [NestedList a]

flatten :: NestedList a -> [a]
flatten [] = []
flatten (Elem x) = [x]
flatten (List (x:xs)) = x:flatten xs



