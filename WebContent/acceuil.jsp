<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="<c:url value="./css/menu.css" />">
<link rel="stylesheet" href="<c:url value="./css/footer.css" />">
<link rel="stylesheet"
	href="<c:url value="./css/bare-de-recherche.css" />">
	<link rel="stylesheet"
	href="<c:url value="./css/acceuil.css" />">
<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>

<body>
	<!-- nav bar: -->
	<c:import url="./shared/NonConnNavBar.jsp"></c:import>
	<div class="page-wraper">


		<div class="post-slider">
			<h1>posts</h1>
			<i class="fas fa-chevron-left prev"></i> <i
				class="fas fa-chevron-right next"></i>
			<div class="post-wraper">
				<c:forEach items="${filieres}" var="f">
					<div class="post">
						<div class="slider-img">
							<img class="imgC" src="<c:url value="./photo/fil.jpg" />"
								alt="nope">
						</div>
						<div class="post-info">
							<br> <i class="fas fa-user"> Filiere: ${f.getNomF()}</i><br>
							<i class="fas fa-user"> Creer Par : ${f.getCreateur()}</i><span>|</span><i
								class="fas fa-calendar"> le : ${f.getDateC()}</i><br> <i
								class="fas fa-user">${f.getDesc()} </i><br>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="divP">
				<div class="div1"></div>
				<div class="div2"></div>
			</div>
		</div>
	</div>


	<!--the footer:  -->
	<c:import url="./shared/footer.jsp"></c:import>
	<style>

</style>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
		<!-- dev du slider: -->
	<script type="text/javascript" src="./javascipt/acceuil.js"></script>

</body>
</html>