<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 09.09.2020
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="#" class="btn btn-default"><span class="glyphicon glyphicon-tint"></span> Symulacja COVID-19</a></li>
            <li><a href="index.jsp" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span> Nowa Symulacja</a></li>
            <li><a href="NameToPrintGraph.jsp" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span> Szczegóły Symulacji</a></li>

        </ul>
    </div>
    </div>
</nav>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <br><br><br>
    <h2>Symulacja na każdy dzień</h2>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>Pi</th>
                <th>Pv</th>
                <th>Pm</th>
                <th>Pr</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="covid" items="${requestScope.simulationList}">
                <tr>
                    <td> <c:out value="${covid.pi}"></c:out></td>
                    <td> <c:out value="${covid.pv}"></c:out></td>
                    <td> <c:out value="${covid.pm}"></c:out></td>
                    <td> <c:out value="${covid.pr}"></c:out></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</main>
</div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>

</body>
</html>
