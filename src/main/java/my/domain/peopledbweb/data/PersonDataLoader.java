package my.domain.peopledbweb.data;

import my.domain.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            System.out.println("Running this stuff here");
            List<Person> people = List.of(
                    new Person(null, "Jake", "Sully", LocalDate.of(1950, 1, 3),"dummy@sample.com", new BigDecimal("50000")),
                    new Person(null, "Sarah", "Bernard", LocalDate.of(1960, 2, 2),"dummy@sample.com", new BigDecimal("70000")),
                    new Person(null, "Johnny", "Jackson", LocalDate.of(1970, 3, 1),"dummy@sample.com", new BigDecimal("90000")),
                    new Person(null, "Mike", "Kimi", LocalDate.of(1980, 5, 7), "dummy@sample.com",new BigDecimal("30000")),
                    new Person(null, "Gigi", "Becali", LocalDate.of(1990, 7, 28), "dummy@sample.com",new BigDecimal("30000")),
                    new Person(null, "Vasile", "Muraru", LocalDate.of(2000, 8, 30),"dummy@sample.com", new BigDecimal("30000")),
                    new Person(null, "Akira", "Salo", LocalDate.of(1995, 9, 14),"dummy@sample.com", new BigDecimal("30000"))
            );
            personRepository.saveAll(people);
        }

    }
}
