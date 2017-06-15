<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 25.04.2017
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/resources/css/indexStyle.css">
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
<sec:authorize access="isAuthenticated()"><table class="table table-condensed text-center table-article">
    <tr class="text-center"><th>Articles:</th>
        <th class="text-center">Author:</th></tr>
    <c:forEach items="${articles}" var="article">
        <tr  onclick="window.location.href='/articles/${article.id}'; return false"><td>${article.subject}</td><td>${article.gest}</td></tr>
    </c:forEach>
</table></sec:authorize>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>
