<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<script src="<c:url value="/resources/js/makeTrainingController.js" /> "></script>
<script src="<c:url value="/resources/js/dataTable.js" /> "></script>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Make training</h1>

            <p class="lead">Create training for your client here!</p>
        </div>

        <div ng-app="makeTrainingApp">
            <div ng-controller="makeTrainingCtrl" ng-init="init()">

                <table class="table table-striped table-hover" id="data-table" ng-init="initTable()">
                    <thead>
                    <tr class="bg-success">
                        <th>Name</th>
                        <th>Category</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:forEach items="${exerciseList}" var="exercise">
                        <tr>
                            <td>${exercise.exerciseName}</td>
                            <td>${exercise.exerciseCategory}</td>
                            <td></td>
                            <td>
                                <a href="#" ng-click="addExercise('${exercise.exerciseId}')"><span
                                        class="glyphicon glyphicon-plus-sign"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
                <br><br><br><br>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr class="bg-info">
                        <th>Name</th>
                        <th>Sets</th>
                        <th>Reps</th>
                        <th>Weight</th>
                    </tr>
                    </thead>
                    <tr ng-repeat="item in itemList">
                        <td>{{item.exercise.exerciseName}}</td>
                        <td><input type="text" ng-model="item.sets" ng-change="calculateTime()" numeric/></td>
                        <td><input type="text" ng-model="item.reps" ng-change="calculateTime()" numeric/></td>
                        <td><input type="text" ng-model="item.weight" production-qty/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>Average time for training:</strong></td>
                        <td>{{time}}</td>
                    </tr>

                </table>

                <a href="#" class="btn btn-primary" ng-click="saveWorkout('${clientId}')">Save workout</a>
            </div>
        </div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>