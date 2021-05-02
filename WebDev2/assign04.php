
<?php include 'header.php';?>
<?php include 'nav.php';?>

<div style="padding-left:16px">
  <h2>Assign04 - Advanced Web Development</h2>
  <h2>Research</h2>
  <!--writeup goes here-->
  <?php include 'assign04/assign04-writeup.php'?>

  <h2>Before & After CODE</h2>
  <p> Example 1 
  <ul>
	<li> Before:  <a href="assign04/ex1bef.php" target="_blank"> 
                  	     Before</a></li>
	<li> After:   <a href="assign04/ex1aft.php" target="_blank"> 
                             After</a></li>
  </ul></p>
  <p> Example 2 
  <ul>
    <li> Before:  <a href="assign04/ex2bef.php" target="_blank"> 
                  	     Before</a></li>
	<li> After:   <a href="assign04/ex2aft.php" target="_blank"> 
                             After</a></li>
  </ul></p>
  <p> Example 3 
  <ul>
    <li> Before:  <a href="/assign04/ex3bef.php" target="_blank"> 
                  	     Before</a></li>
	<li> After:   <a href="/assign04/ex3aft.php" target="_blank"> 
                             After</a></li>
  </ul></p>

  <h3>PHP Info</h3>
  <br>
  <?php echo phpinfo(); ?>
  <br>
  <h3>MySQL Info</h3>
  <?php 
  echo "MySQL version on ClassWeb.ccv.edu is: ";
  echo mysqli_get_server_info($dbc);
  ?>

</div>

<?php include 'footer.php';?>

</body>
</html>
