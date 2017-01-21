<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register trainer</h1>

            <p class="lead">Please fill the basic data about trainer below:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/registerTrainer" method="post"
                   commandName="trainer" >


        <div class="form-group">
            <label for="name">Name </label><form:errors path="trainerName" cssStyle="color: #ff0000"/>
            <form:input path="trainerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email </label><span style="color: #ff0000">${emailMsg}</span><form:errors
                path="trainerEmail" cssStyle="color: #ff0000"/>
            <form:input path="trainerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="trainerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Username </label><span style="color: #ff0000">${usernameMsg}</span><form:errors
                path="username" cssStyle="color: #ff0000"/>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password </label><form:errors path="password" cssStyle="color: #ff0000"/>
            <form:password path="password" id="password" class="form-Control"/>
        </div>




        <br><br>
        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
