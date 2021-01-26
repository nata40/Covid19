package pl.danielsiwulec.service;

import pl.danielsiwulec.dao.DAOFactory;
import pl.danielsiwulec.dao.SimulationDAO;
import pl.danielsiwulec.model.CovidSimulation;

import java.util.List;


public class SimulationService {

    public void addSimulation(String N,int P, int I, int R, int M, int Ti, int Tm, int Ts){
        CovidSimulation covidSimulation = new CovidSimulation();
        covidSimulation.setN(N);
        covidSimulation.setP(P);
        covidSimulation.setI(I);
        covidSimulation.setR(R);
        covidSimulation.setM(M);
        covidSimulation.setTi(Ti);
        covidSimulation.setTm(Tm);
        covidSimulation.setTs(Ts);
        DAOFactory factory = DAOFactory.getDAOFactory();
        SimulationDAO simulationDAO = factory.getSimulatonDao();
        simulationDAO.create(covidSimulation);
    }
    public CovidSimulation getIDSimulation(String username){
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        SimulationDAO simulationDAO = daoFactory.getSimulatonDao();
       CovidSimulation covidSimulation =  simulationDAO.getSimulationFilterName(username);
       return covidSimulation;
    }
    public List<CovidSimulation> getAllData(){
        DAOFactory factory = DAOFactory.getDAOFactory();
        SimulationDAO simulationDAO = factory.getSimulatonDao();
        return simulationDAO.getAll();
    }

    public void updateSimulation(CovidSimulation covidSimulation,String name){
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        SimulationDAO simulationDAO = daoFactory.getSimulatonDao();
        simulationDAO.update(covidSimulation,name);
    }
}
