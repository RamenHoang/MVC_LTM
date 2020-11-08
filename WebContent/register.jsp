<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
	body {
		background-color: #2b3137;
		font-size: 15px;
		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	}
	div {
		width: 300px;
		background-color: white;
		left: 50%;
	    top: 50%;
	    position: absolute;
	    transform: translate(-50%, -50%);
	    padding: 20px;
	    border-radius: 7px;
	}
	form {
		width: 100%;
	}
	label {
		font-weight: 600;
	}
	input {
		display: block;
		width: 100%;
		line-height: 1.5;
		/* outline: none; */
		margin: auto;
		padding: 10px;
		box-sizing: border-box;
		border: 1px solid #cbcbcb;
		border-radius: 7px;
		/* border: none; */
	}
	input[type="text"], input[type="password"] {
		margin-top: 10px;
	}
	input[type="submit"] {
		padding: 10px;
		font-size: 15px;
		background-color: #2ebc4f;
		border-radius: 7px;
		cursor: pointer;
		border: none;
		color: white;
	}
</style>
</head>
<body>
	<div>
		<form action="SVCheckRegister" method="post">
		<label>UserName</label>
		<br>
		<input type="text" name="username" required/>
		<br>
		<label>Password</label>
		<br>
		<input type="password" name="password" required/>
		<br>
		<label>Lastname</label>
		<br>
		<input type="text" name="lastname" required/>
		<br>
		<br>
		<input type="submit" value="Register"/>
	</form>
	</div>
</body>
</html>