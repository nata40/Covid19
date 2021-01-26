package pl.danielsiwulec.dao;

import org.springframework.jdbc.core.ResultSetExtractor;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationDAOImpl implements SimulationDAO {
    private static final String CREATE_SIMULATION =
            "INSERT INTO simulationobject(N,P,I,R,M,Ti,Tm,Ts) VALUES(:N,:P,:I,:R,:M,:Ti,:Tm,:Ts); ";
    private static final String GET_ALL_START_DATA =
            "SELECT * FROM simulationobject";
    private static final String READ_SIMULATION_FILTER_NAME =
            "SELECT idSimulationObject,N,P,I,R,M,Ti,Tm,Ts FROM simulationobject WHERE N=:N;";
    private static final String UPDATE_SIMULATION = "UPDATE simulationobject SET P=:P,I=:I,R=:R,M=:M,Ti=:Ti,Tm=:Tm,Ts=:Ts WHERE N=:N;";
    private NamedParameterJdbcTemplate template;

    public SimulationDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public CovidSimulation create(CovidSimulation newObject) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(newObject);
        int update = template.update(CREATE_SIMULATION, sqlParameterSource);
        return newObject;
    }

    @Override
    public CovidSimulation read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(CovidSimulation updateObject) {
        return false;
    }

    @Override
    public boolean update(CovidSimulation updateObject,String name) {
        boolean result = false;
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("P",updateObject.getP());
        stringObjectMap.put("I",updateObject.getI());
        stringObjectMap.put("R",updateObject.getR());
        stringObjectMap.put("M",updateObject.getM());
        stringObjectMap.put("Ti",updateObject.getTi());
        stringObjectMap.put("Tm",updateObject.getTm());
        stringObjectMap.put("Ts",updateObject.getTs());
        SqlParameterSource parameterSource = new MapSqlParameterSource(stringObjectMap).addValue("N",name);
        int update = template.update(UPDATE_SIMULATION,parameterSource);
        if(update>0){
            result = true;

        }
        return result;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }


    @Override
    public List<CovidSimulation> getAll() {
        List<CovidSimulation> covidSimulationsList = template.query(GET_ALL_START_DATA, new RowMapper<CovidSimulation>() {
            @Override
            public CovidSimulation mapRow(ResultSet resultSet, int i) throws SQLException {
                CovidSimulation covidSimulation = new CovidSimulation();
                covidSimulation.setN(resultSet.getString("N"));
                covidSimulation.setTs(resultSet.getInt("Ts"));
                covidSimulation.setTm(resultSet.getInt("Tm"));
                covidSimulation.setM(resultSet.getInt("M"));
                covidSimulation.setP(resultSet.getInt("P"));
                covidSimulation.setR(resultSet.getInt("R"));
                covidSimulation.setI(resultSet.getInt("I"));
                covidSimulation.setTi(resultSet.getInt("Ti"));
                return covidSimulation;
            }
        });
        return covidSimulationsList;
    }
    @Override
    public CovidSimulation getSimulationFilterName(String username) {
        CovidSimulation covidSimulation = null;
        SqlParameterSource parameterSource = new MapSqlParameterSource("N",username);
        covidSimulation = template.queryForObject(READ_SIMULATION_FILTER_NAME, parameterSource, new RowMapper<CovidSimulation>() {
            @Override
            public CovidSimulation mapRow(ResultSet resultSet, int i) throws SQLException {
                CovidSimulation covidSimulation1 = new CovidSimulation();
                covidSimulation1.setN(resultSet.getString("N"));
                covidSimulation1.setTs(resultSet.getInt("Ts"));
                covidSimulation1.setTm(resultSet.getInt("Tm"));
                covidSimulation1.setM(resultSet.getInt("M"));
                covidSimulation1.setP(resultSet.getInt("P"));
                covidSimulation1.setR(resultSet.getInt("R"));
                covidSimulation1.setI(resultSet.getInt("I"));
                covidSimulation1.setTi(resultSet.getInt("Ti"));
                covidSimulation1.setId(resultSet.getInt("idSimulationObject"));
                return covidSimulation1;

            }
        });
        return covidSimulation;
    }
}
