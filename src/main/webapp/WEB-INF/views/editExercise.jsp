<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>




<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit exercise</h1>
            <p class="lead">Fill the below information to edit exercise:</p>
        </div>


        <div ng-app="addCategoryApp">
            <div ng-controller="addCategoryCtrl" ng-init="initCategories()">
                <form:form action="${pageContext.request.contextPath}/trainer/exercises/editExercise" method="post"
                           commandName="exercise" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Name</label><form:errors path="exerciseName" cssStyle="color: red;"/>
                        <form:input path="exerciseName" id="name" class="form-Control"/>
                    </div>

                    <div class="form-group">
                        <label for="category">Category</label>
                        <form:select id="category" path="exerciseCategory" items="${categoryList}">
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="description">Description</label>
                        <form:textarea path="exerciseDescription" id="description" class="form-Control"
                                       style="resize:none; height: 10%;"/>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="exerciseImage">Upload picture</label>
                        <form:input id="exerciseImage" path="exerciseImage" type="file" class="form:input-large"/>
                    </div>


                    <br><br>
                    <input type="submit" value="Submit" class="btn btn-default">
                    <a href="<c:url value="/trainer/exercises"/> " class="btn btn-default">Cancel</a>

                </form:form>
            </div>
        </div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>