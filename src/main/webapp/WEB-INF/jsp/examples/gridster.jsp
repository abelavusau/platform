<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<title>Gridster Example</title>
<link
	href="${pageContext.request.contextPath}/css/common/jquery.gridster.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/gridster.css"
	rel="stylesheet" type="text/css" />
</head>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<h1>Gridster Example</h1>
			<div class="pallete">
				<ul>
					<li data-row="1" data-col="1" data-sizex="1" data-sizey="1">Table</li>
			        <li data-row="2" data-col="1" data-sizex="1" data-sizey="1">Div</li>
			        <li data-row="3" data-col="1" data-sizex="1" data-sizey="1">Image</li>
				</ul>
			</div>
			<div class="gridster">
				<ul></ul>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery.gridster.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/gridster/factory/WidgetFactory.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/gridster/gridster.js"></script>