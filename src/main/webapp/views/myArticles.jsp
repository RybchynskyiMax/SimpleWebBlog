<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 26.04.2017
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Articles</title>
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
<a  href="/add" type="button" class="btn btn-success">Add article</a>
<div class="ind">
<table class="table table-condensed text-center">
    <tr ><th>Articles:</th></tr>
    <c:forEach items="${articles}" var="article">
        <tr><td><a href="/articles/${article.id}">${article.subject}</a> <a href="/myarticles/edit/${article.id}" type="button" class="btn btn-primary">Edit</a> <a href="/myarticles/delete/${article.id}" type="button" class="btn btn-danger">Delete</a></td></tr>
    </c:forEach>
</table></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>

</html>

