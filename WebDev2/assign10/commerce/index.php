<?php # Script 19.5 - index.php
// This is the main page for the site.
ini_set('display_errors',1);

// Set the page title and include the HTML header:
$page_title = 'Make an Impression!';
include ('includes/header.html');
?>

<p><a href="admin/add_artist.php" target="_blank">Add Artist</a></p>
<p><a href="admin/add_print.php" target="_blank">Add Print</a></p>

<?php include ('includes/footer.html'); ?>
