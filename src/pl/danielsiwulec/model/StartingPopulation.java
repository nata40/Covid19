package pl.danielsiwulec.model;

import java.util.Objects;

public class StartingPopulation {
    private int Pi; //liczbie osób zarażonych
    private int Pv; // liczbie osób zdrowych, podatnych na infekcję
    private int Pm; // liczbie osób zmarłych
    private int Pr; // liczbie osób, które wyzdrowiały i nabyły odporność
    private int idSimulationObject;


    public StartingPopulation(int pi, int pv, int pm, int pr, int idSimulationObject) {
        Pi = pi;
        Pv = pv;
        Pm = pm;
        Pr = pr;
        this.idSimulationObject = idSimulationObject;
    }

    public StartingPopulation() {

    }

    public StartingPopulation(int pi, int pv, int pm, int pr) {
        Pi = pi;
        Pv = pv;
        Pm = pm;
        Pr = pr;
    }

    public int getPi() {
        return Pi;
    }

    public void setPi(int pi) {
        Pi = pi;
    }

    public int getPv() {
        return Pv;
    }

    public void setPv(int pv) {
        Pv = pv;
    }

    public int getPm() {
        return Pm;
    }

    public void setPm(int pm) {
        Pm = pm;
    }

    public int getPr() {
        return Pr;
    }

    public void setPr(int pr) {
        Pr = pr;
    }

    public int getIdSimulationObject() {
        return idSimulationObject;
    }

    public void setIdSimulationObject(int idSimulationObject) {
        this.idSimulationObject = idSimulationObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartingPopulation that = (StartingPopulation) o;
        return Pi == that.Pi &&
                Pv == that.Pv &&
                Pm == that.Pm &&
                Pr == that.Pr &&
                idSimulationObject == that.idSimulationObject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Pi, Pv, Pm, Pr, idSimulationObject);
    }

    @Override
    public String toString() {
        return "StartingPopulation{" +
                "Pi=" + Pi +
                ", Pv=" + Pv +
                ", Pm=" + Pm +
                ", Pr=" + Pr +
                ", idSimulationObject=" + idSimulationObject +
                '}'+"\n";
    }
}
