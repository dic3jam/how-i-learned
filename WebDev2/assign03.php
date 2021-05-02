
<?php include 'header.php';?>
<?php include 'nav.php';?>

<div style="padding-left:16px">
  <h2>Assign03 - Advanced Web Development</h2>
  <h2>Research</h2>
  <p>I have not used Google's Advanced Search features in almost 10 years as Google has improved to the point that you can almost narrow your search by entering more data into the actual search bar. I find that for 90% of the things I am looking for I can just add more to the search bar and get closer to what I need. I think those advanced search tools are great for filtering by time. Sometimes I find myself looking for something less on the beaten path and I keep running into articles from 3 or more years ago. Since this is Software, that makes most of the information irrelevant. You have to keep modifying the search to get something closer in time. But maybe the advanced search tools would be better.</p>

<p>Note: I have redone the whole site as before I had simply copy/pasted the example site. The new content is "nested" from the old but of my own work.</p>

<p>Which is why that bar is messed up - I plan to fix that soon!</p> 

  <p>Link 1:  <a href="https://support.google.com/websearch/answer/35890?co=GENIE.Platform%3DAndroid&hl=en" target="_blank"> 
                      Advanced Search</a></p>
<!--
  <p>Link 2:  <a href="" target="_blank"> 
                      link</a></p>
  <p>Link 3:  <a href="https://www.vim.org/" target="_blank"> 
                      link</a></p>
-->

  <h2>Before & After CODE</h2>
  <p> Example 1 
  <ul>
	<li> Before:  <a href="https://www.w3schools.com/php/phptryit.asp?filename=tryphp_if" target="_blank"> 
                  	     Before</a></li>
  </ul></p>
  <p> Example 2 
  <ul>
    <li> Before:  <a href="https://www.w3schools.com/php/phptryit.asp?filename=tryphp_loop_foreach" target="_blank"> 
                  	     Before</a></li>
  </ul></p>
  <p> Example 3 
  <ul>
    <li> Before:  <a href="https://www.w3schools.com/php/phptryit.asp?filename=tryphp_loop_while" target="_blank"> 
                  	     Before</a></li>
  </ul></p>
  <p>Overall After
  <ul>
    	<li> After:   <a href="assign03/array-loops-after.php" target="_blank"> 
                             After</a></li>
        <blockquote> 
	//Not trying to show off here but since my background 
	//is more in strict programming, I thought I would 
	//write a small PHP program to demonstrate arrays, loops
	//and if/else statements. I also found the foreach loop
	//to be particularly intriguing and wanted to try exercising it

	function loopdeloop() {
	$i = 20;
	while($i > 0) {
		$array1 = range(0,$i);
		foreach($array1 as $value) {
			$value *= 2;
			echo $value, ", ";	
		}

		$i--;
		echo "<br>";
	}
	}

	loopdeloop();

	return 0;

        </blockquote>

  </ul></p>

</div>

<?php include 'footer.php';?>

</body>
</html>
