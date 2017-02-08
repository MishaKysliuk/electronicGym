<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<%--DATEPICKER--%>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<%--TIMEPICKER--%>
<script src="<c:url value="/resources/js/jquery.timepicker.min.js" /> "></script>
<link href="<c:url value ="/resources/css/jquery.timepicker.css"/>" rel="stylesheet">


<script src="<c:url value="/resources/js/clientTrainingTimeController.js" /> "></script>

<script src="<c:url value="/resources/js/dateTimePickers.js" /> "></script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Start training</h1>
            <p class="lead">Choose date for your training!</p>
        </div>

        <c:if test="${not empty cantStart}">
        <div class="text">
            <h4 style="color: red;">${cantStart}</h4>
        </div>
        </c:if>
        <c:if test="${empty cantStart}">
        <c:if test="${not empty workoutIsSet}">
        <section class="form-horizontal container">
            <h4 style="color: green;">${workoutIsSet}</h4>
        </section>
        </c:if>
        <div class="container">
            <c:if test="${not empty workoutIsSet}">
                <p><strong>Date: </strong>${workout.workoutDate}</p>
                <p><strong>Time: </strong>${workout.workoutTime}</p>
            </c:if>
            <c:if test="${empty workoutIsSet}">
                <div ng-app="clientTrainingTimeApp" id="clientTrainingTime" ng-controller="clientTrainingTimeCtrl" ng-init="init()">
                    <form:form action="${pageContext.request.contextPath}/client/startTraining" method="POST"
                               commandName="workout">
                        <label>Date:</label>
                        <form:input type="text" id="datepicker" path="workoutDate" cssClass="form-control"/>
                        <form:errors path="workoutDate" cssStyle="color: red;"/><br>
                        <label>Time: </label>
                        <form:input type="text" id="timepicker" path="workoutTime" cssClass="form-control"/>
                        <form:errors path="workoutTime" cssStyle="color: red;"/><br>
                        <input class="btn btn-info" type="submit" value="Submit"/>
                    </form:form>
                </div>
            </c:if>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-info">
                <th>Photo</th>
                <th>Name</th>
                <th>Sets</th>
                <th>Reps</th>
                <th>Weight</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${exerciseItems}" var="item">
                <tr>
                    <td><img src="<c:url value="/resources/images/exercises/${item.exercise.exerciseId}.png"/> "
                             alt="${item.exercise.exerciseName}" style="width: 100%"/></td>
                    <td>${item.exercise.exerciseName}</td>
                    <td>${item.sets}</td>
                    <td>${item.reps}</td>
                    <td>${item.weight}</td>
                    <td><a href="<spring:url value="/exercises/viewExercise/${item.exercise.exerciseId}"/>"><span
                            class="glyphicon glyphicon-info-sign"/></a></td>
                </tr>
            </c:forEach>

        </table>
        </c:if>

        <%@ include file="/WEB-INF/views/template/footer.jsp" %>


