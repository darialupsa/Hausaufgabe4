package com.repository;

import com.entities.Course;
import com.entities.Person;

import java.util.List;

public class PersonRepo extends InMemoryRepo<Person> {

    public PersonRepo() {
        super();
    }

    /**
     * Adauga un obiect de tip Person
     *
     * @param obj
     * @return persoana adaugata
     */
    @Override
    public Person create(Person obj) {
        return super.create(obj);
    }

    /**
     * Updateaza obiectul de tip person
     *
     * @param obj care o sa fie adaugat
     * @return noul obiect actualizat
     *
     */
    @Override
    public Person update(Person obj) {
        Person personToUpdate = this.repoList.stream()
                .filter(person -> person.getFirstName() == obj.getFirstName())
                .findFirst()
                .orElseThrow();

        personToUpdate.setLastName(obj.getLastName());
        return personToUpdate;
    }
}
