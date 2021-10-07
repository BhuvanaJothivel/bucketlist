<%@page import="model.TouristPlace"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="http://localhost:8080/jspservlet-app-bucketlist/assets/collectionStyle.css" /> 
		<title>Bucket List</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<form action="/jspservlet-app-bucketlist/map" method="post">
			<div class=container>
				<h2>Name</h2>
				<input type="text" placeholder="Name" name="name">
				<h2>Travel Destination</h2>
				<input type="text" placeholder="Place" name="travel">
				<h2>Rank</h2>
				<input type="text" placeholder="Rank" name="rank"><br><br>
				<div class="inputs">
					<div class="checklists">
						<input type="checkbox" value="SortInEntryOrder" name="sortinentryorder" id="destination">
						<label>Sort In Entry Order</label><br><br>
						<input type="checkbox" value="SortInRandomly" name="sortinrandomly" id="rank">
						<label>Sort In Randomly</label>
						<input type="checkbox" value="SortInAlphabetical" name="sortinalphabetical" id="rank">
						<label>Sort In Alphabetical</label>
					</div><br><br>
					<div class="button">
						<button name="view">View Result</button>
					</div>
				</div><br><br>
				<button name="add" id="add">Add To BucketList</button>
			</div>
		</form>
		<div class="bucketList">
		<h1>Your Bucket List</h1>
			<table class="table-bordered">
				<tbody>
					<tr>
						<th>SPOT NAME</th>
						<th>DESTINATION</th>
						<th>RANK</th>
					</tr>
					<c:forEach var="bucket" items="${bucketList}">
						<tr>
							<td><c:out value="${bucket.getName()}" /></td>
							<td><c:out value="${bucket.getDestination()}" /></td>
							<td><c:out value="${bucket.getRank()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>