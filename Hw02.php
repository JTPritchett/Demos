<html>
 <head>
  <title>HW02</title>
 </head>
 <body>
  
 <?php
   echo'<p>HW02, Joshua Pritchett, CS340</p> <br/>';
   echo date("Y/m/d");
   echo '<br/>';  ?>
 <?php

$fh = fopen("input.txt", 'r') or die("File does not exist or you lack permission to open it");
$fo = fopen("output.txt", 'w') or die("Failed to create file");
//We must do this 5 times in order to read all the way through best way in this case
// Tried searching everywhere for a while(!eof)
echo'<table>
    <tr>
        <th>Name</th>
        <th>Height</th>
        <th>Weight</th>
        <th>Intelligence</th>
        <th>Password</th>
    </tr>';
for ($i=0;$i<5;++$i)
{
echo'<tr><td>';
$line=fgets($fh);
$temp = explode(',', $line);
$object=new User($temp[0], $temp[1],$temp[2],$temp[3],$temp[4]);
$object->name=$temp[0];
echo $object->name.'</td><td>'.$object->height.'</td><td>'.$object->weight.'</td><td>'.$object->intelligence.'</td><td>'.$object->password.'</td>';
echo'</tr></td>';
fwrite($fo, $line) or die("Could not write to file");

}


fclose($fo);
 class User
 {
  public $name, $height,$weight,$intelligence,$password;
   
   public function function_construct($name, $height,$weight,$intelligence,$password)
   {
    $this->name=$name;
    $this->weight=$weight;
    $this->height=$height;
    $this->intelligence=$intelligence;
    $this->password=$password;
   }
 }
 ?>
 
 </body>
</html>