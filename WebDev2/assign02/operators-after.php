<!DOCTYPE html>
<html>
<body>

<?php
$array1 = array(5, "Five");
$array2 = array(10, 10);
$array3 = array(10,10,10);
$array4 = array(5,5);

var_dump($array1 === $array2); 
var_dump($array2 === $array3);
var_dump($array2 === $array4);
echo "These will all be false- it seems like the identity 
operator is looking at the contents of the array, rather than just
type checking the contents (cough cough hast table)";
?>  

</body>
</html>