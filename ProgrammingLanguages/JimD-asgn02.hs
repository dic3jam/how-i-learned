import Prelude as P
import Data.Map as M
import Data.List as L
-- Assignment 02
-- @author Jim DiCesare

{-Problem 1- countValue
 -Inputs: Int x and list of Ints y
 -Returns: Int representing the number of occurences of 
  x in list y 
 -}
--V1
countValue :: Int -> [Int] -> Int
countValue _ [] = error "empty list"
countValue x y = length $ P.filter (==x) y
--V2
countValue' :: Int -> [Int] -> Int
countValue' _ [] = error "empty list"
countValue' x y = length [z | z <- y, z == x]
--Corrected - no need for error case
countValue'' :: Int -> [Int] -> Int
countValue'' z (x:y) = if x == z then 1 + countValue z y else countValue z y

{-Problem 2 - applyWhile
 - Inputs: A boolean function, a function, and accumulator
 - Returns: first instance where f(Int) no longer holds the boolean
-}
applyWhile :: (Ord a, Num a) => (a -> Bool) -> (a -> a) -> a -> a
applyWhile b f a = let c = f a in
                   if not(b $ c) then c 
                   else applyWhile b f c
--Corrected remove $ from not(b $ c) 

{-Problem 3 - wordFreq
 - Inputs: String
 - Returns: The number of times each word appeared in the string
-}
wordFreq :: String -> Map String Int
wordFreq [] = error "Empty string"
wordFreq x = fromList $ L.map (\x -> (head x, length x)) $ group $ sort $ words x
--Corrected no need error case. 
wordFreq' :: String -> Map String Int
wordFreq' x = L.foldr (\w m -> M.insertWith (+) w 1 m) M.empty $ words x

{- Problem 4 - Returns the n most common words from a string as ordered strings (most common -> n least common)
 - Inputs: String a - string to analyze, Int b - number of most common words to return
 - Returns: String - n of the most common words from the string
 -}
wordFreqN :: String -> Int -> [String]
wordFreqN [] n = error "Empty string"
wordFreqN s n = L.take n $ L.map (\(x,_) -> x) $ reverse.sortOn snd $ toList $ wordFreq s
