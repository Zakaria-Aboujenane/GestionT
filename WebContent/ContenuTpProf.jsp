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
h5 {
	color: red;
}

.contenuTp {
	float: left;
	width: 50%;
	height: 300px
}

.FaireTp {
	float: left;
	width: 50%;
	display: block;
}

.tableoui {
	float: left;
	width: 50%;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<c:import url="./shared/ConnNavBarP.jsp"></c:import>
	<div class="contenuTp">
		<h2>${t.getTitre()}</h2>
		<p>${t.getContenu()}</p>
	</div>
	<div class="FaireTp">
		<table class="tableoui">
			<tr>
				<th>etudiants qui ont fait ce tp</th>
			</tr>

			<c:forEach items="${etFTp}" var="t">
				<tr class="hov">
					<td>
						<h5>${t.getCNE()}</h5> ${t.getNom()} ${t.getPrenom()}
					</td>
				</tr>
			</c:forEach>
		</table>
		<table class="tableoui">
			<tr>
				<th>etudiants qui n'ont fait ce tp</th>
			</tr>

			<c:forEach items="${etNFTp}" var="t">
				<tr class="hov">
					<td>
						<h5>${t.getCNE()}</h5> ${t.getNom()} ${t.getPrenom()}
					</td>
				</tr>
			</c:forEach>
		</table>
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