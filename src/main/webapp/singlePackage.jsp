<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>Single Places</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: Arial, sans-serif;
}

body {
	background-color: cornsilk;
}

h1 {
	text-align: center;
	font-size: 60px;
	color: blue;
}

.firstrowimg {
	position: absolute;
	width: 300px;
	height: 400px;
}

h2 {
	position: absolute;
	top: 450px;
	left: 85px;
	font-size: 30px;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

a img {
	width: 1000px;
}

.firstrowimg {
	width: 1150px;
	margin-left: 7%;
	height: 400px;
}

.details {
	position: absolute;
	left: 70px;
	top: 500px;
	
}

p {
	font-weight: bold;
}

h3 {
	font-weight: bold;
}

.btn {
	position: relative;
	top: 800px;
	margin-left: 50%;
	margin-bottom: 30px;
}

input, button {
	height: 40px;
	width: 180px;
	border-radius: 15px;
	border: 2px solid;
}

#button {
	background-color: red;
	color: white;
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	font-size: 18px;
	border-radius: 20px;
	border: none;
	left: 25%;
	top: 820px;
}

#container {
	height: 1100px;
}

label {
	position: relative;
	top: 780px;
	left: 26px;
	padding-left: 140px;
	font-size: 20px;
	font-weight: bold;
}

.data {
	position: relative;
	top: 810px;
	left: 110px;
	font-size: 20px;
	font-weight: bold;
	margin-left: 28px;
	text-aligh: center;
}

#select {
	position: relative;
	left: 170px;
	width: 100px;
}
.details, td{
padding:15px;
}
</style>
</head>
<body>

	<c:set var="packages" scope="session"
		value="${sessionScope.singlepackages}" />
	<c:set var="rating" scope="session"
		value="${sessionScope.singleaverating}" />

	<form action="allFlights">

		<div id="container">

			<h1 name="place">${packages.getName()}</h1>
			<br> <a href="#"> <img class="firstrowimg"
				src="Assets/${packages.getImage()}" alt="${packages.getName()}">

			</a> <br> <br>
			<table class="details" aria-describedby="single place details">
				<tr>
					<td><p>${packages.getDescription()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Location :</h3>
					</td>
					<td><p>${packages.getName()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>
							One Day night <br> Package Place
						</h3>
					</td>

					<td><p>${packages.getPriceOneDays()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Season :</h3>
					</td>
					<td><p>${packages.getSeason()}</p></td>
				</tr>
				<tr>
					<td>
						<h3>Tourist Protocols :</h3>
					</td>

					<td><p>${packages.getProtocols()}</p></td>
				</tr>
				<c:if test="${rating!=null}">
					<tr>
						<td>
							<h3>Ratings</h3>
						</td>

						<td>
							<h3>${rating.getRating()}/ 5</h3>
						</td>
					</tr>
				</c:if>
              <th id=""></th>
			</table>
			<br> <br>

			<table aria-describedby="single place details">
				<tr>
					<td><label for="">start Date</label></td>
					<td><label for="">No of person</label></td>
					<td><label for="">No of days in night</label></td>
				</tr>
				<tr>
					<td><input type="date" name="startdate" id="startdate"
						class="data" required autofocus title="please enter the date"></td>
					<td><input type="number" name="noofperson" class="data"
						required pattern="[0-9]" min="1" title="please fill the box"></td>
					<td><select name="noofdays" id="select" class="data" required>
							<option value="2 days plan">2N</option>
							<option value="3 days plan">3N</option>
							<option value="4 days plan">4N</option>
							<option value="5 days plan">5N</option>
					</select></td>
					<td>
						<button value="Book Place" class="btn" id="button">Book
							Place</button>
					</td>
				</tr>
				<th id=""></th>

			</table>

		</div>
	</form>

</body>

<script>
	today();
	function today() {

		var currentTime = new Date()
		var minDate = new Date(currentTime.getFullYear(), currentTime
				.getMonth(), +currentTime.getDate() + 2); //one day next before month
		var maxDate = new Date(currentTime.getFullYear(), currentTime
				.getMonth() + 1, +currentTime.getDate() + 2); // one day before next month
		console.log(minDate);
		console.log(maxDate);
		let date = JSON.stringify(maxDate)
		date = date.slice(1, 11)
		console.log(date)
		let dates = JSON.stringify(minDate)
		dates = dates.slice(1, 11)
		console.log(dates)
		document.getElementById("startdate").setAttribute("max", date);
		document.getElementById("startdate").setAttribute("min", dates);

	}
</script>

</html>