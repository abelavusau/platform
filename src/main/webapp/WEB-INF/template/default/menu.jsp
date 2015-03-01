<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/registration" var="registrationUrl" htmlEscape="true"/>
<spring:url value="/login" var="loginUrl" htmlEscape="true"/>
<spring:url value="/examples/gridster" var="gridsterUrl" htmlEscape="true"/>

<div class="menu">
	<ul class="mainNav">
		<li>Examples
			<ul class="subNav">
				<li onclick="javascript:window.location.href='${gridsterUrl}'">Gridster.js</li>
				<li>The first submenu item</li>
				<li>The first submenu item</li>
			</ul>
		</li>
		<li>The second menu item
			<ul class="subNav">
				<li>The first submenu item</li>
				<li>The first submenu item</li>
				<li>The first submenu item</li>
			</ul>
		</li>
		<li>The third menu item
			<ul class="subNav">
				<li>The first submenu item</li>
				<li>The first submenu item</li>
				<li>The first submenu item</li>
			</ul>
		</li>
	</ul>
	<div class="logIn">
		<a href="${loginUrl}">Sign In</a> <a href="${registrationUrl}">Sign Up</a>
	</div>
</div>