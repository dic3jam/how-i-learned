
<?php include 'header.php';?>
<?php include 'nav.php';?>

<div style="padding-left:16px">
  <h2>Assign07 - Advanced Web Development</h2>
  <h2>Research</h2>
  <!--writeup goes here-->
  <p>So far SQL seems very human friendly and straightforward. Although, I do get the sense that to truly master an understanding
of everything that MySQL can do would take a considerable amount of time. PHPMyAdmin also seems easy to use, I just cicked my way the SQL section, and copy pasted the Larry Ullman sql.sql queries into the box and ran it (I did have to take a few things out to get it to run). Looking at what it would take to write all of that information by hand, I can see how an application like PHPMyAdmin can save volums of time.</p>
  
  <h2>Before & After CODE</h2>
  <h3>Intermediate - database connect and display</h3>
<?php
ini_set('display_errors',1);
require 'mysqli_connect.php';
echo "This script is just returning the number of message subjects with the term PHP in them\n";
echo "<br>";
$query1 = "SELECT subject FROM messages";
$r = mysqli_query($connect, $query1);
if($r){
	echo "Query ran";
} else {
	echo "Did not run son";
}
echo "<br>";
echo $r->num_rows;
echo " have been imported successfully!";
$r->free_result();
?>
</div>

<?php include 'footer.php';?>

</body>
</html>
