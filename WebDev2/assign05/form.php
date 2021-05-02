<h2>Choose your favorite ice cream</h2>
<form method="post" action="write-form.php">
	Name: <input type="text" name="name">
	Flavor:
		<input type="radio" name="flavor" value="vanilla">Vanilla
		<input type="radio" name="flavor" value="chocolate">Chocolate	
		<input type="radio" name="flavor" value="strawberry">Strawberry
		<input type="text" name="flavor">Other
		<input type="submit" name="submit" value="write" target="_self">
</form>

<h2>Look up your favorite flavor</h2>
<form method="post" action="read-form.php">
	 Name: <input type="text" name="name">
	<input type="submit" name="submit" value="read" target="_self">
</form>
<br>
<br>
