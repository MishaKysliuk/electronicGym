<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Personal card</h1>

            <p class="lead">Please fill your information below:</p>
            <c:if test="${not empty savedSuccessful}">
                <br>
                <div class="msg" style="color: green;">${savedSuccessful}</div>
            </c:if>
        </div>

        <form:form action="${pageContext.request.contextPath}/client/clientPersonalCard" method="post"
                   commandName="clientCard">
            <form:hidden path="cardId" value="${clientCard.cardId}"/>

        <div class="form-group">
            <label for="weight">Weight(kg) </label><form:errors path="height" cssStyle="color: #ff0000"/>
            <form:input path="weight" id="weight" class="form-Control" value="${clientCard.weight}"/>
        </div>

        <div class="form-group">
            <label for="height">Height(cm) </label><form:errors
                path="height" cssStyle="color: #ff0000"/>
            <form:input path="height" id="height" class="form-Control" value="${clientCard.height}"/>
        </div>

        <div class="form-group">
            <label for="fatPercent">Fat Percent </label><form:errors
                path="fatPercent" cssStyle="color: #ff0000"/>
            <form:input path="fatPercent" id="fatPercent" class="form-Control" value="${clientCard.fatPercent}"/>
        </div>

        <div class="form-group">
            <label for="waist">Waist(cm) </label><form:errors
                path="waist" cssStyle="color: #ff0000"/>
            <form:input path="waist" id="waist" class="form-Control" value="${clientCard.waist}"/>
        </div>

        <div class="form-group">
            <label for="breastVolume">Breast volume(cm) </label><form:errors
                path="breastVolume" cssStyle="color: #ff0000"/>
            <form:input path="breastVolume" id="breastVolume" class="form-Control" value="${clientCard.breastVolume}"/>
        </div>

        <div class="form-group">
            <label for="bicepsVolume">Biceps volume(cm) </label><form:errors
                path="bicepsVolume" cssStyle="color: #ff0000"/>
            <form:input path="bicepsVolume" id="bicepsVolume" class="form-Control" value="${clientCard.bicepsVolume}"/>
        </div>

        <div class="form-group">
            <label for="legVolume">Leg volume(cm) </label><form:errors
                path="legVolume" cssStyle="color: #ff0000"/>
            <form:input path="legVolume" id="legVolume" class="form-Control" value="${clientCard.legVolume}"/>
        </div>


        <br><br>
        <input type="submit" value="Save" class="btn btn-default">
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
