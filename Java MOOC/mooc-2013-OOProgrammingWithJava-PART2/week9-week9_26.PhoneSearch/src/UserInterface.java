
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class UserInterface {
    private Scanner reader;
    private Phonebook phoneBook;
    
    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.phoneBook = new Phonebook();
    }
    
    public void start() {
        listOptions();
        while(true) {
            System.out.print("\n" + "Command: ");
            String command = reader.nextLine();
            if(command.equals("x")) {
                break;
            }
            if(command.equals("1")) {
                addPhoneNumber();
            }
            if(command.equals("2")) {
                searchForPhoneNumber();
            }
            if(command.equals("3")) {
                searchPersonByNumber();
            }
            if(command.equals("4")) {
                addAddress();
            }
            if(command.equals("5")) {
                searchPersonalInfo();
            }
            if(command.equals("6")) {
                deleteInformation();
            }
            if(command.equals("7")) {
                filteredSearch();
            }
        }
    }
    
    public void listOptions() {
        System.out.println("Phone search");
        System.out.println("Available operations:");
        System.out.println(" 1 Add a number");
        System.out.println(" 2 Search for a number");
        System.out.println(" 3 Search for a person by phone number");
        System.out.println(" 4 Add an address");
        System.out.println(" 5 Search for personal information");
        System.out.println(" 6 Delete personal information");
        System.out.println(" 7 Filtered listing");
        System.out.println(" x Quit");
    }
    
    public void addPhoneNumber() {
        System.out.print("Whose number: ");
        String name = reader.nextLine();
        System.out.print("Number: ");
        String number = reader.nextLine();
        phoneBook.addPerson(name);
        phoneBook.addPhoneNumber(name, number);
    }
    
    public void searchForPhoneNumber() {
        System.out.print("Whose number: ");
        String name = reader.nextLine();
        if(phoneBook.getPerson(name) == false) {
            System.out.println(" Not found");
        } else {
            if(phoneBook.getNumberFromName(name, 1).isEmpty()) {
                System.out.println(" Not found");
            } else {
                System.out.println(phoneBook.getNumberFromName(name, 1));
            }
        }
    }
    
    public void searchPersonByNumber() {
        System.out.print("Number: ");
        String number = reader.nextLine();
        if(phoneBook.getNameFromNumber(number) == null) {
            System.out.println(" Not found");
        } else {
            System.out.println(" " + phoneBook.getNameFromNumber(number));
        }
    }
    
    public void addAddress() {
        System.out.print("Whose address: ");
        String name = reader.nextLine();
        System.out.print("Street: ");
        String street = reader.nextLine();
        System.out.print("City: ");
        String city = reader.nextLine();
        phoneBook.addAddress(name, street, city);        
    }
    
    public void searchPersonalInfo() {
        System.out.print("Whose information: ");
        String name = reader.nextLine();
        if(!phoneBook.getPerson(name)) {
            System.out.println(" Not found");
        } else {
            if(phoneBook.getAddress(name) == null) {
                System.out.println(" Address unknown");
            } else {
                System.out.println(" Address: " + phoneBook.getAddress(name));
            }
            if(phoneBook.getNumberFromName(name, 2) == null) {
                System.out.println(" Phone number not found");
            } else {
                System.out.println(" Phone numbers:");
                System.out.println(phoneBook.getNumberFromName(name, 2));
            }
        }
    }
    
    public void deleteInformation() {
        System.out.print("Whose information: ");
        String name = reader.nextLine();
        if(phoneBook.getPerson(name)) {
            phoneBook.removePerson(name);
        }
    }
    
    public void filteredSearch() {
        System.out.print("Keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<Person> searchList = phoneBook.filteredListing(keyword);
        if(searchList.isEmpty()) {
            System.out.println(" Keyword not found");
        }
        for(Person p : searchList) {
            System.out.println("");
            System.out.println(" " + p.getName());
            System.out.print("  ");
            if(phoneBook.getAddress(p.getName()) == null) {
                System.out.println("address unknown");
            } else {
                System.out.println(phoneBook.getAddress(p.getName()));
            }
            System.out.print("  ");
            if(p.getPhoneNumbers().isEmpty()) {
                System.out.println("Phone number not found");
            } else {
                System.out.println("Phone numbers:\n" + phoneBook.getNumberFromName(p.getName(), 3));
            }
        }
    }
}
