import Data.Set as S
import Data.List as L
-- Exam 1
-- @author Jim DiCesare

--Problem 1 - I know this probably involves building a type,
--I think I'll need to see another example of how to build types
--to solve particualr problems
clamp :: Int -> Int -> Int -> Int
clamp a b c | c <= a = a
            | c >= b = b
            | otherwise =  c
                
--Problem 2
makeSet :: Ord a => [a] -> Set a
makeSet l = L.foldr (\x y -> S.insert x y) S.empty $ sort l

--Problem 3
altSum :: Num a => [a] -> a
altSum [x] = 1
altSum (x:xs) = let k = length xs in
                if even(k) then x + altSum xs
                else altSum xs
