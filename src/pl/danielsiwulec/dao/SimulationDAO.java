package pl.danielsiwulec.dao;

import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.model.StartingPopulation;


import java.util.List;

public interface SimulationDAO extends GenericDao<CovidSimulation, Long> {
  List<CovidSimulation> getAll();
  public CovidSimulation getSimulationFilterName(String username);
  public boolean update(CovidSimulation updateObject,String name);
}
