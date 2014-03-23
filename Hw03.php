<html>
    <head>
     <title>HW03</title>   
    </head>
    
        <body>
<?php
    echo'<p> I would like to do the Python:Hundred Nights Project<br/>';
    echo'The other choice would be PHP:Foodbank becuase PHP is hot right now<br></p>';
    echo "<a href=http://localhost/Hw01.php>My Hw01</a><br/>";
    echo "<a href=http://localhost/Hw02.php>My Hw02</a><br/>";
?>
<?php
include_once "userinfo.php";
$host="localhost";
$username="username";
//$password="password";
$database="hw03";
$user=false;

$fh=fopen('input.txt','r') or die ('The file does not exist goof');//checks for inputfile to be read in
$fo = fopen("output.txt", 'w') or die("Failed to create file");// required output file

//Database Work
$connect=mysql_connect($host,$username);// registers a database to the de_sever variable
if(!$connect) die("Server does not exist or cannot connect:".mysql_error());
$sql='CREATE DATABASE user';
mysql_select_db($database)// selects the database in which we want to connect
    or die("Unable to select database:".mysql_error());

//Set up a query to the database
if($user==false)// Keeps reamaking the stuff AHH!!
{// found the primary ID this gem would prevent redundencies in a way! YESSS well hopefully
mysql_query("CREATE TABLE  user(
			name VARCHAR(32) NOT NULL,
                        height SMALLINT NOT NULL ,
                        weight SMALLINT NOT NULL ,
                        intelligence SMALLINT NOT NULL ,
                        password VARCHAR(32) NOT NULL,
                        PRIMARY ID(name)
                        )");

//Adding to the Database
for ($i=0;$i<5;++$i)
{
echo'<tr><td>';
$line=fgets($fh);
$temp = explode(',', $line);
$object=new Info($temp[0], $temp[1],$temp[2],$temp[3],$temp[4]);
mysql_query("INSERT INTO user(name,height,weight,intelligence,password) VALUES(
                       '$object->name',
                       '$object->height',
                       '$object->weight',
                       '$object->intelligence',
                       '$object->password'
                       )");

//echo  $object->name .'</td><td>'.$object->height.'</td><td>'.$object->weight.'</td><td>'.$object->intelligence.'</td><td>'.$object->password.'</td>';
$objectarray[]=$object;
echo'</tr></td>';
//fwrite($fo, $line) or die("Could not write to file");

}
$user=true;
}
//Query the DataBase for output
$query = "SELECT * FROM user";
$result = mysql_query($query);
if (!$result) die ("Database access failed: " . mysql_error());
$rows = mysql_num_rows($result);
for ($j = 0 ; $j < $rows ; ++$j)
{
echo'<tr><td>';
echo 'name: ' . mysql_result($result,$j,'name') . '<br /></td><td>';
echo 'height: ' . mysql_result($result,$j,'height') . '<br /></td><td>';
echo 'weight: ' . mysql_result($result,$j,'weight') . '<br /></td><td>';
echo 'intelligence: ' . mysql_result($result,$j,'intelligence') . '<br /></td><td>';
echo 'password: ' . mysql_result($result,$j,'password') . '<br /></td><td>';
echo'</tr></td>';

}
// Write out to a file php
$res = mysql_query("SELECT name,height,weight,intelligence,password FROM user");
// write each row's data to text file
while ($row = mysql_fetch_assoc($res))
{
    fwrite ($fo, "{$row['name']}\t{$row['height']}\t{$row['weight']}\t{$row['intelligence']}\t{$row['password']}\r\n");
}

fclose($fh);
fclose($fo);
// Use this for testing queries since debugging sucks in this haha
//$result = mysql_query($query);
//if(!$result)
//{
//die(mysql_error());
//}

?>

        </body>
   
</html>
