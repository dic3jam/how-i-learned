<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO ice_cream(flavor, company, tastiness) VALUES ('strawberry', 'ben&jerrys', '10');";
$sql .= "INSERT INTO ice_cream(flavor, company, tastiness) VALUES ('vanilla', 'hood', '10');";
$sql .= "INSERT INTO ice_cream(flavor, company, tastiness) VALUES ('chocolate', 'hood', '8');";

//the append and equals operator is pretty cool I wish more languages did that

//they really like their strictly strictly equal operator huh? === does same thing as == for primitives
if ($conn->multi_query($sql) === TRUE) {
  echo "New records created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
