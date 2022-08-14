package org.acme;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhonebookTest {


    @Test
    void shouldAcceptAListOfPeople() {
        Person person1 = new Phonebook.PhonebookPerson("Kelly", "Alexander");
        Person person2 = new Phonebook.PhonebookPerson("Allen", "Jones");
        Person person3 = new Phonebook.PhonebookPerson("Joe", "Jones");
        List<Person> people = Arrays.asList(person2, person3, person1);

        String output = new Phonebook().output(people);
        assertEquals(createName(person1) + System.lineSeparator()
                + createName(person2) + System.lineSeparator()
                + createName(person3)
                , output);
    }

    private String createName(Person person) {
        return person.getLastName() + ", " + person.getFirstName();
    }
}