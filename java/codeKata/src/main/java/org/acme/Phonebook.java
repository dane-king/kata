package org.acme;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Phonebook {
    public String output(List<Person> people) {
        Comparator<Person> comparator = Comparator.comparing(Person::getLastName, (s1, s2) -> {
            return s2.compareTo(s1);
        });

        return people.stream()
                .map(p->p.getLastName() + ", " + p.getFirstName())
                .sorted()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static class PhonebookPerson implements Person {
        private final String firstName;
        private final String lastName;

        public PhonebookPerson(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String getFirstName() {
            return this.firstName;
        }

        @Override
        public String getLastName() {
            return this.lastName;
        }
    }
}
