
	<?php 
	
	require mysqli_connect.php;

	$query = "CREATE database DB1";
	if($conn->query($query) == TRUE) {
		echo "Good!";
	} else {
		echo "ERROR" . $conn->error;
	}
	$conn->close();
	?>
