package pl.danielsiwulec.model;

import java.util.Objects;

public class CovidSimulation {
    private String N;  //- Nazwa symulacji (string)
    private int P;  //- wielkość populacji
    private int I; //- początkowa liczba osób zarażonych
    private int R; //- wskaźnik określający ile osób zaraża jedna zarażona osoba, czyli znany z newsów
    private int M; //- wskaźnik śmiertelności, określający ilu spośród zarażonych umiera
    private int Ti; //- ilość dni, która upływa od momentu zarażenia do wyzdrowienia chorego
    private int Tm; //- ilość dni, która upływa od momentu zarażenia do śmierci chorego
    private int Ts; //- Ilość dni, dla których ma być przeprowadzona symulacja
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CovidSimulation(String n, int p, int i, int r, int m, int ti, int tm, int ts) {
        N = n;
        P = p;
        I = i;
        R = r;
        M = m;
        Ti = ti;
        Tm = tm;
        Ts = ts;
    }

    public CovidSimulation() {

    }

    public String getN() {
        return N;
    }

    public void setN(String n) {
        N = n;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getTi() {
        return Ti;
    }

    public void setTi(int ti) {
        Ti = ti;
    }

    public int getTm() {
        return Tm;
    }

    public void setTm(int tm) {
        Tm = tm;
    }

    public int getTs() {
        return Ts;
    }

    public void setTs(int ts) {
        Ts = ts;
    }

    @Override
    public String toString() {
        return "CovidSimulation{" +
                "N='" + N + '\'' +
                ", P=" + P +
                ", I=" + I +
                ", R=" + R +
                ", M=" + M +
                ", Ti=" + Ti +
                ", Tm=" + Tm +
                ", Ts=" + Ts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidSimulation that = (CovidSimulation) o;
        return P == that.P &&
                I == that.I &&
                Float.compare(that.R, R) == 0 &&
                M == that.M &&
                Ti == that.Ti &&
                Tm == that.Tm &&
                Ts == that.Ts &&
                Objects.equals(N, that.N);
    }

    @Override
    public int hashCode() {
        return Objects.hash(N, P, I, R, M, Ti, Tm, Ts);
    }
}
