<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Details</title>
<style> 
.heading{color:blue; text-align:center; font-size:30px;}
#register-form{margin:auto;}
</style>
</head>
<body>
	<h2 class="heading">Contacts-Info</h2>
	<form>
		<table id="register-form">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="contactName"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="contactEmail"></td>
			</tr>

			<tr>
				<td>Phone Number:</td>
				<td><input type="text" name="contactNumber"></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="text" name="createDate"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit"> <input type="reset">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>