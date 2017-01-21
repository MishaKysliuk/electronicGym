<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>${client.clientName}</h1>
        </div>

        <div class="container">
            <p><strong>Email: </strong>${client.clientEmail}</p>
            <p><strong>Phone: </strong>${client.clientPhone}</p>
            <br>
            <p><strong>Weight: </strong>${client.clientCard.weight}</p>
            <p><strong>Height: </strong>${client.clientCard.height}</p>
            <p><strong>Fat percent: </strong>${client.clientCard.fatPercent}</p>
            <p><strong>Waist: </strong>${client.clientCard.waist}</p>
            <p><strong>Breast volume: </strong>${client.clientCard.breastVolume}</p>
            <p><strong>Biceps volume: </strong>${client.clientCard.bicepsVolume}</p>
            <p><strong>Leg volume: </strong>${client.clientCard.legVolume}</p>
            <p><a href="<c:url value="/trainer/trainerClients"/> " class="btn btn-default">Back</a></p>
        </div>
        <br>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>