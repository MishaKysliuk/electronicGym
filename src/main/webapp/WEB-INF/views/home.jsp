<%--
  Created by IntelliJ IDEA.
  User: MichaelMAC
  Date: 04.01.17
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="<c:url value="/resources/images/carousel1.jpg"/> " alt="Start today">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Start training with Gold's gym</h1>
                    <p>You just need to choose pass and start training!</p>
                    <p><a class="btn btn-lg btn-primary" href="<c:url value="/gymPass/passList"/>" role="button">Choose pass</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="<c:url value="/resources/images/carousel2.jpg"/> " alt="Choose trainer">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Choose your own trainer!</h1>
                    <p>We have got a lot of professionals in our team, so everybody will find a good trainer!</p>
                    <p><a class="btn btn-lg btn-primary" href="<c:url value="/trainers"/>" role="button">Choose trainer</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="<c:url value="/resources/images/carousel3.jpg"/> " alt="Be in fit">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Be in fit with Gold's gym!</h1>
                    <p>Today is a good day to start!</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/circle1.png"/>" alt="" width="140" height="140">
            <h2>Passes</h2>
            <p>Choose your own gym pass to be fit all the time.</p>
            <p><a class="btn btn-default" href="<c:url value="/gymPass/passList"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/circle2.png"/>" alt="Generic placeholder image" width="140" height="140">
            <h2>Trainers</h2>
            <p>Choice your trainer who will make training the most efficient for you</p>
            <p><a class="btn btn-default" href="<c:url value="/trainers"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/circle3.png"/>" alt="Generic placeholder image" width="140" height="140">
            <h2>Contacts</h2>
            <p>Watch contact information about our gym</p>
            <p><a class="btn btn-default" href="<c:url value="/contacts"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->





    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="<c:url value ="/resources/js/jquery-3.1.1.min.js"/>"><\/script>')</script>
<script src="<c:url value ="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
