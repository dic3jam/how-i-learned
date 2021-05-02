{--disk.hs
 - defining the Optical Disk data type
 - @author Jim DiCesare
 -}

type Duration = (Int, Int) --minutes, seconds

type Song = (String, Duration)

data Disk = CD { title :: String, artist :: String, year :: Int, songs :: [Song] } 
          | DVD { title :: String, year :: Int, duration' :: Duration } deriving Eq

instance Show Disk where
   show (CD title artist _ _) = artist ++ ": " ++ title
   show (DVD title year _)  = title ++ " (" ++ (show year) ++ ")"

duration :: Disk -> Duration
duration (DVD _ _ d) = d
duration (CD _ _ _ songs) = let x = map (\(_,y) -> y) songs in
                              let min = map fst x in
                                let sec = map snd x in
                                  timer' ((foldl1 (+) min),(foldl1 (+) sec))

timer' :: (Int,Int) -> (Int,Int)
timer' (a,b)  
             | b < 60 = (a,b)
             | b > 60 = let sec = mod b 60 in
                         let min = div b 60 in
                       ((a+min),sec) 
                                
