type Time = (Int,Int,String)

nextTime :: Time -> Time
nextTime (h,59,n) = (h+1,0,n)
nextTime (h,m,n) = (h,m+1,n)

--type errorTypes = Integral | [] 

error' :: [a] -> String
error' a = "This is an error"

zip :: [a] -> [b] -> [(a,b)]
zip [a] [b] = [ a | 
