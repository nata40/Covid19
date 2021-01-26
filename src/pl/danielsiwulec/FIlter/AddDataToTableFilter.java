package pl.danielsiwulec.FIlter;


import pl.danielsiwulec.model.CovidSimulation;
import pl.danielsiwulec.service.SimulationService;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class AddDataToTableFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SimulationService simulationService = new SimulationService();
        List<CovidSimulation> covidSimulationList = simulationService.getAllData();
        servletRequest.setAttribute("covidSimList",covidSimulationList);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
