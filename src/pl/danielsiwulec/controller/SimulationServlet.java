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

@WebServlet("/SimulationServlet")
public class SimulationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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



        PopulationService populationService = new PopulationService();
        SimulationService simulationService = new SimulationService();
        List<StartingPopulation> startingPopulationList = new ArrayList<>();
       CovidSimulation readIDsimulation = new CovidSimulation();
        int id_Simulation;

        List<CovidSimulation> covidSimulationList = simulationService.getAllData();

        for (int i = 0; i < covidSimulationList.size(); i++) {
            if(covidSimulationList.get(i).getN().equals(N)){
               request.getRequestDispatcher("error.jsp").forward(request,response);

            }
        }
        CovidSimulation newCovidSimulation = new CovidSimulation(N,iP,iI,iR,iM,iTi,iTm,iTs);
        simulationService.addSimulation(N,iP,iI,iR,iM,iTi,iTm,iTs);
        readIDsimulation = simulationService.getIDSimulation(N);
        id_Simulation = readIDsimulation.getId();
        startingPopulationList = populationService.beginSimulation(newCovidSimulation,id_Simulation);
        request.setAttribute("simulationList",startingPopulationList);
        request.getRequestDispatcher("simulation.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
