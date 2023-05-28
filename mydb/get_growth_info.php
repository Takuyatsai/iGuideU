<?php


$host = '192.168.1.104';
$user = 'root';
$pwd = '123456';
$db  = 'mydb';

$conn = mysqli_connect($host, $user, $pwd, $db ) or die('Unable to connect');

if($conn){
  $sql = "select * from growth_info";
  $result = mysqli_query($conn,$sql);

  $response = array();
  while($row = mysqli_fetch_assoc($result)){
    array_push($response,$row);
  }
  echo json_encode($response);
}
mysqli_close($conn);

?>
