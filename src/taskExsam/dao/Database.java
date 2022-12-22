package taskExsam.dao;

import taskExsam.model.Animal;
import taskExsam.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Person> person = new ArrayList<>();
    private List<Animal> animal = new ArrayList<>();

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

}
