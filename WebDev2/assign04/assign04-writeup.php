<p>I promised myself this semester that I would break away from just using Vim all the time 
and would adopt a real IDE (VSCode) and get very familair with its inner workings. Therefore for
researching debugging PHP and SQL, I learned how to use the PHP Debug and mssql VSCode extensions.
i</p>
<p>From what I can gather, doing PHP debugging in the conventional terminal is very much a pain. 
PHP has built-in debugging functions that you can slide into your code to print values to the std_out
(like printf in C) but anything beyond that involves accessing logs, using extra tools, etc.
To enable PHP debugging in VSCode you need to add the PHP Debug, and the XDEbug extensions. Next,
install the actual xdebug program (available through apt if you are awesome and use Linux). Then
you need to modify your php.ini so your local PHP server will allow for debugging. Finally, use the links
launch.json configurations and you can debug php in VSCode!
</p>
<p>
Debugging for MySQL is slightly an arbitrary concept. Namely you need to have an available database and the tooliing to do so.
For VSCode you would need to add the SQLTools extension, plus some other programs running on the server computer. Once
you have a server connection established within VSCode, you can launch the debugging tools for a mysql script just like 
any other debug session.
</p>
  <p>Link 1:  <a href="https://stackify.com/php-debugging-guide/" target="_blank"> 
                      Debugging PHP (with VSCode</a></p>
  <p>Link 2:  <a href="https://blogs.oracle.com/mysql/howto:-using-the-mysql-debugger-inside-the-visual-studio-ide" target="_blank"> 
                      Debugging MySQL in VSCODE</a></p>
