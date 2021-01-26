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
      <li><a href="index.jsp" class="btn btn-default"><span class="glyphicon glyphicon-tint"></span> Symulacja COVID-19</a></li>
      <li><a href="#" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span> Nowa Symulacja</a></li>
      <li><a href="NameToPrintGraph.jsp" class="btn btn-default"><span class="glyphicon glyphicon-arrow-right"></span> Szczegóły Symulacji</a></li>

    </ul>
  </div>
  </div>
</nav>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
  <div class="dropdown-menu-left">
    <div class="row no-gutters">
      <div class="col-4 col-sm-3">
        <form class="form-signin" method="post" action="SimulationServlet">
          <h2 class="form-signin-heading">Podaj dane potrzebne do symulacji</h2>
          <label for="simulationName" class="sr-only">Nazwa symulacji</label>
          <input type="text" name="simulationName" id="simulationName" class="form-control" placeholder="nazwa symulacji" required autofocus>
          <label for="simulationSize" class="sr-only">Wielkość populacji</label>
          <input type="text" name="simulationSize" id="simulationSize" class="form-control" placeholder="wielkość populacji" required autofocus>
          <label for="simulationBegginNumber" class="sr-only">Początkowa liczba osób zarażonych</label>
          <input type="text" name="simulationBegginNumber" id="simulationBegginNumber" class="form-control" placeholder="Początkowa liczba zarażonych" required>
          <label for="simulationR" class="sr-only">Ile osób zaraża jedna osoba?</label>
          <input type="text" name="simulationR" id="simulationR" class="form-control" placeholder="Ile osób zaraża jedna osoba?" required>
          <label for="simulationDeadM" class="sr-only">Wskaźnik śmiertelności</label>
          <input type="text" name="simulationDeadM" id="simulationDeadM" class="form-control" placeholder="Wskaźnik śmiertelności" required>
          <label for="simulationTi" class="sr-only">Ilość dni, która upływa od momentu zarażenia do wyzdrowienia chorego</label>
          <input type="text" name="simulationTi" id="simulationTi" class="form-control" placeholder="Ilość dni, która upływa od momentu zarażenia do wyzdrowienia chorego" required>
          <label for="simulationTm" class="sr-only">ilość dni, która upływa od momentu zarażenia do śmierci chorego</label>
          <input type="text" name="simulationTm" id="simulationTm" class="form-control" placeholder="ilość dni, która upływa od momentu zarażenia do śmierci chorego" required>
          <label for="simulationTs" class="sr-only">Ilość dni, dla których ma być przeprowadzona symulacja</label>
          <input type="text" name="simulationTs" id="simulationTs" class="form-control" placeholder="Ilość dni, dla których ma być przeprowadzona symulacja" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Przeprowadź Symulację!</button>
        </form>
        <form class="form-signin" method="post" action="DeleteSimulationServlet">
          <h2 class="form-signin-heading">Usuń Symulacje!</h2>
          <label for="deleteSimulation" class="sr-only">Nazwa symulacji, którą chcesz usunąć</label>
          <input type="text" name="deleteSimulation" id="deleteSimulation" class="form-control" placeholder="Nazwa symulacji, którą chcesz usunąć" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Usuń Symulacje</button>

        </form>
      </div>
      <div class="col-lg-9 col-sm-6 col-md-8">
      <table class="table table-striped table-sm">
        <thead>

        <tr>
          <th>N</th>
          <th>P</th>
          <th>I</th>
          <th>R</th>
          <th>M</th>
          <th>Ti</th>
          <th>Tm</th>
          <th>Ts</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach var="covid" items="${requestScope.covidSimList}">
          <tr>
            <td> <c:out value="${covid.n}"></c:out></td>
            <td> <c:out value="${covid.p}"></c:out></td>
            <td> <c:out value="${covid.i}"></c:out></td>
            <td> <c:out value="${covid.r}"></c:out></td>
            <td> <c:out value="${covid.m}"></c:out></td>
            <td> <c:out value="${covid.ti}"></c:out></td>
            <td> <c:out value="${covid.tm}"></c:out></td>
            <td> <c:out value="${covid.ts}"></c:out></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
    </div>

  </div>
</main>


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

</body>
</html>
