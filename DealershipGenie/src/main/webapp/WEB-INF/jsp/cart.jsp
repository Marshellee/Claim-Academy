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
                            <a class="linx" href="/signout">Sign Out</a>
                            <a class="linx" href="/profile">Profile</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="dropdown column">
                            <a class="linx" href="/signup">Sign Up</a>
                            <a class="linx" href="/">Home</a>
                            <a class="linx" href="/signin">Sign In</a>
                        </div>
                    </c:otherwise>
                </c:choose>
        </div>
        <h1 class="center margin">Click Buy To Grant Your Wish</h1>
        <div class="center margin textalign nwidth"> 
            <c:choose>
                <c:when test="${account!=null}"> Hey, ${account.getName()}!</c:when>
            </c:choose>
        </div>
    </div>
    <div class="main right">
        <div class="flex-wrap carbox">
            <c:forEach items="${account.cart.cardetails}" var="cardetails">
                <div class="details column">
                    <div class="top column center">
                        <h3><strong>${cardetails.description}</strong></h3>
                        <div class="row">
                            <h5 class="pad">${cardetails.year}</h5>
                            <h5 class="pad">${cardetails.make}</h5>
                            <h5 class="pad">${cardetails.model}</h5>
                        </div>
                    </div>
                    <img class="pics" src="${cardetails.image}" alt="">
                    <div> Price: ${cardetails.price}</div>
                    <div> Mileage: ${cardetails.mileage}</div>
                    <div class="row"> 
                        <a href="">Buy</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>