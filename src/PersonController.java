import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class PersonController {
    public Map<Integer, List<Person>> integerListMap(List<Person> list) {
        return list.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    public Map<String, Long> nameCounter(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getName, counting()));
    }

    public Map<Boolean, List<Person>> getIfAdult(List<Person> people) {
        return people.stream().collect(Collectors.partitioningBy(person -> person.age >= 18));
    }

    public Map<Integer, List<String>> groupPeopleByAge(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));
    }
}
