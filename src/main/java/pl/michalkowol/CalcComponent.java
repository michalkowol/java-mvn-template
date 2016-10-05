package pl.michalkowol;

import dagger.Component;

@Component(
        modules = CaclModule.class
)
interface CalcComponent {
    Calc calc();
}
