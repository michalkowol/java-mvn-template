package pl.michalkowol;

import dagger.Module;
import dagger.Provides;

@Module
class CaclModule {

    @Provides
    Calc calc() {
        return new Calc();
    }
}
