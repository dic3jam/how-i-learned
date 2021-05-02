einstein :: Double -> Double
einstein x = x * c
   where c = (2.99982**8)**2

einstein' :: Double -> Double
einstein' x = let c = (2.99982**8)
                  in x*c^2

hi :: Int -> [Char] -> [String]
hi n x
    | n > 0 = hi (n-1) (x ++ "hi")
