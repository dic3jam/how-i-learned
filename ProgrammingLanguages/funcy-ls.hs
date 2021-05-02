import System.Environment
import System.Directory
import System.IO
import Data.List

--clean up main?
--checkArgs :: IO [String] -> String
--checkArgs [] = "."
--checkArgs x = do

main = do
       args <- getArgs
--     dir <- checkArgs args
       let len = length args
       if len > 1
          then error "One directory only" 
          else return ()
       let dir = (if len < 1
                   then "."
                   else head args)
       ex <- doesDirectoryExist dir
       if not ex
          then error "Directory does not exist"
          else return ()
       ls <- listDirectory dir 
       setCurrentDirectory dir
       process ls

process :: [FilePath] -> IO ()
process [] = do print "funcy"
process (x:xs) = do
        dir_test <- doesDirectoryExist x
        if dir_test
           then dir_pro x
           else file_pro x
        process xs

dir_pro :: FilePath -> IO ()
dir_pro dir = do
        putStr dir
        putStrLn "/"
        putStr "    "
        rec_dir <- listDirectory dir
        print rec_dir
--        putStrLn " "


file_pro :: FilePath -> IO ()
file_pro x = do 
        putStr x
        putStr " "
        perms <- getPermissions x
        let ex = executable perms
        if ex 
           then putStr "X" 
           else putStr "NX"
        putStr " "
        size <- getFileSize x 
        putStr $ show size 
        putStr " "
        time <- getAccessTime x
        putStr $ show time
        putStrLn " "


   
   
