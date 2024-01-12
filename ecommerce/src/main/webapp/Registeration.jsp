<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Registration Page</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
		}
		form {
			background-color: white;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0px 0px 10px grey;
			width: 50%;
			margin: auto;
		}
		input[type=text], input[type=password] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			display: inline-block;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
		}
		button[type=submit] {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			margin: 8px 0;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		button[type=submit]:hover {
			background-color: #45a049;
		}
        h1 {
            text-align:center; 
            margin-bottom:28px; 
            letter-spacing:4px; 
        }
        label {
            display:block; 
            margin-top:20px; 
            letter-spacing:2px; 
        }
        .form-group {
            position:relative; 
        }
        .form-group input {
            width:100%; 
            height:40px; 
            border:none; 
            border-radius:20px; 
            padding-left:54px; 
            box-shadow:none; 
            background-color:#f2f2f2; 
        }
        .form-group label {
            position:absolute; 
            top:-12px; 
            left:20px; 
            font-size:14px; 
        }
        .form-group i {
            position:absolute; 
            top:-4px; 
            left:28px; 
        }
	</style>
</head>
<body>
<form action="Register">
    <h1>Registration Form</h1>

    <div class="form-group">
      <input type="text" name="username" minlength="3" required>
      <label>Username</label>
      <i class="fa fa-user"></i>
    </div>
    <div class="form-group">
      <input type="date" name="dob" required>
      <label>D0B</label>
      <i class="fa fa-user"></i>
    </div>
    <div class="form-group">
      <input type="tel" name="number" required>
      <label>Phone-no</label>
      <i class="fa fa-user"></i>
    </div>

    <div class="form-group">
      <input type="text" name="email" required>
      <label>Email Address</label>
      <i class="fa fa-envelope"></i>
    </div>

    <div class="form-group">
      <input type="password" name="password"   required>
      <label>Password</label>
      <i class="fa fa-lock"></i>
    </div>

    <button type="submit">Submit</button>

</form>
</body>
</html>
