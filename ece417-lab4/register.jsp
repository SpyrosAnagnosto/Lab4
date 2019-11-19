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


</style>
	
	<body style="background-color:black;">
        <div class="divclass">
            <form action = "Register" method = "POST">
            <div><font color="red">${message}</font></div>
                <table>
                
                
                <tr><td>
                <p style="color:white;">Full Name:</p></td><td><input type="text" name="fullname" >
                </td></tr>
                <tr><td>
                <p style="color:white;">Username :</p></td><td><input type="text" name="username"></td></tr>
                <tr><td>
                <p style="color:white;">Password :</p></td><td><input type="password" name="password"></td></tr>
                <tr><td>
                <p style="color:white;">Re-type password :</p></td><td><input type="password" name="password2"></td></tr>
                <tr><td>
                <p style="color:white;">Email:</p></td><td><input type="text" name="email" ></td></tr>
                <tr><td>
                <p style="color:white;">Age :</p></td><td><input type="text" name="age"></td></tr>
             
                
                </table> 
                <div>
                <input type="submit" class="button" value="Register"></div>
             </form>
                <div >
                <form action = "ToLog" method = "POST">
                 <input type="submit" class="button2" value="Go to Login">
                </form>
                 </div>
                
                
            
        </div>
    </body>
</html>
