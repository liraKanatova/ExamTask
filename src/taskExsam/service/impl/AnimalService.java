package taskExsam.service.impl;

import taskExsam.dao.Database;
import taskExsam.enums.Gender;
import taskExsam.model.Animal;
import taskExsam.service.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalService implements Service<Animal> {
    Database database = new Database();


    @Override
    public String add(List<Animal> t) {
        this.database.getAnimal().addAll(t);
        return "uspeshno!";
    }

    @Override
    public Animal getById(long id) {
        List<Animal> list = database.getAnimal().stream().filter(x -> x.getId() == id).toList();
        for (Animal animal : list) {
            return animal;
        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        List<Animal> list = database.getAnimal().stream().filter(x -> x.getName().equals(name)).toList();
        database.getAnimal().removeAll(list);
        return "Uspeshno  udalili!";

    }

    @Override
    public List<Animal> getAll() {
        return this.database.getAnimal();
    }

    @Override
    public List<Animal> sortByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Napishite 1= ascending, ili 2=descending");
        if (sc.nextInt() == 1) {
            return database.getAnimal().stream().sorted(Comparator.comparing(Animal::getName)).toList();
        } else {
            return database.getAnimal().stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();

        }
    }

    @Override
    public List<Animal> filterByGender() {
        System.out.println("1 males,2 females");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Animal> males = database.getAnimal().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
                return males;
            }
            case 2 -> {
                List<Animal> females = database.getAnimal().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
                return females;
            }
        }
        return null;
    }


    @Override
    public List<Animal> clear() {
        database.getAnimal().clear();
        return database.getAnimal();
    }
}









