-- Assignment 02
-- @author Jim DiCesare

{-Problem 1- countValue
 -
 -
 -}
countValue :: Integral a => a -> [a] -> [a]
countValue _ [] = error "empty list"
countValue _ [y] =
countValue x (y:ys) 
           | y == x    = x : countValue x ys
           | 
           | otherwise = countValue x ys


--prob 3 use insert with
