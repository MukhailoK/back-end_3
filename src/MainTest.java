import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    PersonController personController;
    List<Person> people;

    @BeforeEach
    void config() {
        personController = new PersonController();
        people = new ArrayList<>();
        people.add(new Person("Stepan", 21));
        people.add(new Person("Alex", 13));
        people.add(new Person("John", 34));
        people.add(new Person("Tony", 11));
        people.add(new Person("John", 21));
    }

    @Test
    void integerListMap() {
        Map<Integer, List<Person>> actual = personController.integerListMap(people);
        assertEquals(4, actual.entrySet().size());
        assertEquals(2, actual.get(21).size());
    }

    @Test
    void nameCounter() {
        Map<String, Long> actual = personController.nameCounter(people);
        assertEquals(2, actual.get("John"));
    }

    @Test
    void getIfAdult() {
        Map<Boolean, List<Person>> actual = personController.getIfAdult(people);
        assertEquals(3, actual.get(true).size());
        assertEquals(2, actual.get(false).size());
    }

    @Test
    void groupPeopleByAge() {
        Map<Integer, List<String>> actual = personController.groupPeopleByAge(people);
        assertEquals(2, actual.get(21).size());
        assertEquals(4, actual.entrySet().size());
    }
}