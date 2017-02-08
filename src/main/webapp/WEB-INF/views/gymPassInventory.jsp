<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<script src="<c:url value="/resources/js/dataTable.js" /> "></script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Gym pass Inventory Page</h1>

            <p class="lead">This is the gym pass inventory page!</p>
        </div>

        <table id="data-table" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo</th>
                <th>Name</th>
                <th>Category</th>
                <th>Duration</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${gymPasses}" var="gymPass">
                <tr>
                    <td><img src="<c:url value="/resources/images/${gymPass.passId}.png"/> " alt="${gymPass.passName}" style="width: 100%"/> </td>
                    <td>${gymPass.passName}</td>
                    <td>${gymPass.passCategory}</td>
                    <td>${gymPass.passDurationInMonths}</td>
                    <td>${gymPass.passPrice}</td>
                    <td><a href="<spring:url value="/gymPass/viewPass/${gymPass.passId}"/>"><span class="glyphicon glyphicon-info-sign"/></a>
                        <a href="<spring:url value="/admin/gymPass/deleteGymPass/${gymPass.passId}"/>"><span class="glyphicon glyphicon-remove"/></a>
                        <a href="<spring:url value="/admin/gymPass/editGymPass/${gymPass.passId}"/>"><span class="glyphicon glyphicon-pencil"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/gymPass/addGymPass"/> " class="btn btn-primary">Add gym pass</a>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>