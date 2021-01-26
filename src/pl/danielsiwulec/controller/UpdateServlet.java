package pl.danielsiwulec.controller;

import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.model.StartingPopulation;
import pl.danielsiwulec.service.PopulationService;
import pl.danielsiwulec.service.SimulationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String N = request.getParameter("simulationName");
        String P = request.getParameter("simulationSize");
        String I = request.getParameter("simulationBegginNumber");
        String R = request.getParameter("simulationR");
        String M = request.getParameter("simulationDeadM");
        String Ti = request.getParameter("simulationTi");
        String Tm = request.getParameter("simulationTm");
        String Ts = request.getParameter("simulationTs");

        int iP, iI, iM, iTi, iTm, iTs;
        int iR;
        iP = Integer.parseInt(P);
        iI = Integer.parseInt(I);
        iR = Integer.parseInt(R);
        iM = Integer.parseInt(M);
        iTi = Integer.parseInt(Ti);
        iTm = Integer.parseInt(Tm);
        iTs = Integer.parseInt(Ts);

        List<StartingPopulation> startingPopulationList = new ArrayList<>();
        PopulationService populationService = new PopulationService();
        CovidSimulation covidSimulation = new CovidSimulation(N,iP,iI,iR,iM,iTi,iTm,iTs);
        SimulationService simulationService = new SimulationService();
        simulationService.updateSimulation(covidSimulation,N);
        int id_Simulation;
        CovidSimulation readIDsimulation = new CovidSimulation();
        readIDsimulation = simulationService.getIDSimulation(N);
        id_Simulation = readIDsimulation.getId();

        startingPopulationList = populationService.beginSimulation(covidSimulation,id_Simulation);
        request.setAttribute("simulationList",startingPopulationList);
        request.getRequestDispatcher("simulation.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
