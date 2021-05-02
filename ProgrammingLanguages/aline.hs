{- aline.hs
 - Takes a file and writes to STDOUT 
 - the lines in alphabetical order
 - @author Jim DiCesare
 -}
import System.Environment
import System.Directory
import System.IO
import Data.List

main = do
       args <- getArgs
       let len = length args
       if len > 1
          then error "One file only" 
          else return ()
       let file = head args
       handle <- readFile file
       let l = lines handle
       let k = sortOn head l
       mapM_ putStrLn k

