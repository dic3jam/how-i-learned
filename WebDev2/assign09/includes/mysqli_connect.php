<?php # Script 17.x - mysqli_connect.php

ini_set('display_errors',1);
// This file contains the database access information. 
// This file also establishes a connection to MySQL 
// and selects the database.

// Set the database access information as constants:
DEFINE ('DB_USER', 'jmd06260');
DEFINE ('DB_PASSWORD', 'a2umepyqa');
DEFINE ('DB_HOST', 'localhost');
DEFINE ('DB_NAME', 'jmd06260_wordpress');

// Make the connection:
$dbc = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) OR die ('Could not connect to MySQL: ' . mysqli_connect_error() );

// Set the encoding...
mysqli_set_charset($dbc, 'utf8');

// Use this next option if your system doesn't support mysqli_set_charset().
//mysqli_query($dbc, 'SET NAMES utf8');

?>
