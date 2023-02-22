<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/signup.css">
</head>
<body class="column match">
    <div class="header center textalign">
        <h1> Let's Get You Signed Up!</h1>
    </div>
    <div class="bodysign justifycenter">
        <img src="https://i.pinimg.com/originals/34/f3/80/34f3807d8e588f8ac2095f47e740c923.png" alt="">
            <form:form modelAttribute="account" action="signup" method="post">
                <div class="column bodytext">
                    <label>Name</label>
                    <form:input type="text" class="" path="name"/>
                    <label>Email</label>
                    <form:input type="text" class="" path="email"/>
                    <label>Phone</label>
                    <form:input type="text" class="" path="phone"/>
                    <label>Password</label>
                    <form:input type="password" class="" path="password"/>
                    <form:button class="space" type="submit">SUBMIT</form:button>
                </div>
            </form:form> 
    </div>
</body>
</html>