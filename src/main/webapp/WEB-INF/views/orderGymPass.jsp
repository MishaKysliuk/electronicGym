<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Buy gym pass!</h1>

            <p class="lead">Please fill in payment information below:</p>
            <c:if test="${not empty msg}">
                <h2 style="color:red;">${msg}</h2>
            </c:if>
        </div>

<form:form action="${pageContext.request.contextPath}/client/gymPass/orderGymPass/${passId}" method="post"
           commandName="payment">

    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="cardOwnerName" id="name" class="form-Control"/>
    </div>

    <div class="form-group">
        <label for="surname">Surname</label>
        <form:input path="cardOwnerSurname" id="surname" class="form-Control"/>
    </div>

    <div class="form-group">
        <label for="cardNumber">Card number</label>
        <form:input path="cardNumber" id="cardNumber" class="form-Control"/>
    </div>

    <div class="form-group">
        <label for="date">Expiration date</label>
        <form:input path="expirationDate" id="date" class="form-Control"/>
    </div>

    <div class="form-group">
        <label for="cvv">CVV</label>
        <form:input path="cvvCode" id="cvv" class="form-Control"/>
    </div>


    <br><br>
    <input type="submit" value="Submit" class="btn btn-default">
    <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
</form:form>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
