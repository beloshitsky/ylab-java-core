package Task1;
/*
 Task1
     Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

     Что должно получиться Key: Amelia
         Value:4
         Key: Emily
         Value:1
         Key: Harry
         Value:3
         Key: Jack
         Value:1
*/

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");

        Arrays.stream(RAW_DATA)
                .map(person -> person.id + " - " + person.name)
                .forEach(System.out::println);

        System.out.println("\n" + "Filtered data:");

        Arrays.stream(RAW_DATA)
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toMap(Person::getId, Person::getName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getValue(),
                        p -> 1, Integer::sum
                )).forEach((key, value) -> System.out.println("Key: " + key + " - " + "Value: " + value));

    }
}
