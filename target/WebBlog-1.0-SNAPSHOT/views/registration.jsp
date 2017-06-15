<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 25.04.2017
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><span>Glor</span> Tv</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><sec:authorize access="isAnonymous()"><a href="/registration">Register!</a></sec:authorize></li>
                <li><sec:authorize access="isAuthenticated()"><a  href="/myarticles">My articles</a></sec:authorize></li>
                <li><sec:authorize access="isAuthenticated()"><a  href="/articles">Articles</a></sec:authorize></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><sec:authorize access="isAnonymous()"><a href="/login">Login</a></sec:authorize></li>
                <li><sec:authorize access="isAuthenticated()"><a  href="/logout">Logout</a></sec:authorize></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<h1 class="text-center">Registration page</h1>
    <form action="/registration" method="post" class="col-sm-6">
        <div class="form-group ">
        <label for="login">Login:</label>
        <input class="form-control" name="login" id="login"  type="text">
        </div>
        <div class="form-group ">
        <label for="name">Name:</label>
        <input class="form-control" name="name" id="name" type="text">
        </div>
        <div class="form-group ">
        <label for="SecondName">Second name:</label>
        <input class="form-control" name="secondName" id="secondName" type="text">
        </div>
        <div class="form-group ">
        <label for="email">Email:</label>
        <input class="form-control" name="email" id="email" type="text">
        </div>
        <div class="form-group ">
        <label for="phone">Phone:</label>
        <input class="form-control" name="phone" id="phone" type="number">
        </div>
        <div class="form-group ">
        <label for="password">Password:</label>
        <input class="form-control" name="password" id="password" type="password">
        </div>
        <button class="btn btn-success" type="submit">Register!</button>
    </form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
