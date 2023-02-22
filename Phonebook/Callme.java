package Phonebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Callme {

    static List<People> entryList = new ArrayList<People>();

    public static void main(String[] args) {
        People people = new People("me", "me", "1234567890");
        Address address = new Address(123, "moby", "stl", "mo", 54321);

        people.setAddress(address);
        entryList.add(people);

        int selection = 0;
        Scanner scr = new Scanner(System.in);

        while (selection != 6) {
            System.out.println("1) Select to create a new entry in the phonebook!");
            System.out.println("2) Select to search through the phonebook");
            System.out.println("3) Select to delete a record using a telephone number for an existing entry");
            System.out.println("4) Select to update a record using a telephone number for an existing entry ");
            System.out.println("5) Select to show all entries in alphabetical order by last name");
            System.out.println("6) Select to exit the phonebook!");

            selection = scr.nextInt();
            scr.nextLine();

            switch (selection) {
                case 1:
                    entry(scr);

                    break;
                case 2:
                    search(scr);

                    break;
                case 3:
                    delete(scr);

                    break;
                case 4:
                    update(scr);

                    break;
                case 5:
                    sort();

                    break;
                case 6:

            }

        }
    }

    public static People entry(Scanner scr) {
        System.out.println("Please enter your first name: ");
        String firstName = scr.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scr.nextLine();
        System.out.println("Please your phone number: ");
        String phone = scr.nextLine();

        People people = new People(firstName, lastName, phone);

        Address address = info(scr);
        people.setAddress(address);

        entryList.add(people);

        return people;
    }

    public static Address info(Scanner scr) {

        System.out.println("Please enter your address number");
        int houseapptNumb = scr.nextInt();
        scr.nextLine();
        System.out.println("Please enter your street name");
        String streetName = scr.nextLine();
        System.out.println("What city is your address?");
        String city = scr.nextLine();
        System.out.println("Which state is your address in?");
        String state = scr.nextLine();
        System.out.println("Which zipcode is your address in");
        Integer zipCode = scr.nextInt();

        Address address = new Address(houseapptNumb, streetName, city, state, zipCode);

        return address;
    }

    public static void search(Scanner scr) {
        int selection = 0;

        System.out.println("1) Select if you would like to search by first name");
        System.out.println("2) Select if you would like to search by last name");
        System.out.println("3) Select if you would like to search by full name");
        System.out.println("4) Select if you would like to search by telephone number");
        System.out.println("5) Select if you would like to search by city");
        System.out.println("6) Select if you would like to search by state");

        selection = scr.nextInt();
        scr.nextLine();

        boolean bool = true;

        if (selection == 1) {
            System.out.println("What is the first name of whom you're searching?");
            String first = scr.nextLine();
            
            for (int i = 0; i < entryList.size(); i++) {
                if (entryList.get(i).getFirstName().equals(first)) {
                    System.out.println(entryList.get(i));
                    bool = false;
                }

            }

            if (bool){
                System.out.println("Entry not found");
            }
        }

        if (selection == 2) {
            System.out.println("What is the last name of whom you're searching?");
            String last = scr.nextLine();
            for (int i = 0; i < entryList.size(); i++) {
                if (last.equals(entryList.get(i).getLastName())) {
                    System.out.println(entryList.get(i));
                    bool = false;
                } 
            }

            if (bool){
                System.out.println("Entry not found");
            }
        }

        if (selection == 3) {
            System.out.println("What is the full name of whom you're searching?");
            String fullName = scr.nextLine();
            for (int i = 0; i < entryList.size(); i++) {
                if (fullName.equals(entryList.get(i).getFirstName() + " " + entryList.get(i).getLastName())) {
                    System.out.println(entryList.get(i));
                    bool = false;
                } 
            }

            if (bool){
                System.out.println("Entry not found");
            }
        }

        if (selection == 4) {
            System.out.println("What is the telephone number of whom you're searching?");
            String number = scr.nextLine();
            for (int i = 0; i < entryList.size(); i++) {
                if (number.equals(entryList.get(i).getPhone())) {
                    System.out.println(entryList.get(i));
                    bool = false;
                } 
            }

            if (bool){
                System.out.println("Entry not found");
            }
        }

        if (selection == 5) {
            System.out.println("What is the city of whom you're searching?");
            String city = scr.nextLine();
            for (int i = 0; i < entryList.size(); i++) {
                if (city.equals(entryList.get(i).getAddress().getCity())) {
                    System.out.println(entryList.get(i));
                    bool = false;
                } 
            }

            if (bool){
                System.out.println("Entry not found");
            }
        }

        if (selection == 6) {
            System.out.println("What is the city of whom you're searching?");
            String city = scr.nextLine();
            for (int i = 0; i < entryList.size(); i++) {
                if (city.equals(entryList.get(i).getAddress().getState())) {
                    System.out.println(entryList.get(i));
                    bool = false;
                } 

            }

            if (bool){
                System.out.println("Entry not found");
            }
        }
    }

    public static void delete(Scanner scr) {

        System.out.println("Please enter the telephone number you wish to delete an entry for");
        String phone = scr.nextLine();
        boolean bool = true;

        for (int i = 0; i < entryList.size(); i++) {
            if (phone.equals(entryList.get(i).getPhone())) {
                entryList.remove(i);
                bool = false;
                break;
            } 
        }
        
        if (bool){
            System.out.println("Entry not found");
        }
    }

    public static void update(Scanner scr) {

        System.out.println("Please enter the telephone number you wish to update an entry for");
        String phone = scr.nextLine();

        System.out.println("1) Select if you would like to update the first name");
        System.out.println("2) Select if you would like to update the last name");
        System.out.println("3) Select if you would like to update the full name");
        System.out.println("4) Select if you would like to update the telephone number");
        System.out.println("5) Select if you would like to update the city");
        System.out.println("6) Select if you would like to update the state");
        System.out.println("7) Select if you would like to update the street name");
        System.out.println("8) Select if you would like to update the address number");
        System.out.println("9) Select if you would like to update the zipcode");
        int selection = scr.nextInt();
        scr.nextLine();
        boolean bool = true;

        for (int i = 0; i < entryList.size(); i++) {
            if (phone.equals(entryList.get(i).getPhone()) && selection == 1) {
                System.out.println("What would you like to update the first name to?");
                String firstName = scr.nextLine();
                entryList.get(i).setFirstName(firstName);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 2) {
                System.out.println("What would you like to update the last name to?");
                String lastName = scr.nextLine();
                entryList.get(i).setLastName(lastName);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 3) {
                System.out.println("What would you like to update the first name to?");
                String firstName = scr.nextLine();
                entryList.get(i).setFirstName(firstName);
                System.out.println("What would you like to update the last name to?");
                String lastName = scr.nextLine();
                entryList.get(i).setLastName(lastName);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 4) {
                System.out.println("What would you like to update the telephone to?");
                String telephone = scr.nextLine();
                entryList.get(i).setPhone(telephone);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 5) {
                System.out.println("What would you like to update the city to?");
                String city = scr.nextLine();
                entryList.get(i).getAddress().setCity(city);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 6) {
                System.out.println("What would you like to update the state to?");
                String state = scr.nextLine();
                entryList.get(i).getAddress().setState(state);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 7) {
                System.out.println("What would you like to update the street name to?");
                String street = scr.nextLine();
                entryList.get(i).getAddress().setStreetName(street);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 8) {
                System.out.println("What would you like to update the adreess number to?");
                int number = scr.nextInt();
                entryList.get(i).getAddress().setHouseapptNumb(number);
                bool = false;
            }
            if (phone.equals(entryList.get(i).getPhone()) && selection == 9) {
                System.out.println("What would you like to update the zipcode to?");
                int zipcode = scr.nextInt();
                entryList.get(i).getAddress().setZipCode(zipcode);
                bool = false;
            } else if (bool) {
                System.out.println("Entry not found");
            }
        }
    }

    public static void sort() {

        entryList.stream().sorted(Comparator.comparing(People::getFirstName).thenComparing(People::getLastName)
                .thenComparing(People::getPhone)).forEach(System.out::println);
    }
}
