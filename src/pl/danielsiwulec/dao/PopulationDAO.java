package pl.danielsiwulec.dao;

import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.model.StartingPopulation;

import java.util.List;

public interface PopulationDAO extends GenericDao<StartingPopulation,Long> {
    public StartingPopulation getSimulationFilterName(int id);
    public List<StartingPopulation> getSimulationFilterNameList(int id);
}
