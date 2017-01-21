<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Trainer</h1>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/trainers/${trainer.trainerId}.png"/>"
                         style="width: 100%; height: 300px"/>
                </div>
                <div class="col-md-5">
                    <h3>${trainer.trainerName}</h3>
                    <p><strong>Email: </strong>${trainer.trainerEmail}</p>
                    <p><strong>Phone: </strong>${trainer.trainerPhone}</p>
                    <br>
                    <p>${trainer.trainerPersonalInfo}</p>
                </div>
            </div>
        </div>
        <br>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>