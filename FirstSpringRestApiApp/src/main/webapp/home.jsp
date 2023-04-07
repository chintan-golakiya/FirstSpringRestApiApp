<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Alien</h2>
	<form action="addAlien">
		<input type="text" name="aid" placeholder="id"><br>
		<input type="text" name="aname" placeholder="name"><br>
		<input type="submit"> <br>
	</form>
	
	<h2>Get Alien</h2>
	<form action="getAlien">
		<input type="text" name="aid" placeholder="id"><br>
		<input type="submit"> <br>
	</form>
	
	Alien data - ${aliendata.aid} ${aliendata.aname}
	
	<h2>Get Alien Name</h2>
	<form action="getAlienByName">
		<input type="text" name="aname" placeholder="name"><br>
		<input type="submit"> <br>
	</form>
</body>
</html>