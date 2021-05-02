module Example.ExpressionTree
(
evaluate,
)
where

data ExpressionTree a = ValueNode a | OpNode {f :: a -> a -> a, functype :: String, ltree :: ExpressionTree a, rtree :: ExpressionTree a}

instance (Show a) => Show (ExpressionTree a) where
    show (ValueNode a) = (show a ++ " ")
    show (OpNode f functype ltree rtree) = show functype ++ show ltree ++ show rtree

evaluate :: ExpressionTree a -> a
evaluate (ValueNode a) = a
evaluate (OpNode f func ltree rtree) = f (evaluate ltree) (evaluate rtree) 
