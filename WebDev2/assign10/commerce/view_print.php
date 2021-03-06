<?php # Script 19.7 - view_print.php
// This page displays the details for a particular print.
ini_set('display_errors',1);

$row = FALSE; // Assume nothing!

if (isset($_GET['pid']) && filter_var($_GET['pid'], FILTER_VALIDATE_INT, array('min_range' => 1)) ) { // Make sure there's a print ID!

	$pid = $_GET['pid'];
	echo $pid;
	
	// Get the print info:
	require ('mysqli_connect.php'); // Connect to the database.
	$q = "SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS artist, print_name, price, description, size, image_name FROM e_artists, e_prints WHERE e_artists.artist_id = e_prints.artist_id AND e_prints.print_id=$pid";
	$r = mysqli_query ($dbc, $q);
	if (mysqli_num_rows($r) == 1) { // Good to go!

		// Fetch the information:
		$row = mysqli_fetch_array ($r, MYSQLI_ASSOC);
	
		// Start the HTML page:
		$page_title = $row['print_name'];
		include ('includes/header.html');
	
		// Display a header:
		echo "<div align=\"center\">
		<b>{$row['print_name']}</b> by 
		{$row['artist']}<br />";

		// Print the size or a default message:
		echo (is_null($row['size'])) ? '(No size information available)' : $row['size'];

		echo "<br />\${$row['price']} 
		<a href=\"add_cart.php?pid=$pid\">Add to Cart</a>
		</div><br />";
	
		// Get the image information and display the image:
		if ($image = @getimagesize ("images/$pid")) {
			echo "<div align=\"center\"><img src=\"show_image.php?image=$pid&name=" . urlencode($row['image_name']) . "\" $image[3] alt=\"{$row['print_name']}\" /></div>\n";	
		} else {
			echo "<div align=\"center\">No image available.</div>\n"; 
		}
		
		// Add the description or a default message:
		echo '<p align="center">' . ((is_null($row['description'])) ? '(No description available)' : $row['description']) . '</p>';
	
	} // End of the mysqli_num_rows() IF.
	
	mysqli_close($dbc);

} // End of $_GET['pid'] IF.

if (!$row) { // Show an error message.
	$page_title = 'Error';
	include ('includes/header.html');
	echo '<div align="center">This page has been accessed in error!</div>';
}

// Complete the page:
include ('includes/footer.html');
?>
