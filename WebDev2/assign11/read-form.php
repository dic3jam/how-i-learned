<?php
//$_POST = array("name"=>"Jim", "flavor"=>"Chocolate");

$name = $_POST["name"];
$filename = "CCV_" . $name . ".xml";

$dom = new DOMDocument;
$dom->load($filename);

$children = $dom->documentElement->childNodes;
foreach($children as $chitlins) {
    echo $chitlins->nodeValue;
}
/*
$out_name = $dom->documentElement->childNodes[1]->nodeValue;
$out_flavor =  $dom->documentElement->childNodes[2]->nodeValue;
*/
?>
