<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$stmt = $conn->prepare("INSERT INTO ice_cream (flavor, company, rating) VALUES (?, ?, ?)");

$flavor = "strawberry";
$company = "ben&jerrys";
$rating = "10";
$stmt->execute();

$flavor = "vanilla";
$company = "hood";
$rating = "10";
$stmt->execute();

echo "New records created successfully";

$stmt->close();
$conn->close();
?>
