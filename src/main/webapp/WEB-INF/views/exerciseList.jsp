<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<script>
    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[2,3,5,10,-1], [2,3,5,10, "All"]],
            "oSearch": {"sSearch": searchCondition}
        });
    });

</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Exercise list</h1>

            <p class="lead">You can manage exercises here!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo</th>
                <th>Name</th>
                <th>Category</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${exerciseList}" var="exercise">
                <tr>
                    <td><img src="<c:url value="/resources/images/exercises/${exercise.exerciseId}.png"/> " alt="${exercise.exerciseName}" style="width: 100%"/> </td>
                    <td>${exercise.exerciseName}</td>
                    <td>${exercise.exerciseCategory}</td>
                    <td><a href="<spring:url value="/exercises/viewExercise/${exercise.exerciseId}"/>"><span class="glyphicon glyphicon-info-sign"/></a>
                        <a href="<spring:url value="/trainer/exercises/deleteExercise/${exercise.exerciseId}"/>"><span class="glyphicon glyphicon-remove"/></a>
                        <a href="<spring:url value="/trainer/exercises/editExercise/${exercise.exerciseId}"/>"><span class="glyphicon glyphicon-pencil"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/trainer/exercises/addExercise"/> " class="btn btn-primary">Add exercise</a>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>