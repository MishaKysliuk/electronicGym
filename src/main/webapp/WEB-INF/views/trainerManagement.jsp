<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Trainer Management Page</h1>

            <p class="lead">This is the trainer management page.</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
            </tr>
            </thead>
            <c:forEach items="${trainerList}" var="trainer">
                <tr>
                    <td>${trainer.trainerName}</td>
                    <td>${trainer.trainerEmail}</td>
                    <td>${trainer.trainerPhone}</td>
                    <td>${trainer.username}</td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
