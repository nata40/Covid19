package pl.danielsiwulec.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.model.StartingPopulation;
import pl.danielsiwulec.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopulationDAOImpl implements PopulationDAO {
    private static final String CREATE_SIMULATION =
            "INSERT INTO population(Pi,Pv,Pm,Pr,idSimulationObject) VALUES(:Pi,:Pv,:Pm,:Pr,:idSimulationObject);";
    private static final String READ_SIMULATION_FILTER_ID =
            "SELECT Pi,Pv,Pm,Pr,idSimulationObject FROM population WHERE idSimulationObject = :idSimulationObject";

    private NamedParameterJdbcTemplate template;

    public PopulationDAOImpl(){
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public StartingPopulation create(StartingPopulation population) {

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(population);
        int update = template.update(CREATE_SIMULATION, sqlParameterSource);
        return population;

    }


    @Override
    public StartingPopulation read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(StartingPopulation updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<StartingPopulation> getAll() {
        return null;
    }


    @Override
    public StartingPopulation getSimulationFilterName(int id) {
        StartingPopulation startingPopulation = null;
        SqlParameterSource parameterSource = new MapSqlParameterSource("idSimulationObject",id);
        startingPopulation = template.queryForObject(READ_SIMULATION_FILTER_ID,parameterSource, new RowMapper<StartingPopulation>() {
            @Override
            public StartingPopulation mapRow(ResultSet resultSet, int i) throws SQLException {
                StartingPopulation startingPopulation1 = null;
                startingPopulation1.setIdSimulationObject(resultSet.getInt("idSimulationObject"));
                startingPopulation1.setPr(resultSet.getInt("Pr"));
                startingPopulation1.setPm(resultSet.getInt("Pm"));
                startingPopulation1.setPv(resultSet.getInt("Pv"));
                startingPopulation1.setPi(resultSet.getInt("Pi"));
                return startingPopulation1;

            }
        });
        return startingPopulation;

    }

    @Override
    public List<StartingPopulation> getSimulationFilterNameList(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("idSimulationObject",id);
        List<StartingPopulation> startingPopulation = template.query(READ_SIMULATION_FILTER_ID, parameterSource, new RowMapper<StartingPopulation>() {
            @Override
            public StartingPopulation mapRow(ResultSet resultSet, int i) throws SQLException {
                StartingPopulation startingPopulation1 = new StartingPopulation();
                startingPopulation1.setIdSimulationObject(resultSet.getInt("idSimulationObject"));
                startingPopulation1.setPr(resultSet.getInt("Pr"));
                startingPopulation1.setPm(resultSet.getInt("Pm"));
                startingPopulation1.setPv(resultSet.getInt("Pv"));
                startingPopulation1.setPi(resultSet.getInt("Pi"));
                return startingPopulation1;
            }
        });

        return  startingPopulation;

    }
}
