<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab4</title>
<link rel="stylesheet" href="styles.css">
</head>
	<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=password], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}


</style>
<body style="background-color:black;">
<h1 style="text-align:center;color:white;">ECE417-Lab4-Anagnostopoulos Spyros 1778</h1>
        <div class="divclass">
            <form action = "Login" method = "POST">
               
                <tr><td><font color="red">${message}</font>
                </td></tr>
                
                <div align="center">
                <label for="fname"><p style="color:white;">Username</p></label>
   				 <input type="text" id="fname" name="username" placeholder="Your username.."></div>
   				 <div align="center">
                <label for="fname"><p style="color:white;">Password</p></label>
   				 <input type="password" id="fname" name="password" placeholder="Your password.."></div>
             
                <div>
                <input type="submit" class="button" value="Login"></div>
                </form>
                
                <div >
                <form action = "ToReg" method = "POST">
                 <input type="submit" class="button2" value="Register">
                </form>
                </div>

        </div>
    </body>
</html>
