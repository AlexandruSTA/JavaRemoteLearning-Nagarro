package com.nagarro.week1.utils;

import com.nagarro.week1.models.Administrator;
import com.nagarro.week1.models.Person;
import com.nagarro.week1.models.Tank;
import com.nagarro.week1.models.User;

import java.util.Random;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Utils class to test the application
 */

public class Utils {

    public static void testPersonClass() {
        Person firstPerson = new Person();
        Person secondPerson = new Person("George", "Washington");
        Person thirdPerson = new Person("Albert Einstein");
        Person fourthPerson = new Person("George Walker Bush");
        Person fifthPerson = new Person("George Walker Bush");

        System.out.println("First Person\n" + firstPerson);
        System.out.println("Second Person\n" + secondPerson);
        System.out.println("Third Person\n" + thirdPerson);
        System.out.println("Fourth Person\n" + fourthPerson);
        System.out.println("Fifth Person\n" + fifthPerson);

        equalityAssert(firstPerson, secondPerson);

        firstPerson.setFirstname(secondPerson.getFirstname());
        firstPerson.setSurname(secondPerson.getSurname());
        System.out.println("Updated first person\n" + firstPerson);

        equalityAssert(firstPerson, secondPerson);
        equalityAssert(firstPerson, thirdPerson);

        equalityAssert(fourthPerson, fifthPerson);
        System.out.println("Reference equality ===> " + (fourthPerson == fifthPerson));


    }

    public static void testTankClass() {
        try {
            Tank<Person> persons = new Tank<>();
            for (int i = 0; i < 100; i++) {
                Person person = new Person(generateRandomString(20), generateRandomString(15));
                persons.push(person);
            }
            System.out.println("================================BEFORE POP================================");
            System.out.println(persons.getCurrentSize());
            System.out.println(persons);

            for (int i = 0; i < 50; i++) {
                persons.pop();
            }

            System.out.println("================================AFTER POP================================");
            System.out.println(persons.getCurrentSize());
            System.out.println(persons);


            Person[] pers = new Person[]{
                    new Person(generateRandomString(10), generateRandomString(10)),
                    new Person(generateRandomString(10), generateRandomString(10)),
                    new Person(generateRandomString(10), generateRandomString(10)),

            };
            Tank<Person> updatedPersons = new Tank<>(pers);
            System.out.println(updatedPersons);
            System.out.println(updatedPersons.pop());
            System.out.println(updatedPersons.pop());
            System.out.println(updatedPersons.pop());
            updatedPersons.push(new Person(generateRandomString(10), generateRandomString(10)));
            System.out.println(updatedPersons.pop());
            System.out.println(updatedPersons.pop());
            System.out.println(updatedPersons);

            System.gc();

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static void testOrderOfCalls() {
        System.out.println("============================STATIC BLOCKS(USER DEFINED)============================");
        User user = new User();
        user.setId(15);
        System.out.println("============================CONSTRUCTORS(ADMINISTRATOR DEFINED)============================");
        User administrator = new Administrator();
        System.out.println("============================METHODS============================");
        user.adminOperations();
        administrator.adminOperations();
        System.out.println("============================LOCAL VARIABLES AND FIELDS============================");
        user.getProductById(20);
        administrator.getProductById(50);
    }

    public static String generateRandomString(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static <S, T> void equalityAssert(S firstEntity, T secondEntity) {
        System.out.println("Equivalence between " + firstEntity + " and " + secondEntity + "===>" + (firstEntity.equals(secondEntity) ? "Equal\n" : "Different\n"));
    }
}
