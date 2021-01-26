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
import java.util.Random;

@WebServlet("/allSimulation")
public class AllSimulationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        String name = request.getParameter("simulationName");
        SimulationService simulationService = new SimulationService();
        CovidSimulation readIDsimulation;
        PopulationService populationService = new PopulationService();
        int id_Simulation;

        readIDsimulation = simulationService.getIDSimulation(name);
        id_Simulation = readIDsimulation.getId();
        System.out.println(id_Simulation);



        List<StartingPopulation> startingPopulation = populationService.getSimulationFilterIDList(id_Simulation);



        //startingPopulationList = populationService.beginSimulation(readIDsimulation,id_Simulation);
        //request.setAttribute("simulationList",startingPopulationList);
        request.setAttribute("simulationList",startingPopulation);
        request.getRequestDispatcher("simulation2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
