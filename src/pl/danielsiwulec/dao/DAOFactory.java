package pl.danielsiwulec.dao;

import pl.danielsiwulec.exception.NoSuchDbTypeException;

public abstract class DAOFactory {
    private static final int MYSQL_DAO_FACTORY = 1 ;

    public abstract SimulationDAO getSimulatonDao();
    public abstract PopulationDAO getPopulationDao();
    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
            case MYSQL_DAO_FACTORY:
                return new MysqlDAOFactory();
            default:
                throw new NoSuchDbTypeException();
        }
    }

}
