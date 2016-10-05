package pl.michalkowol;

import javaslang.collection.CharSeq;
import javaslang.collection.List;
import javaslang.control.Validation;
import lombok.Data;

@Data
class Person {
    private final String name;
    private final int age;
}

class PersonValidator {

    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";
    private static final int MIN_AGE = 0;

    public Validation<List<String>, Person> validatePerson(String name, int age) {
        return Validation.combine(validateName(name), validateAge(age)).ap(Person::new);
    }

    private Validation<String, String> validateName(String name) {
        return CharSeq.of(name).replaceAll(VALID_NAME_CHARS, "").transform(seq -> seq.isEmpty()
                ? Validation.valid(name)
                : Validation.invalid("Name contains invalid characters: '" + seq.distinct().sorted() + "'"));
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < MIN_AGE
                ? Validation.invalid("Age must be greater than " + MIN_AGE)
                : Validation.valid(age);
    }

}


class PersonApp {
    void run() {
        PersonValidator personValidator = new PersonValidator();

        // Valid(Person(John Doe, 30))
        Validation<List<String>, Person> valid = personValidator.validatePerson("John Doe", 30);

        // Invalid(List(Name contains invalid characters: '!4?', Age must be greater than 0))
        Validation<List<String>, Person> invalid = personValidator.validatePerson("John? Doe!4", -1);
    }
}