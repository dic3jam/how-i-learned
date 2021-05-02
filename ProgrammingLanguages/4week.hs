evenMore :: (Integral a) => [a] -> [a]
evenMore x = [if a `mod` 2 == 0 then (a+1) else a | a <- x]

evenMore' :: (Integral a) => [a] -> [a]
evenMore' = map (\a -> if a `mod` 2 == 0 then a+1 else a)


--rreverse :: [a] -> a
--rreverse foldr (\a b -> b ++ [a]) []

onlyEvenMore :: (Integral a) => [a] -> [a]
onlyEvenMore x = map (+1) $ filter even x
