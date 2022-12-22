import taskExsam.enums.Gender;
import taskExsam.model.Animal;
import taskExsam.model.Person;
import taskExsam.service.impl.AnimalService;
import taskExsam.service.impl.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static AnimalService animalService = new AnimalService();
    public static PersonService personService = new PersonService();


    public static void main(String[] args) {

        Animal animal1 = new Animal(1, "Cat", 4, Gender.FEMALE);
        Animal animal2 = new Animal(2, "Dog", 6, Gender.MALE);
        Animal animal3 = new Animal(3, "Horse", 8, Gender.MALE);
        Animal animal4 = new Animal(4, "Sheep", 7, Gender.FEMALE);
        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4));

        Person person1 = new Person(1, "Alina", 3, Gender.FEMALE);
        Person person2 = new Person(2, "Nik", 9, Gender.MALE);
        Person person3 = new Person(3, "Alex", 10, Gender.MALE);
        Person person4 = new Person(4, "Sara", 8, Gender.FEMALE);
        List<Person> personList = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));

        while (true) {
            System.out.println("""
                    ~~~~~~~Commands~~~~~~
                    1 Add Person!
                    2 GetByIdPerson!            
                    3 RemovePerson!
                    4 GetAllPerson!
                    5 SortByNamePerson! 
                    6 FilterByGenderPerson!                           
                    7 ClearPerson!
                    9 Add Animal!
                    10 GetByIdAnimal!
                    11 GetAllAnimal!
                    12 SortByNameAnimal!
                    13 FilterByGender!
                    14 ClearAnimal                         
                      """);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                switch (num) {
                    case 1 -> System.out.println(personService.add(personList));
                    case 2 -> {
                        System.out.print("Napishite id: ");
                        long id = new Scanner(System.in).nextLong();
                        System.out.println(personService.getById(id));
                    }
                    case 3 -> {
                        System.out.print("Napishite name :");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(personService.removeByName(name));
                    }
                    case 4 -> System.out.println(personService.getAll());
                    case 5 -> System.out.println(personService.sortByName());
                    case 6 -> System.out.println(personService.filterByGender());
                    case 7 -> System.out.println(personService.clear());
                    case 8 -> System.out.println(animalService.add(animalList));
                    case 9 -> {
                        System.out.print("Napishite id: ");
                        long id = new Scanner(System.in).nextLong();
                        System.out.println(animalService.getById(id));
                    }
                    case 10 -> {
                        System.out.print("Napishite name :");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(animalService.removeByName(name));
                    }
                    case 11 -> System.out.println(animalService.getAll());
                    case 12 -> System.out.println(animalService.sortByName());
                    case 13 -> System.out.println(animalService.filterByGender());
                    case 14 -> System.out.println(animalService.clear());
                }
            }
        }


    }
}