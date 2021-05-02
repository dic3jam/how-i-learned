--types always captialized
--lowercase is variable
-- [x | x <- [1..10], x 'mod' 3 == 2]
-- the list of x SUCH THAT -
-- recursive: base case, recursive case that breaks the problem down
-- every function in Haskell takes a single argument - curryin
-- (.) composition ($) application
-- fold - taking a foldable, applyting a function to it, cramming that into an accumulator

sum2 l = fold (+) 0 l 
-- >>sum2 [1..10] 
-- >> 55
-- foldl is a preorder - do the operation as goes into it
-- foldr is postorder - gets all of them out then applies backwards to it
