describeList :: [a] -> String
describeList [] = "Empty"
describeList [_] = "Singleton"
describeList [_,_] = "Two-element list"
describeList l = (show (length l)) ++ "--element list"

roman :: Int -> String
roman n
    | n < 0 = "Romans do not believe in 0"
    | n == 0 = ""
    | n >= 1000 = take (n 'div' 1000) (repeat 'M') ++ roman (n 'mod' 1000)
    | n >= 900 = "CM" ++ roman (n-900)
    | otherwise = take n (repeat 'I')
--...
--

quadroots :: Floating t => t -> t -> (t,t)
quadroots a b c = ((-b + discrim)/denom, (-b - discrim)/denom)
    where discrim = sqrt (b^2 - 4*a*c)
          denom = (2*a)

-- let or where can sometimes be a matter of taste
-- let comes first, where comes after
-- let is not really that wieldy with a guard - where works perfectly

quadroots a b c = let discrim = sqrt (b^2 - 4*a*c)
                      denom = (2*a)
                  in ((-b + discrim)/denom, (-b - discrim)/denom

--let super short scopr just between the let and in
--in this example it is the whole function, where goes on bottom and applies to the whole function - let is just where its at
-- let is AN EXPRESSION

doubler :: Num a => [a] -> [a]
doubler [] = []
doubler (a:b) = let double x = 2 * x
                in double a : doubler b

-- : is like a pop from a stack except that it does not remove anything. this is basically splitting the top element (a) from the rest of the list (b) doubling a, putting it back, then recursively moving onto the next item

fib :: Integral a => a -> a
fib n = case n of 0 -> 1
                  1 -> 1
                  otherwise -> (fib (n-1)) * (fib (n-2))

describeList1 xs = "The list " ++(show xs)++" is "++
              case xs of
                   [] -> "empty."
                   [_] -> "a singleton list."
                   I -> (show (length xs))++"-element list."



