<!DOCTYPE html>
<html>
<body>

<?php
$fav_food = array("Jim"=>"pasta", "Hope"=>"burgers", "Joey"=>"mac and cheese");

foreach($fav_food as $peep => $food) {
  echo "Person=" . $peep . ", Food=" . $food;
  echo "<br>";
}
?>

</body>
</html>
