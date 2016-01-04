<?php

$host = "Name of the Host";
$user = "Username"; 
$pass = "Password";
$db = "DataBase Name";
$table = "Table Name"

$con = mysqli_connect($host, $user, $pass, $db);

$username = $_POST ["username"];
$password = $_POST ["password"];

$statement = mysqli_prepare ($con, "SELECT * FROM $table WHERE username = ? AND password = ?");
mysqli_stmt_bind_param ($statement, "ss", $username, $password);
mysqli_stmt_execute ($statement);

mysqli_stmt_store_result ($statement);
mysqli_stmt_bind_result ($statement, $user_id, $username, $password);

$user = array();

while(mysqli_stmt_fetch($statement)){
     $user[username] = $username;
     $user[password] = $password;
}

echo json_encode($user);

mysqli_stmt_close ($statement);

mysqli_close($con);


?>	
