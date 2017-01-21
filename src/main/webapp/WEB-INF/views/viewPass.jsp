<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Pass detail</h1>
            <p class="lead">Here is the detail information of the pass!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${gymPass.passId}.png"/>" style="width: 100%; height: 300px"/>
                </div>
                <div class="col-md-5">
                    <h3>${gymPass.passName}</h3>
                    <p>${gymPass.passCategory} ${gymPass.passDurationInMonths} months gym pass</p>
                    <h2>${gymPass.passPrice} USD</h2>
                    <br>
                    <p>${gymPass.passDescription}</p>
                    <p>
                        <a href="<c:url value="/gymPass/passList"/>" class="btn btn-default">Back</a>
                        <a href="<spring:url value="/client/gymPass/orderGymPass/${gymPass.passId}"/>" class="btn btn-warning btn-large">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Buy
                            Now</a>
                    </p>
                </div>
            </div>
        </div>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>