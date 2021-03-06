<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add gym pass</h1>
            <p class="lead">Fill the below information to add the gym pass!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/gymPass/addGymPass" method="post"
                   commandName="gymPass" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label><form:errors path="passName" cssStyle="color: red;"/>
            <form:input path="passName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="passCategory" id="category" value="Full day"/> Full day</label>
            <label class="checkbox-inline"><form:radiobutton path="passCategory" id="category" value="Morning"/> Morning</label>
            <label class="checkbox-inline"><form:radiobutton path="passCategory" id="category" value="Day"/> Day</label>
        </div>

        <div class="form-group">
            <label for="duration">Duration(months)</label><form:errors path="passDurationInMonths" cssStyle="color: red;"/>
            <form:input path="passDurationInMonths" id="duration" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label><form:errors path="passPrice" cssStyle="color: red;"/>
            <form:input path="passPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="passDescription" id="description" class="form-Control" style="resize:none; height: 10%;"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="gymPassImage">Upload picture</label>
            <form:input id="gymPassImage" path="gymPassImage" type="file" class="form:input-large" />
        </div>


        <br><br>
        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/gymPassInventory"/> " class="btn btn-default">Cancel</a>

        </form:form>


<%@ include file="/WEB-INF/views/template/footer.jsp"%>