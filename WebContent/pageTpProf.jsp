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
 <script src="//cdn.ckeditor.com/4.14.0/full/ckeditor.js"></script>

<style>
.btnAddP {
	width: 50%;
	margin: 0px 22%;
}

.containerRight {
	float: left;
	width: 50%;
	padding: 30px;
	margin-bottom: 20px;
}

.containerLeft {
	float: left;
	width: 50%;
	padding: 30px;
	margin-bottom: 20px;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<c:import url="./shared/ConnNavBarP.jsp"></c:import>
	<div class="contentFiliere">
		<form action="./AjouterTp" method="POST">
			<div class="ajouterArchive-content">
				<h2 class="h2Title">Ajouter un Tp</h2>

				<div class="containerLeft">
					<div class="input-div one ">
						<div class="i">
							<i class="fas fa-user"></i>
						</div>
						<div>
							<h5>Titre du Tp</h5>
							<input class="input" type="text" id="titreTp"
								name="titreTp">
						</div>
					</div>
					<div class="input-div two">
						<div class="i">
							<i class="fas fa-lock"></i>
						</div>
						<div>
							<h5>Matiere</h5>
							<input class="input" type="text" name="matiere"
								id="EmpPc">
						</div>
					</div>
					<h5 class="h5TitleInput">Choisissez filiere:</h5>
					<div class="input-div tree">
						<div class="i">
							<i class="fas fa-lock"></i>
						</div>
						<div>
							<select class="input" name="FilieresProf" id="FilieresProf"
								data-placeholder="veuillez chisir une filiere">
								<c:forEach items="${requestScope.Filieres}" var="f">
									<option value="${f.getIdFil()}">${f.getNomF()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="containerRight">
					<h5 class="h5TitleInput">Ajouter un contenu :</h5>
					<div class="input-div tree">
						<div class="i">
							<i class="fas fa-lock"></i>
						</div>
						<div>
							<div id="textEditor">
								<textarea name="textArea" id="textArea"></textarea>
							</div>
						</div>
					</div>


				</div>
				<p style="color: red;" id="erreur"></p>
				<button type="submit" class="btnAddP btn-edit">Ajouter Un Tp</button>
			</div>
		</form>
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
						<td>${t.getFiliere().getNomF()}</td>
						<td class="actions">
							<button type="button" class="btn-delete"><a href="./supprTp?idTp=${t.getIdTp()}">Supprimer</button>
							<button type="button" class="btn-delete"><a href="./voirTpProf?idTp=${t.getIdTp()}">Details</a></button>
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
			 CKEDITOR.replace('textArea');
			$('#FilieresProf').chosen();

		});
	</script>
</body>
</html>