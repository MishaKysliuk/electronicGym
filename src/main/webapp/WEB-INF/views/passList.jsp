<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All passes</h1>
            <p class="lead">Checkout all the awesome passes available now!</p>
        </div>

        <div class="row">
        <c:forEach items="${gymPasses}" var="gymPass">

            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="<c:url value="/resources/images/${gymPass.passId}.png"/> " alt="${gymPass.passName}"/>
                    <div class="caption">
                        <h3>${gymPass.passName}</h3>
                        <p>The ${gymPass.passCategory} ${gymPass.passDurationInMonths} months gym pass.</p>
                        <p>
                            <sec:authorize access="hasRole('ROLE_USER')">
                                <a href="<spring:url value="/client/gymPass/orderGymPass/${gymPass.passId}"/>" class="btn btn-warning btn-large">
                                    <span class="glyphicon glyphicon-shopping-cart"></span>Buy
                                    Now</a>
                            </sec:authorize>
                            <a href="<spring:url value="/gymPass/viewPass/${gymPass.passId}"/>" class="btn btn-default"
                               role="button">Info</a></p>
                    </div>
                </div>
            </div>

        </c:forEach>
        </div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>