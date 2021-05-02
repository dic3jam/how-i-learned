<?php
//Not trying to show off here but since my background 
//is more in strict programming, I thought I would 
//write a small PHP program to demonstrate arrays, loops
//and if/else statements. I also found the foreach loop
//to be particularly intriguing and wanted to try exercising it

function loopdeloop() {
	$i = 20;
	while($i > 0) {
		$array1 = range(0,$i);
		foreach($array1 as $value) {
			$value *= 2;
			if ($value % 3 == 0) {
				echo "cat, ";
				continue;
			} else {
				echo $value, ", ";	
			}
		}

		$i--;
		echo "<br>";
	}
}

loopdeloop();

return 0;

?>
