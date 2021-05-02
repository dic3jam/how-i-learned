-- simp-funcs.hs
-- @author Jim DiCesare


{- basicMath: takes 2 Ints, calculates sum, difference,
 - product, quotient, and returns a tuple of that information
 - Parameters: Int a Int b
 - Returns: Tuple of sum, difference, product, quotient of the 2 parameter Ints
 -}
basicMath :: Integral a => a -> a -> (a,a,a,a)
basicMath a b           
          | b == 0 = (a + b, a - b, a * b, 0)
          | otherwise = (a + b, a - b, a * b, div a b)

{- factors: returns a list of all the factors of a given number
 - parameters: Int a
 - Returns: [Int]
 -}
factors :: Integral a => a -> [a]
factors x = [ b | b <- [1..x], c <- [x,x-1..1], b*c == x ]

{- compute:takes a tuple with an operator (given as a single character) and two numbers and returns the value from computing the result of that operation on the given numbers.
 - Parameters: (Char, Int, Int)
 - Returns: Int, -1 if invalid operator or attempt to divide by 0
 -}
compute :: (Char,Int,Int) -> Int 
compute (op,a,b)  
    | op == '+' = a + b
    | op == '-' = a - b
    | op == '*' = a * b
    | op == '/' = if b > 0 then div a b else -1
    | otherwise = -1

compute' :: (Char, Int, Int) -> Int
compute' ('+',a,b) = a + b
compute' ('-',a,b) = a - b
compute' ('*',a,b) = a * b
compute' ('/',a,b) = a / b

{-corn: accepts the number of ears of corn the customer 
 - is purchasing and outputs the total price
 - Parameters: Double, positive
 - Returns: Double, -1 if input in error
 -}
corn :: Double -> Double
corn x
    | x <= 12 = x * 0.5
    | x > 12 && x <= 23 = x * 0.45
    | x >= 24 && x <= 35 = x * 0.4
    | x > 35 = x * 0.35
    | otherwise = -1

