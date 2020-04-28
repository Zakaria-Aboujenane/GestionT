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
h5{
color:red;
}
.contenuTp {
	float: left;
	width: 100%;
	height: 300px
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