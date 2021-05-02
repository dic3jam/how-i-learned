<?php
ini_set('display_errors',1);

if($_SERVER["REQUEST_METHOD"] == "POST"){
	//if write is set, create save a new xml file with the info
	if($_POST["write"]){
		$name = $_POST["name"];
		$flavor = $_POST["flavor"];
	}	
}
?>

<h2>Choose your favorite ice cream</h2>
<form method="post" action="<?php $_SERVER["PHP_SELF"];?>">
	Name: <input type="text" name="name">
	Flavor:
		<input type="radio" id="flavor" name="flavor" value="vanilla">Vanilla
		<input type="radio" id="flavor" name="flavor" value="chocolate">Chocolate	
		<input type="radio" id="flavor" name="flavor" value="strawberry">Strawberry
	<!--	<input type="text" id="flavor" name="flavor" value="vanilla">Other -->
		<input type="submit" name="write" value="write">
</form>

<?php 
      echo "<h2>Your Results</h2>";
      echo $name;  
      echo "<br>";
      echo $flavor;
      echo "<br>";
?>
