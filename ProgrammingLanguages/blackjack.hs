import Example.Cards
import System.Random

main = do
      putStrLn "how many cards?"
      num <- getLine
      let draw = read num :: Int
      let d = shuffle (mkStdGen draw) fullDeck 
      let hand = fst $ drawHand draw d
      let count = totalCards hand
      putStrLn $ "Hand of" ++ show hand ++ "totals " ++ show count

drawHand :: Int -> Deck -> ([Card],Deck)
drawHand 1 d = let (a,b) = draw d in (a:[],b)
drawHand c d = let (x,y) = draw d in
                let (z,w) = drawHand (c-1) y in
                  (x:z,w) 

totalCards :: [Card] -> Maybe Int
totalCards hand = let x = foldr (coolFunction) 1 hand in
                    if x > 21
                       then Nothing
                       else Just x

--I found it really cool how this works. 
--also with this function I now fully get 
--composition
coolFunction :: Card -> Int -> Int
coolFunction = ((+).fromEnum.getRank)
