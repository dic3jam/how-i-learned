module Locker
(lock
,unlock
)
where

data Locker a = Locker {k :: Int, v :: a}

type Key = Int

instance Functor Locker where
    fmap f (Locker k v) = Locker k (f v) 

instance Show (Locker a) where
   show (Locker k v) = "*SECRET*" 

lock :: Key -> a -> (Locker a)
lock k v = Locker k v

unlock :: Key -> Locker a -> Maybe a
unlock t (Locker k v) = if t == k then Just v else Nothing
