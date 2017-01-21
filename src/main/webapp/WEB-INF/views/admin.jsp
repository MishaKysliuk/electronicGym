<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>
            <p class="lead">You can make your management here!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
        </h2>
        </c:if>
        <br>
        <h3><a href="<c:url value="/admin/gymPassInventory"/>">Gym pass inventory</a></h3>
        <p>Here you can view, check and modify gym pass inventory.</p>
        <br>
        <h3>
            <a href="<c:url value="/admin/client" />" >Client Management</a>
        </h3>
        <p>Here you can view the client information!</p>
        <br>
        <h3>
            <a href="<c:url value="/admin/registerTrainer" />" >Register trainer</a>
        </h3>
        <p>Here you can register new trainer!</p>
        <br>
        <h3>
            <a href="<c:url value="/admin/trainer" />" >Trainer Management</a>
        </h3>
        <p>Here you can view the trainer information!</p>

        <%@ include file="/WEB-INF/views/template/footer.jsp"%>
