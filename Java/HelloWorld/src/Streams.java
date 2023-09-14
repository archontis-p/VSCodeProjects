import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;


public class Streams {

    public static void main(String[] args){
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));

        List<Person> hundredClub = new ArrayList<>();

        hundredClub = people.stream()
                .filter(person -> person.billions >= 100)
                .sorted(Comparator.comparing(person -> person.name))
                .collect(Collectors.toList());

//        for(Person p: people) {
//            if (p.billions >= 100) {
//                hundredClub.add(p);
//            }
//        }

        hundredClub.forEach(person -> System.out.println(person.name));
    }

    static class Person{
        String name;
        int billions;

        public Person(String name, int billions){
            this.name = name;
            this.billions = billions;
        }
    }


}
