<?php
class Info
{
public $name,$height,$weight,$intelligence,$password;

public function __construct($name,$height,$weight,$intelligence,$password)
    {
        $this->name=$name;
        $this->height=$height;
        $this->weight=$weight;
        $this->intelligence=$intelligence;
        $this->password=$password;
    }
     public function getTitle(){
       echo $this->name;
    }
}
?>