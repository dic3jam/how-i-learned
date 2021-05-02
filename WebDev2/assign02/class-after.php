<!doctype html>
<html>
<body>
<?php
class fridayNight {
  public $drink;
  public $location;
  public function __construct($drink, $location) {
    $this->drink = $drink;
    $this->location = $location;
  }
  public function message() {
    return "This friday I am going to drink" . $this->drink . " " . $this->location . "!";
  }
}

$friday = new fridayNight("BEER!", "...on my couch :(");
echo $friday -> message();
echo "<br>";
?>
</body>
</html>