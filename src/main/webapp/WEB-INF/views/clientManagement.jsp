<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="<c:url value="/resources/js/dataTable.js" /> "></script>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Client Management Page</h1>

            <p class="lead">This is the client management page.</p>
        </div>

        <table id="data-table" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Gym pass</th>
                <th>Expiration date</th>

            </tr>
            </thead>
            <c:forEach items="${clientList}" var="client">
                <tr>
                    <td>${client.clientName}</td>
                    <td>${client.clientEmail}</td>
                    <td>${client.clientPhone}</td>
                    <td>${client.username}</td>
                    <td>
                        <c:if test="${client.passOrder != null}">
                            ${client.passOrder.gymPass.passName}
                        </c:if>
                        <c:if test="${client.passOrder == null}">
                            No gym pass
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${client.gymPassExpirationDate != null}">
                            ${client.gymPassExpirationDate}
                        </c:if>
                        <c:if test="${client.gymPassExpirationDate == null}">
                            ---
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
