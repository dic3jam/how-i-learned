--Week 10 - Monads, Foldables

--Foldable is built from tree of monoids
--
--Monad short circuits sequencing
--introduces non-determinism
-- as in do not know which values will be computer first
[(1+),(2*)] <*> [1,2]
-- >> [1,2,2,4]
--not completed in any specific order
--
--MonadPlus - merging of Monoid and Monad
--rewatch this lecture
--
--Monads are for sequencing
--IO, Maybe are for error sequencing
--lists are non-determinism error sequencing
--
--other ways to use Monads

