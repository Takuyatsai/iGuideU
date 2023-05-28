<?php


$host = '192.168.1.104';
$user = 'root';
$pwd = '123456';
$db  = 'mydb';

$conn = mysqli_connect($host, $user, $pwd, $db ) or die('Unable to connect');

if(mysqli_connect_error($conn)){
  echo "Failed to connect";
}
$query=mysqli_query($conn,"SELECT rec_hum FROM dht11 ORDER BY sr_no desc limit 1");

if($query){
  while($row=mysqli_fetch_array($query)){
    $flag[]=$row;

  }
  print(json_encode($flag));
}
mysqli_close($conn);
?>
