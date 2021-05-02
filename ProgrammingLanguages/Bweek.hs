--Bweek
--
--Monday
--
-- everything is immutable
-- big disadvantage can only go in one direction
-- have to copy entire list to add something to the end of it
-- allocating memory is expensive so sharing is preferrable

--zipper - usage thing not pre-exisitng
--this is a way to keep the state of a pointer in a list
--good data structure if need to move forward and backward adding/removing items

type ListZipper a = ([a],[a])
--first list is all elements in front of pointer, second is all elements behind you 
--(in reverse order as well - more efficient)

goForward :: ListZipper a -> ListZipper a
goForward (x:xs, bs) = (xs, x:bs)

goBack :: ListZipper a -> ListZipper a
goBack (xs, b:bs) = (b:xs, bs)

zipHead :: ListZipper a -> a
zipHead ([],(x:_)) = x
zipHead ((x:_),_) = x

zipElem :: ListZipper a -> a
zipElem ((x:_),_) = x


