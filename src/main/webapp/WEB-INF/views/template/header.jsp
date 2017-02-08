<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Gold's Gym</title>


    <!-- Angular JS -->
    <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>

    <%--Jquery--%>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>

    <%--Data Table--%>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value ="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Carousel CSS -->
    <link href="<c:url value ="/resources/css/carousel.css"/>" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value ="/resources/css/main.css"/>" rel="stylesheet">

    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">


</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/"/>">Gold's gym</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/gymPass/passList"/>">Gym passes</a></li>
                        <li><a href="<c:url value="/trainers"/>">Trainers</a></li>
                        <li><a href="<c:url value="/contacts"/>">Contact</a></li>
                        <sec:authorize access="not hasRole('ROLE_ADMIN')">
                        <sec:authorize access="isAuthenticated()">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                Training <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <sec:authorize access="hasRole('ROLE_USER')">
                                <li><a href="<c:url value="/client/clientPersonalCard"/> ">Personal card</a></li>
                                    <li><a href="<c:url value="/client/clientPassInfo"/> ">Your gym pass</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Trainings</li>
                                <li><a href="<c:url value="/client/startTraining"/> ">Start training</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_TRAINER')">
                                    <li><a href="<c:url value="/trainer/trainerPersonalInfo"/> ">Personal information</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Trainings</li>
                                    <li><a href="<c:url value="/trainer/trainerClients"/> ">Your clients</a></li>
                                    <li><a href="<c:url value="/trainer/exercises"/> ">Exercises</a></li>
                                </sec:authorize>
                            </ul>
                        </li>
                        </sec:authorize>
                        </sec:authorize>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <sec:authorize access="isAuthenticated()">
                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </sec:authorize>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <li><a href="<c:url value="/login/" />">Login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a></li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>