<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css" href="./css/login.css">
<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js">
<!--
	
//-->
</script>

</head>
<body>
	<div class="container">
		<div class="img">
			<img src="./photo/phone.png">
		</div>

		<div class="login-content">
			<%
				if (request.getAttribute("MESSAGE") != null) {
			%>
			<p style="color: green">${MESSAGE}</p>
			<%
				}
			%>
			<form id="login">
				<img class="profil" src="./photo/profil.png">
				<h2>Login</h2>
				<div class="input-div">
					<h5>Etudiant</h5>
					<input class="input c" onchange="zigzag()" name="choix"
						type="radio" value="etudiant">
				</div>
				<div class="input-div">
					<h5>professeur</h5>
					<input class="input c" onchange="zigzag()" name="choix"
						type="radio" value="professeur">
				</div>

				<div class="input-div one etud">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div>
						<h5>CNE</h5>
						<input class="input cnein" name="CNE" type="text" id="cne">
					</div>
				</div>
				<div class="input-div one prof">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div>
						<h5>CIN</h5>
						<input class="input cinin" name="CIN" type="text" id="cin">
					</div>
				</div>

				<div class="input-div two">
					<div class="i">
						<i class="fas fa-lock"></i>
						<!-- <i class="fas fa-envelope"></i> -->

					</div>
					<div>
						<h5>Mot_de_passe</h5>
						<input class="input" name="MotDePasse" type="password"
							id="password">
					</div>
				</div>
				<a href="a">Mot de passe oublié</a>
				<p style="color: red;" id="erreur"></p>
				<input type="submit" id="submitBtn" class="btn" value="login">
			</form>
		</div>
	</div>


	<script type="text/javascript">
	$(document).ready(
			ajaxLogin()
	);

	</script>
	<script type="text/javascript" src="./javascipt/login.js"></script>
</body>
</html>