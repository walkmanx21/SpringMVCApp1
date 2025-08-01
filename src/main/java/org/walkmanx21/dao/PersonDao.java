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
        people.add(new Person(++PEOPLE_COUNT, "Sergey", 35, "sergey@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Ilmira", 35, "ilmira@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Dmitry", 10, "dmitry@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alice", 6, "alice@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Milana", 2, "milana@gmail.com"));
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

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete (int id) {
        people.removeIf(person -> person.getId() == id);
    }

}
