package pl.danielsiwulec.dao;

public class MysqlDAOFactory extends DAOFactory  {
    @Override
    public SimulationDAO getSimulatonDao() {
        return new SimulationDAOImpl();
    }

    @Override
    public PopulationDAO getPopulationDao() {
        return new PopulationDAOImpl();
    }
}
