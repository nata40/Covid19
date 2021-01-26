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
    <title>Symulacja COVID-19</title>
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
            <li><a href="NameToUpdate.jsp" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span> Edycja Symulacji</a></li>
        </ul>
    </div>
    </div>
</nav>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <br><br><br>
    <div class="row no-gutters">
        <div class="col-sm">
            <h2>Wykres osób zmarłych</h2>
            <canvas class="my-4" id="myChart1" width="900" height="380"></canvas>
            <h2>Wykres osób, które wyzdrowiały i nabyły odporność</h2>
            <canvas class="my-4" id="myChart2" width="900" height="380"></canvas>
        </div>
        <div class="col-sm">
            <h2>Wykres osób zdrowych, podatnych na infekcję</h2>
            <canvas class="my-4" id="myChart3" width="900" height="380"></canvas>
            <h2>Wykres osób zarażonych</h2>
            <canvas class="my-4" id="myChart4" width="900" height="380"></canvas>

        </div>
    </div>


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

<!-- Graphs -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart1");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
                30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57
                ,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,
                76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100],
            datasets: [{
                data: [<c:forEach var="simulation" items="${requestScope.simulationList}">

                    <c:out value="${simulation.pm}"></c:out>
                    <c:out value=","></c:out>
                    </c:forEach>],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
<script>
    var ctx = document.getElementById("myChart2");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
                30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57
                ,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,
                76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100],
            datasets: [{
                data: [<c:forEach var="simulation" items="${requestScope.simulationList}">

                    <c:out value="${simulation.pr}"></c:out>
                    <c:out value=","></c:out>
                    </c:forEach>],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
<script>
    var ctx = document.getElementById("myChart3");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
                30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57
                ,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,
                76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100],
            datasets: [{
                data: [<c:forEach var="simulation" items="${requestScope.simulationList}">

                    <c:out value="${simulation.pv}"></c:out>
                    <c:out value=","></c:out>
                    </c:forEach>],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
<script>
    var ctx = document.getElementById("myChart4");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
                30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57
                ,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,
                76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100],
            datasets: [{
                data: [<c:forEach var="simulation" items="${requestScope.simulationList}">

                    <c:out value="${simulation.pi}"></c:out>
                    <c:out value=","></c:out>
                    </c:forEach>],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
</body>
</html>
