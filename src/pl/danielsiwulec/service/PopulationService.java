package pl.danielsiwulec.service;

import pl.danielsiwulec.dao.DAOFactory;
import pl.danielsiwulec.dao.PopulationDAO;
import pl.danielsiwulec.dao.SimulationDAO;
import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.model.StartingPopulation;

import java.util.ArrayList;
import java.util.List;

public class PopulationService {

    public List<StartingPopulation> beginSimulation(CovidSimulation covidSimulation,int idCovidSimulation){
        DAOFactory factory = DAOFactory.getDAOFactory();
        PopulationDAO populationDAO = factory.getPopulationDao();
        List<StartingPopulation> startingPopulations = new ArrayList<>();
        startingPopulations = makeSimulation(covidSimulation,idCovidSimulation);
        for (int i = 0; i < startingPopulations.size(); i++) {
            populationDAO.create(startingPopulations.get(i));
        }
        return  startingPopulations;
    }
    public StartingPopulation getSimulationFilterID(int id){
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        PopulationDAO populationDAO = daoFactory.getPopulationDao();
        StartingPopulation startingPopulation = populationDAO.getSimulationFilterName(id);
        return startingPopulation;
    }
    public List<StartingPopulation> getSimulationFilterIDList(int id){
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        PopulationDAO populationDAO = daoFactory.getPopulationDao();
        System.out.println("Jestem w getSimulationFIlterID");
        List<StartingPopulation> startingPopulations = populationDAO.getSimulationFilterNameList(id);
        System.out.println(startingPopulations.get(1));
        return startingPopulations;
    }





    private List<StartingPopulation> makeSimulation(CovidSimulation sim,int idCovidSimulation){
        String N;
        int P,I,R,Ti,Tm,Ts;
        float M;
        N = sim.getN();
        P = sim.getP();
        I = sim.getI();
        R = sim.getR();
        M = sim.getM();
        Ti = sim.getTi();
        Tm = sim.getTm();
        Ts = sim.getTs();
        StartingPopulation stPopulation = new StartingPopulation();
        List<StartingPopulation> startingPopulationList = new ArrayList<StartingPopulation>();
        List<StartingPopulation> list = new ArrayList<>();

        int[] Pi = new int[Ts];
        int[] Pv = new int[Ts];
        int[] Pm = new int[Ts];
        int[] Pr = new int[Ts];

        int[] Populacja = new int[Ts];
        int day_Dead = 1;
        int day_Health = 1;

        for (int i = 1; i < Ts; i++) {

            if(i<=1){
                Pi[i] = I*R;
                Pv[i] = P - Pi[i];
            }else{
                Pi[i] = Pi[i-1] * R;
                Pv[i] =  Pv[i-1]-Pi[i];
            }

            if(day_Dead<Tm){
                Pm[i] +=Pm[i-1];
                day_Dead++;
            } else if(day_Dead==Tm){
                Pm[i] = (int) (Pi[i] * M *0.01);
                Pi[i] = Pi[i] - Pm[i];
                day_Dead = 1;
            }
            if(day_Health<Ti){
                Pr[i] += Pr[i-1];
                day_Health++;
            }else if(day_Health==Ti) {
                Pr[i] = Pi[i-1];
                Pi[i] = Pi[i]-Pr[i];
                day_Health = 1;
            }
            Populacja[i] = (Pi[i]+Pv[i]+Pr[i])-Pm[i];
            startingPopulationList.add(new StartingPopulation(Pi[i],Pv[i],Pm[i],Pr[i],idCovidSimulation));

        }
        return startingPopulationList;
    }

}
