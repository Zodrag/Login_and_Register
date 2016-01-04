<?php

$host = "Name of the Host";
$user = "Username"; 
$pass = "Password";
$db = "DataBase Name";
$table = "Table Name"

$con = mysqli_connect($host, $user, $pass, $db);

$username = $_POST ["username"];
$password = $_POST ["password"];

$statement = mysqli_prepare ($con, "INSERT INTO $table (username, password) VALUES (?, ?)");
mysqli_stmt_bind_param ($statement, "ss", $username, $password);
mysqli_stmt_execute ($statement);
mysqli_stmt_close ($statement);

mysqli_close($con);


?>
