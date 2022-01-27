<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>wallet page</title>
<style>
body {
	background-color: rgb(138, 238, 238);
}

.container {
	border: 3px solid;
	width: 400px;
	text-align: center;
	margin-left: 30%;
	margin-top: 10%;
	padding: 3%;
	border-radius: 3%;
}

input {
	height: 40px;
	width: 200px;
	text-align: center;
	font-size: 18px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-weight: bold;
	border: 2px solid;
}

button {
	height: 40px;
	width: 220px;
	border-radius: 25px;
	background-color: blueviolet;
	border: none;
	font-size: 15px;
	font-weight: bold;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color: cornsilk;
}

a {
	text-decoration: none;
}
</style>

</head>
<body>
        
        <c:set var="user" scope="session" value="${newUser}"/>
        
	<form action="walletSus" method="get">
		<h3>
			<a href="UserPage.jsp">Go To Home</a>
		</h3>
		<div class="container">

			<h3>
				Your Wallet Amount : <span>${user.getWallet()}</span>
				</h2>
			</h3>
			<br>
			<h4>Topup Wallet</h4>
			<br> <input type="number" name="amount" id="amount"
				placeholder="Rs.  Enter amount" required min="5000" autofocus
				pattern="[0-9]{3,}" title="must contain numbers only">
			<p>Minimum 5000</p>
			<br>
			<br>
			<br>
			<button>PROCEED TO TOPUP</button>
		</div>
	</form>
</body>
</html>