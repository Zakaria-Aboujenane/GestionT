<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css"
	href="<c:url value="./css/pageTp.css" />">
<link rel="stylesheet"
	href=" <c:url value="./css/bare-de-recherche.css" />">
<link rel="stylesheet" href="<c:url value="./css/menuConn.css" />" />
<link rel="stylesheet" href="<c:url value="./css/footer.css" />"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet" />

<script src="https://kit.fontawesome.com/a81368914c.js"></script>

</head>
<body>
	<c:import url="./shared/ConnNavBar.jsp"></c:import>

	<div class="contenu_de_pageTp">
		<div class="section profs">
			<p class="titre">les profs de filier</p>
			<c:forEach items="${profs}" var="p">
				<div class="prof1">
					<img class="profile" src="./photo/profil.png">
					<p class="nom">Professeur:</p>
					<p class="nom">${p.getNom()}${p.getPrenom()}</p>
					<p class="nom">Role: ${p.getRole()}</p>


				</div>
			</c:forEach>
		</div>

		<div class="section tp">
			<div id="head">
				<form action="#">
					<input type="text" name="q" id="search">
				</form>
			</div>
			<div class="divTp"></div>
		</div>


	</div>

	<c:import url="./shared/footer.jsp"></c:import>

	<script src="<c:url value="./javascipt/profil.js" />"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
	<script src="./javascipt/Tp.js"></script>
	<script type="text/javascript">
		function changeStatusTp(idTp) {
			var checkBox = document.getElementById("tpCheck");
			
			$.ajax({
				type : 'POST',
				url : '/GestionTp/fairetp',
				data : {
					idTp : idTp
				},
				success : function(data) {
				
				}
			});
		}
	</script>
</body>
</html>