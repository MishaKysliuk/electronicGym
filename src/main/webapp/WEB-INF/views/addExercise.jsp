<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 07.01.17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<script>
    $(document).ready(function () {
        $('.nav-toggle').click(function () {
            //get collapse content selector
            var collapse_content_selector = $(this).attr('href');

            //make the collapse content to be shown or hide
            var toggle_switch = $(this);
            $(collapse_content_selector).toggle(function () {
                if ($(this).css('display') == 'none') {
                    //change the button label to be 'Show'
                    toggle_switch.html('Add new category');
                } else {
                    //change the button label to be 'Hide'
                    toggle_switch.html('Hide');
                }
            });
        });

    });
</script>

<script src="<c:url value="/resources/js/addCategoryController.js" /> "></script>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add exercise</h1>
            <p class="lead">Fill the below information to add exercise:</p>
        </div>


        <div ng-app="addCategoryApp">
            <div ng-controller="addCategoryCtrl" ng-init="initCategories()">
                <form:form action="${pageContext.request.contextPath}/trainer/exercises/addExercise" method="post"
                           commandName="exercise" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Name</label><form:errors path="exerciseName" cssStyle="color: red;"/>
                        <form:input path="exerciseName" id="name" class="form-Control"/>
                    </div>

                    <div class="form-group">
                        <label for="category">Category</label>
                        <form:select id="category" path="exerciseCategory">
                            <form:option ng-repeat = "category in categoryList" value="{{category.categoryId}}">{{category.name}}</form:option>
                        </form:select>
                    </div>
                    <div>
                        <button href="#addCategory" class="btn btn-info nav-toggle" type="button">Add new category
                        </button>
                    </div>


                    <div id="addCategory" style="display: none;">
                        <p></p>
                        <div>
                            <div class="text">Name:</div>
                            <input ng-model="categoryName"/>
                            <button class="btn btn-primary" ng-click="addCategory()" type="button">
                                Create category
                            </button>
                        </div>
                        <p></p>
                    </div>

                    <div class="form-group">
                        <label for="secForRep">Average seconds for one repeat: </label><form:errors path="avgSecondsForRep" cssStyle="color: red;"/>
                        <form:input path="avgSecondsForRep" id="secForRep" />
                    </div>
                    <div class="form-group">
                        <label for="secBetweenSets">Average seconds between sets: </label><form:errors path="avgSecondsBetweenSets" cssStyle="color: red;"/>
                        <form:input path="avgSecondsBetweenSets" id="secBetweenSets" />
                    </div>

                    <p></p>
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