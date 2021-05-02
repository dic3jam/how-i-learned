<!DOCTYPE html>
<html>
<body>

<?php
$numbers = array(4, 6, 2, 22, 11);
rsort($numbers);

$arrlength = count($numbers);
for($x = count($numbers); $x >= 0; $x--) {
  echo $numbers[$x];
  echo "<br>";
}
?>

</body>
</html>
