package pl.michalkowol;

public class CalcProvider {
    public Calc calc() {
        CalcComponent component = DaggerCalcComponent.builder().caclModule(new CaclModule()).build();
        return component.calc();
    }
}
