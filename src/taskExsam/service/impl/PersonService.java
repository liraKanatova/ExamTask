package taskExsam.service.impl;

import taskExsam.dao.Database;
import taskExsam.enums.Gender;
import taskExsam.model.Person;
import taskExsam.service.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonService implements Service<Person> {
    Database database = new Database();


    @Override
    public String add(List<Person> t) {
        database.getPerson().addAll(t);
        return "Uspeshno!";
    }

    @Override
    public Person getById(long id) {
        for (Person person : database.getPerson()) {
            if (person.getId() == id) {
                return person;
            }

        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        for (Person person : database.getPerson()) {
            if (person.getName().equals(name)) {
                database.getPerson().remove(person);
                return "Uspeshno udalili!";
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return database.getPerson();
    }

    @Override
    public List<Person> sortByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Napishite 1= ascending, ili 2=descending");
        if (sc.nextInt() == 1) {
            return database.getPerson().stream().sorted(Comparator.comparing(Person::getName)).toList();
        } else {
            return database.getPerson().stream().sorted(Comparator.comparing(Person::getName).reversed()).toList();

        }

    }

    @Override
    public List<Person> filterByGender() {
        System.out.println("1 males,2 females");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Person> males = database.getPerson().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
                return males;
            }
            case 2 -> {
                List<Person> females = database.getPerson().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
                return females;
            }
        }
        return null;

    }


    @Override
    public List<Person> clear() {
        database.getPerson().clear();
        return database.getPerson();

    }
}
