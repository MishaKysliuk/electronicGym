<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Exercise detail</h1>
            <p class="lead">Here is the detail information of the exercise!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/exercises/${exercise.exerciseId}.png"/>" style="width: 100%; height: 300px"/>
                </div>
                <div class="col-md-5">
                    <h3><strong>${exercise.exerciseName}</strong></h3>
                    <p><strong>Muscle group: </strong>${exercise.exerciseCategory}</p>
                    <br>
                    <p>${exercise.exerciseDescription}</p>
                    <p>
                        <sec:authorize access="hasRole('ROLE_TRAINER')">
                        <a href="<c:url value="/trainer/exercises"/>" class="btn btn-default">Back</a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <a href="<c:url value="/client/startTraining"/>" class="btn btn-default">Back</a>
                        </sec:authorize>
                    </p>
                </div>
            </div>
        </div>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>