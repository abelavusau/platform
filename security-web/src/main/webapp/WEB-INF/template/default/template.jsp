<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-2.1.1.js"></script>
	    <link href="${pageContext.request.contextPath}/css/template.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="page">
			<tiles:insertAttribute name="header" />
			<div class="content">
				<tiles:insertAttribute name="menu" />
				<tiles:insertAttribute name="body" />
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>