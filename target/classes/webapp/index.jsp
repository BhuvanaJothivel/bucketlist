<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="http://localhost:8080/jspservlet-app-bucketlist/assets/style.css" /> 
		<title>Bucket List</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<h1>ULTIMATE TRAVEL BUCKET LIST</h1>
		<h2>What kind of list you'd like to make? Select one to proceed</h2>
		<form action="/jspservlet-app-bucketlist/index" method="post">
			<div id="buttons">
				<button name="list">List</button>
				<button name="set">Set</button>
				<button name="map">Map</button>
			</div>
		</form>
	</body>
</html>