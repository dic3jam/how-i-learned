<p>How does PHP read from a file on the server?</p>

<p>More importantly why did they bother to create the language of PHP if it is at least a 90% copy of C?
Slight aside: all of the languages I know these days (except for Haskell) are C based - I am starting to get them all confused.
What if we just had C syntax and added some apis for server side scripting? 
Anyways: PHP utilizes the fopen() function to "open" a file descriptor and assign the FILE struct to a variable. While declaring 
the file struct with fopen() you need to specify a "mode". The variations of this are read/write and where you want the file pointer
to start from. With this variable as proxy for a file poitner pointing to the beginning of the file, we can begin to iterate through 
the file to "read" it. The function fgets() will move the file pointer from \n to \n reading in the contents to a buffer that you can
manipulate. The easiest way to iterate over a file is to combine a while loop with the feof() function. feof() will signal when it reads
that the end of file marker is set for the current stream (open file). Note that you want to use a ! (not) condition with feof(file pointer) 
that way you can continue to iterate as long as the end-of-file marker is not set (ie we have not iterated to the end of the file). Once 
you have read everything in, you must ensure that you close the file with fclose(). Otherwise the file struct will continue to exist on a
oage somewhere just taking up space (and leaving a vulnerability for hackers to inject code)</p>

<p>How does PHP write to a file on the server?</p>

<p>To write to a file you jsut call fopen() with a variation of the "w" flag. Then use the fwrite() function to write something to the file. The file pointer
will iterate across the file as you make successive calls to fwrite(). Don't forget to close the file with fclose() when done.</p>

<p>Do you have to change the File Permissions on the Server to allow files to be Read/Written/Updated?</p>

<p>It seems that file permissions for my sentora files are automatically set to "read/write". For added security on the files where it could be important I would
need to change that. At first glance it does not seem that Sentora supports the permission bits like Linux does.</p>


<!--  <p>Link 1:  <a href="" target="_blank"> 
                      link</a></p>
  <p>Link 2:  <a href="" target="_blank"> 
                      link</a></p>
  <p>Link 3:  <a href="https://www.vim.org/" target="_blank"> 
                      link</a></p>
->>
