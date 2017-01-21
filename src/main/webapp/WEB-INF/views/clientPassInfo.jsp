<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <h1 class="page-header">
            <h1>Your pass detail</h1>
            <p class="lead">Here is the detail information of your pass!</p>
            <c:if test="${not empty paymentSuccess}">
            <h1 style="color:green">${paymentSuccess}</h1>
            <br>
            </c:if>

            <c:if test="${client.passOrder != null}">

            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <img src="<c:url value="/resources/images/${client.passOrder.gymPass.passId}.png"/>"
                             style="width: 100%; height: 300px"/>
                    </div>
                    <div class="col-md-5">
                        <h3>${client.passOrder.gymPass.passName}</h3>
                        <p>${client.passOrder.gymPass.passCategory} ${client.passOrder.gymPass.passDurationInMonths}
                            months gym pass</p>
                        <p><strong>Expiration date: </strong>${client.gymPassExpirationDate} </p>
                        <br>
                        <p>${client.passOrder.gymPass.passDescription}</p>
                    </div>
                </div>
            </div>
            </c:if>
            <c:if test="${client.passOrder == null}">
            <h2>You have no gym pass yet</h2>
            </c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>