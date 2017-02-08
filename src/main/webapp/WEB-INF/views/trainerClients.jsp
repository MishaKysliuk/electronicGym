<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<script src="<c:url value="/resources/js/dataTable.js" /> "></script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Your clients</h1>

            <p class="lead">Manage your training with clients here!</p>
        </div>

        <table id="data-table" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Pass expiration date</th>
                <th>Last workout</th>
                <th>Wait for workout</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clientList}" var="client">
                <tr>
                    <td>${client.clientName}</td>
                    <td class="text-center">${client.clientEmail}</td>
                    <td>
                        <c:if test="${client.gymPassExpirationDate != null}">
                            ${client.gymPassExpirationDate}
                        </c:if>
                        <c:if test="${client.gymPassExpirationDate == null}">
                            No pass
                        </c:if>
                    </td>
                    <td>
                            ${client.workouts[fn:length(client.workouts)-1].workoutDate}
                    </td>
                    <td>
                        <c:if test="${client.needToCreateWorkout != false}">
                            Yes
                        </c:if>
                        <c:if test="${client.needToCreateWorkout == false}">
                            No
                        </c:if>
                    </td>
                    <td><a href="<c:url value="/trainer/clientInfo/${client.clientId}"/>" class="btn btn-info">Personal
                        card</a></td>
                    <td>
                        <c:if test="${client.needToCreateWorkout == false}">
                        <a href="#" class="btn btn-info"<c:out value="disabled='disabled'"/>>Make training</a></td>
                    </c:if>
                    <c:if test="${client.needToCreateWorkout != false}">
                        <a href="<c:url value="/trainer/makeTraining/${client.clientId}"/>" class="btn btn-info">Make
                            training</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>