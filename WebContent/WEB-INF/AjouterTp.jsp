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

	
		<script type="text/javascript" src="javascript/ajouterAchive.js"></script>
		<script src="./chosen/chosen.jquery.js"></script>

		<c:import url="./shared/footer.jsp"></c:import>
		<script
			src="<c:url value="https://code.jquery.com/jquery-3.4.1.slim.min.js" />"></script>
		<script src=" <c:url value="./chosen/chosen.jquery.js" />"></script>
</body>
</html>