<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form:form action="registration" commandName="user" method="post">
            User Name: <form:input path="username" />
            <font color="red">
                <form:errors path="username" />
            </font>
            <br />
            Password: <form:password path="password" />
            <font color="red">
                <form:errors path="password" />
            </font>
            <br />
            First Name: <form:input path="firstname" />
            <br />
            Last Name: <form:input path="lastname" />
            <br />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <form:button>Sign Up</form:button>
        </form:form>
    </body>
</html>