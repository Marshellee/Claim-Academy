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
    <script src="https://kit.fontawesome.com/703cdc03ae.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/signup.css">
    <link rel="stylesheet" href="/css/showme.css">
</head>
<body class="column match">
    <div class="header">
        <div class="icon margini nwidth">
            <i class="fa-sharp fa-solid fa-caret-down fa-2xl"></i>
            <c:choose>
                <c:when test="${account!=null}">
                    <div class="dropdown column">
                        <a class="linx" href="/">Home</a>
                        <a class="linx" href="/showme">Show Me</a>
                        <a class="linx" href="/signout">Sign Out</a>
                        <a class="linx" href="/cart">Cart</a>
                    </div>
                </c:when>
            </c:choose>
        </div>
        <h1 class="center margin"> Tell The Genie Who You Are</h1>
        <div class="center margin textalign nwidth"> 
            <c:choose>
                <c:when test="${account!=null}"> Hi, ${account.getName()}!</c:when>
            </c:choose>
        </div>
    </div>
    <div class="bodysign justifycenter">
        <img src="https://i.pinimg.com/originals/34/f3/80/34f3807d8e588f8ac2095f47e740c923.png" alt="">
            <form:form modelAttribute="account" action="profile" method="post">
                <div class="column bodytext">
                    <h1>Update Here</h1>
                    <label>Name</label>
                    <form:input type="text" class="" path="name"/>
                    <label>Email</label>
                    <form:input type="text" class="" path="email"/>
                    <label>Phone</label>
                    <form:input type="text" class="" path="phone"/>
                    <label>Password</label>
                    <form:input type="password" class="" path="password"/>
                    <form:button class="space" type="submit">SAVE</form:button>
                </div>
            </form:form> 
    </div>
</body>
</html>