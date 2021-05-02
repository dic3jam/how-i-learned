-- map - applies a function to elements
-- filter - throw away elements that do not match a test
-- fold - iterate through a list and cram it into a single value
--
-- putStrLn -> IO ()
-- Io of () means IO of nothing
--
--
-- putStr (putStrLn without linefeed)
-- print - will print any showable
-- print 3
-- >> 3
--
--main = putStrLn "Hello World!"

-- getLine takes input into IO String
-- do makes code look more imperative
{-
main = do
   putStrLn "What is your name?"
   name <- getLine
   let reply = "Hello, " ++ name ++ ". Shall we play a game?"
   putStrLn reply
   answer <- getLine
   putStrLn "it would be fun"
-}
--referential transparency - if you evaluate the same code, get the same answer
--Haskell's selling point is referential transparency - so getLine in the above is returning 2 different things
--so violates that - which means that do blocks are IMPURE!!! the <- means "everything to the right is DIRTY"
--type of do block is last line of it, which must be an expression so at minimum put conventional return "something" must return an IO something if no return then it will be of type IO ()
--traditionally do not put type on main
addSum :: Int -> IO String
addSum n = do
   value <- getLine
   let num = read value :: Int
   if num < 0
     then
       return (show n)
     else
       addSum (n+num)
{-
--main = do
   answer <- addSum 0
   putStrLn answer
 -}

-- around 1:00 mark
--think instead of using loops use recursion, fold, map, or filter
--sequence $ map print [1..10]
--1
--2
--3
--continued
--[(),{},{}..}
-- 
--interact method performs getContents and applies the user input to function at right 
--see wc3.hs
--
--System.IO - files
--openFile :: FilePath -> IOMode -> IO Handle
--IOMode is your read,write,append modes
-- do { handle <- openFile "file.hs" ReadMode; return handle}
-- hClose open handles
-- readFile opens, does a gets contents -> IO String, then closes the file
{-
main = do
    str <- getContents
    putStrLn str
-}
-- do block has to have a final value of an IO something
-- getArgs :: IO [String]
-- getProgName :: IO String
-- can run these within main to get 
-- import System.environment
    
--cat.hs
import System.Environment

main = do
   (filename:_) <- getArgs
   entireFile <- readFile fileName
   putStr entireFile
 
--Using Maybe to deal with IO failures
--
--data Maybe a = Just a | Nothing deriving (show,....)
--:t Nothing - Nothing :: Maybe a
-- data Either a b = Left a | Right b
--
-- Implementing Try Catch
--
{-
main = tryRead 'catchIOError' handler

tryRead :: IO ()
tryRead = do
      (path:_) <- getArgs
      contents <- readFile path
      putStrLn $ path ++ " has " ++ (show(length (lines contents))) ++ " lines"

handler :: IO Error -> IO()
handler e  
    | isDoesNotExistError e
    | isPermissionError e = putStrLn $ "not allowed" 
    | putStrLn $ "unknown file: " ++ show e
    | otherwise ioError e
-}
-- about 50 minutes into class goes over how he built this handler

 
