<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Personal Information</h1>

            <p class="lead">Please fill your information below:</p>
            <c:if test="${not empty savedSuccessful}">
                <br>
                <div class="msg" style="color: green;">${savedSuccessful}</div>
            </c:if>
        </div>

        <form:form action="${pageContext.request.contextPath}/trainer/trainerPersonalInfo" method="post"
                   commandName="trainer" enctype="multipart/form-data">
            <form:hidden path="trainerId" value="${trainer.trainerId}"/>
            <form:hidden path="username" value="${trainer.username}"/>
            <form:hidden path="password" value="${trainer.password}"/>

        <div class="form-group">
            <label for="name">Name </label><form:errors path="trainerName" cssStyle="color: #ff0000"/>
            <form:input path="trainerName" id="name" class="form-Control" value="${trainer.trainerName}"/>
        </div>

        <div class="form-group">
            <label for="email">Email </label><form:errors
                path="trainerEmail" cssStyle="color: #ff0000"/>
            <form:input path="trainerEmail" id="email" class="form-Control" value="${trainer.trainerEmail}"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone </label><form:errors
                path="trainerPhone" cssStyle="color: #ff0000"/>
            <form:input path="trainerPhone" id="phone" class="form-Control" value="${trainer.trainerPhone}"/>
        </div>

        <div class="form-group">
            <label for="info">Personal information</label>
            <form:textarea path="trainerPersonalInfo" id="info" class="form-Control" style="resize:none; height: 10%;" value="${trainer.trainerPersonalInfo}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="trainerPhoto">Upload your photo</label>
            <form:input id="trainerPhoto" path="trainerPhoto" type="file" class="form:input-large" />
        </div>




        <br><br>
        <input type="submit" value="Save" class="btn btn-default">
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
