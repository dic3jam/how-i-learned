<?php 
// this is actually a .html file because it doesn't have any php in it 
// but for consistancy - because the calling file is a .php file 
// we usually name all the files .php in case you want to put php code in_array
// it won't break any of the links.
//
?>
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
<div class="topnav" id="myTopnav">
  <a href="index.php" class="active">AdvWD</a>
  <div class="dropdown">
    <button class="dropbtn">Assignments
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
	  <a href="assign01.php">Assign01</a>
      <a href="assign02.php">Assign02</a>
      <a href="assign03.php">Assign03</a>
	  <a href="assign04.php">Assign04</a>
	  <a href="assign05.php">Assign05</a>
	  <a href="assign06.php">Assign06</a>
	  <a href="assign07.php">Assign07</a>
	  <a href="assign08.php">Assign08</a>
      <a href="assign09.php">Assign09</a>
      <a href="assign10.php">Assign10</a>
	  <a href="assign11.php">Assign12</a>
	  <a href="assign12.php">Assign13</a>
	  <a href="assign13.php">Assign14</a>
	  <a href="ProjectOutline.php">Project Outline</a>
	  <a href="Project.php">Final Project</a>
    </div>
  </div> 
  <a href="links.php">Links</a>
  <a href="more.php">More</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
