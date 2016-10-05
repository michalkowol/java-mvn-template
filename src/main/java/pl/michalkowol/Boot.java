package pl.michalkowol;

public class Boot {

    public static void main(String[] args) {
        CalcComponent component = DaggerCalcComponent.builder().caclModule(new CaclModule()).build();
        Calc calc = component.calc();
        int sum = calc.add(1, 3);

        DataExample.Exercise.<Integer>of("michal", 1);
        new DataExample("michal").getName();
        System.out.println(sum);
    }
}
