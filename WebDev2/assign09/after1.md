	<?php
	ini_set('display_errors',1);
	$servername = "localhost";
	$username = "jmd06260";
	$password = "a2umepyqa";
	$dbname = "jmd06260_wordpress";

	$connect = new mysqli($servername, $username, $password, $dbname);

	if($connect->connect_error){
		die("Could not connect". $connect->connect_error);
	}

	echo "Connected to database! Go me!\n";
	echo "<br>";
	?>
