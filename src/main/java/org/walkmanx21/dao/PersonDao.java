package org.walkmanx21.dao;

import org.springframework.stereotype.Component;
import org.walkmanx21.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Sergey"));
        people.add(new Person(++PEOPLE_COUNT, "Ilmira"));
        people.add(new Person(++PEOPLE_COUNT, "Dmitry"));
        people.add(new Person(++PEOPLE_COUNT, "Alice"));
        people.add(new Person(++PEOPLE_COUNT, "Milana"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person1 -> person1.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

}
