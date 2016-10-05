package pl.michalkowol;

import javaslang.collection.List;
import javaslang.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

import javaslang.collection.Stream;

@Slf4j
public class Calc {

    public int add(int a, int b) {
        log.info("[a={}, b={}]", a, b);
        Stream.of(1, 2, 3).map(Object::toString).toList();
        List.of(1, 2, 3).mkString(", ");
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}

