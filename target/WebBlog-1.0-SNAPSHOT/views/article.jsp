<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 25.04.2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/resources/css/indexStyle.css">
    <link rel="stylesheet" href="/resources/css/article.css">
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
<div class="content container-fluid"><h3 class="text-center" ><strong><strong>${article.subject}</strong></strong></h3>
    <h3 class="text-center" ><strong><strong>(Author: ${article.gest})</strong></strong></h3>
    <p class="text-center" >${article.text}</p>
    <p class="text-info">${article.date}</p></div>

<h2 class="text-center text-info" >Reviews:(<a href="/article/addopinion/${article.id}">Add review</a>)</h2>
<c:forEach items="${opinions}" var="opinion">
   <div class="container-fluid text-left content"> <p >${opinion.text}</p>
       <p class="text-left"><strong>Author:</strong> ${opinion.gest} Mark:${opinion.mark} Date:${opinion.date}
           <c:forEach items="${myopinions}" var="myopinion">
               <c:choose>
                   <c:when test="${myopinion.id == opinion.id}">
                       <a href="/article/editopinion/${opinion.id}" type="button" class="btn btn-primary">Edit</a>
                   </c:when>
               </c:choose>
           </c:forEach>
           <c:forEach items="${myopinions}" var="myopinion">
           <c:choose>
           <c:when test="${myopinion.id == opinion.id || login==article.id }">
         <a href="/article/deleteopinion/${opinion.id}" type="button" class="btn btn-danger">Delete</a>
       </c:when>
       </c:choose>
       </c:forEach></div>
</c:forEach>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
