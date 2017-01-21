<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">

        <sec:authorize access="hasRole('ROLE_USER')">
        <c:if test="${not empty clientTrainer}">
        <div class="container">
            <div class="page-header">
                <h3>Your trainer</h3>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <img src="<c:url value="/resources/images/trainers/${clientTrainer.trainerId}.png"/>"
                         style="width: 100%;"/>
                </div>
                <div class="col-md-3">
                    <h3>${clientTrainer.trainerName}</h3>
                    <p><strong>Email: </strong>${clientTrainer.trainerEmail}</p>
                    <p><strong>Phone: </strong>${clientTrainer.trainerPhone}</p>
                    <br>
                    <p>${clientTrainer.trainerPersonalInfo}</p>
                </div>
            </div>
        </div>
        <br>
        </c:if>
        </sec:authorize>

        <div class="page-header">
            <h1>Our trainers</h1>
        </div>

        <div class="row">
            <c:forEach items="${trainerList}" var="trainer">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/images/trainers/${trainer.trainerId}.png"/> "
                             alt="${trainer.trainerName}"/>
                        <div class="caption">
                            <h3>${trainer.trainerName}</h3>
                            <p>${trainer.trainerPersonalInfo} </p>
                            <p>
                                <sec:authorize access="hasRole('ROLE_USER')">
                                    <c:if test="${empty invalidGymPass}">
                                        <a href="<spring:url value="/trainers/${trainer.trainerId}"/>"
                                           class="btn btn-warning btn-large">Choose</a>
                                    </c:if>
                                </sec:authorize>
                                <a href="<spring:url value="/trainers/viewTrainer/${trainer.trainerId}"/>"
                                   class="btn btn-default"
                                   role="button">Info</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>



<%@ include file="/WEB-INF/views/template/footer.jsp" %>