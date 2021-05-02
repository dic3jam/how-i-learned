<?php
//$_POST = array("name"=>"Jim", "flavor"=>"Chocolate");
foreach ($_POST as $p => $val) 
	echo $p ." => " . $val;

$name = $_POST["name"];
$flavor = $_POST["flavor"];
$filename = "CCV_" . $name . ".xml";

if(file_exists($filename))
	unlink($filename);
	//write_icecream($filename, $flavor);
new_icecream($filename, $name, $flavor);

	/*it is ridiculous how hard it is to change the value of 1 tag
function write_icecream($filename, $flavmr) {
	$dom = new DOMDocument('1.0', 'UTF-8');
	$dom->formatOutput = true;
	$dom->load($filename, LIBXML_NOBLANKS);
	$root = $dom->documentElement;
	$flavor_old = $root->childNodes(1);

	$flav = $dom->createElement('flavor', $flavor);
	$root->replaceChild($flavor_old, $flav);
	echo '<xmp>' . $dom->saveXML() . '</xmp>';
	$dom->save($filename) or die ('Unable to create XML file');
}
*/
function new_icecream($filename, $name, $flavor) {
	$dom = new DOMDocument('1.0', 'UTF-8');
	$dom->formatOutput = true;

	$root = $dom->createElement('person');
	$dom->appendChild($root);

	$att1 = $dom->createElement('name', $name);
	$root->appendChild($att1);

	$att2 = $dom->createElement('flavor', $flavor);
	$root->appendChild($att2);

	echo '<xmp>' . $dom->saveXML() . '</xmp>';
	$dom->save($filename) or die ('Unable to create XML file');
}
?>
