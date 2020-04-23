<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="./css/pageTp.css" />">
<link rel="stylesheet" href="<c:url value="./css/menuConn.css" />" />
<link rel="stylesheet" href="<c:url value="./css/footer.css" />" />
<link rel="stylesheet" href=" <c:url value="./chosen/chosen.css" />">
<link rel="stylesheet"
	href=" <c:url value="./css/bare-de-recherche.css" />">
</head>
<body>
	<c:import url="./shared/ConnNavBarP.jsp"></c:import>

	<div class="contentSidebar">
		<div id="head">
			<form action="#">
				<input type="text" name="q" id="search">
			</form>
			<div class="contentFiliere">
				<select class="input" name="FilieresProf" id="FilieresProf"
					data-placeholder="veuillez chisir une filiere">
					<c:forEach items="${requestScope.Filieres}" var="f">
						<option value="${f.getIdFil()}">${f.getNomF()}</option>
					</c:forEach>
				</select>
			</div>


		</div>
		<div class="seection tableau">
			<table class="table">
				<tr>
					<th>titre</th>
					<th>date ajout</th>
					<th>Matiere Du Tp</th>
					<th>Filiere</th>
					<th>Action</th>
				</tr>

				<c:forEach items="${tps}" var="t">
					<tr class="hov">
						<td>${t.getTitre()}</td>
						<td>${t.getDateAjout()}</td>
						<td>${t.getMatiere()}</td>
						<td>${t.getFiliere()}</td>
						<td class="actions">
							<button type="button" class="btn-edit">Modifier</button>
							<button type="button" class="btn-delete">Supprimer</button>
							<button type="button" class="btn-delete">Details</button>
						</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>

	<c:import url="./shared/footer.jsp"></c:import>
	<script
		src="<c:url value="https://code.jquery.com/jquery-3.4.1.slim.min.js" />"></script>
	<script src=" <c:url value="./chosen/chosen.jquery.js" />"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#FilieresProf').chosen();

		});
	</script>
</body>
</html>