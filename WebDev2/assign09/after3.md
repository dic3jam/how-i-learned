	<?php

	require mysqli_connect.php;

	$new_table = "CREATE TABLE table1 )
		id INT UNSIGNED AUTO INCREMENT,
		name VARCHAR(20) NOT NULL,
		ice_cream VARCHAR(20) NOT NULL,
		PRIMARY KEY (id)
		)";

	if($conn->query($new_table) == TRUE) {
			echo "Good!";
		} else {
			echo "ERROR" . $conn->error;
		}
		$conn->close();
		?>
