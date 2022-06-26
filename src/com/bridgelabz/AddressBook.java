package com.bridgelabz;

import java.util.*;
import java.util.stream.IntStream;

public class AddressBook {
    static final int ADD_CONTACTS = 1;
    static final int PRINT_CONTACTS = 2;
    static final int EDIT_CONTACT = 3;
    static final int DELETE_CONTACT = 4;
    static final int EXIT = 5;

    Scanner sc1 = new Scanner(System.in);
    int operationChoice;

    private final HashMap<String, ArrayList<Contact>> multipleAddressBook = new HashMap<String, ArrayList<Contact>>();

    private static final List<Contact> contacts = new ArrayList<>();

    public void createContact(ArrayList<Contact> contact) {
        contacts.addAll(contact);
    }

    public void takingChoice() {
        choicePrinting();
        System.out.println("Enter your Choice : ");
        Scanner choice = new Scanner(System.in);
        operationChoice = choice.nextInt();
    }

    private void choicePrinting() {
        System.out.println("1. Adding a new contact.");
        System.out.println("2. Displaying contact.");
        System.out.println("3. Editing a contact.");
        System.out.println("4. Deleting a contact.");
    }

    public void addContacts(AddressBook addressBook) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people you want to add to Address book");
        int numberOfPeople = scanner.nextInt();

        for (int i = 0; i < numberOfPeople; i++) {

            System.out.println("Enter the first name: ");
            String first_name = scanner.next();
            if (!contacts.isEmpty()) {
                var isContact = contacts.stream().anyMatch(contact ->
                        contact.getFirstName().equals(first_name));
                if (isContact) {
                    System.out.println("Contacts with same name is not acceptable. Please enter new name ");
                    return;
                }
            }

            System.out.println("Enter the last name: ");
            String last_name = scanner.next();

            System.out.println("Enter the address: ");
            String address = scanner.next();

            System.out.println("Enter the city name: ");
            String city = scanner.next();

            System.out.println("Enter the state's name: ");
            String state = scanner.next();

            System.out.println("Enter the zip: ");
            String zip = scanner.next();

            System.out.println("Enter the phone number: ");
            String phone_num = scanner.next();

            System.out.println("Enter the email ID: ");
            String email = scanner.next();

            Contact contact = new Contact(first_name, last_name, address, city, state, zip, phone_num, email);
            contacts.add(contact);
        }

        boolean isContinue = true;
        do {
            System.out.println();
            System.out.println("1. Address Book to add contacts");
            System.out.println("2. Display Address Books");
            System.out.println("3. Add Address Book");
            System.out.println("4. Back to main menu");
            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter address book name to add contacts to : ");
                    String addressBookName = sc1.next();
                    boolean addressBookExists = isAddressBookExists(addressBookName);
                    if (addressBookExists) {
                        saveContactsToAddressBook(addressBookName, contacts);
                    }
                    createAddressBook(addressBookName, contacts);
                    break;
                case 2:
                    displayAddressBooks();
                    break;
                case 3:
                    System.out.println("Enter the name of ADDRESS BOOK to add in dictionary : ");
                    String bookName = sc1.next();
                    createEmptyAddressBook(bookName);
                    break;
                case 4:
                    isContinue = false;
                    break;
            }
        } while (isContinue);
    }

    public void displayContacts() {
        System.out.println("Please enter address book name to display contacts of : ");
        String addressBook = sc1.next();
        if (!multipleAddressBook.containsKey(addressBook)) {
            System.out.println("Address book not present !!");
            return;
        }

        ArrayList<Contact> contactArrayList = multipleAddressBook.get(addressBook);
        int size = contactArrayList.size();
        if (size == 0) {
            System.out.println("Please add contact !!");
            return;
        }
        contactArrayList.forEach(contact -> {
            System.out.println("first name=" + contact.getFirstName());
            System.out.println("Last name=" + contact.getLastName());
            System.out.println("address=" + contact.getAddress());
            System.out.println("City name=" + contact.getCity());
            System.out.println("State name=" + contact.getState());
            System.out.println("zip code=" + contact.getZip());
            System.out.println("Phone number=" + contact.getPhoneNumber());
            System.out.println("Email=" + contact.getEmail());
        });
    }

    public void editContact() {
        System.out.println("Please enter address book name to edit contacts of : ");
        String addressBook = sc1.next();
        if (!multipleAddressBook.containsKey(addressBook)) {
            System.out.println("Address book not present !!");
            return;
        }

        ArrayList<Contact> contactArrayList = multipleAddressBook.get(addressBook);
        int size = contactArrayList.size();
        if (size == 0) {
            System.out.println("Please add contact !!");
            return;
        }

        System.out.println("Enter contact name to edit");
        String firstName = sc1.next();

        IntStream.range(0, contactArrayList.size()).forEach(i -> {
            if (contactArrayList.get(i).getFirstName().equals(firstName)) {

                System.out.println("Enter the name to edit First name");
                String newFirstName = sc1.next();
                contactArrayList.get(i).setFirstName(newFirstName);

                System.out.println("Enter the name to edit Last name");
                String newLastName = sc1.next();
                contactArrayList.get(i).setLastName(newLastName);

                System.out.println("Enter the name to edit Address");
                String newAddress = sc1.next();
                contactArrayList.get(i).setAddress(newAddress);

                System.out.println("Enter the name to edit City name");
                String newCity = sc1.next();
                contactArrayList.get(i).setCity(newCity);

                System.out.println("Enter the name to edit State name");
                String newState = sc1.next();
                contactArrayList.get(i).setState(newState);

                System.out.println("Enter the name to edit Zip code");
                String newZip = sc1.next();
                contactArrayList.get(i).setZip(newZip);

                System.out.println("Enter the name to edit Phone Number");
                String newPhoneNumber = sc1.next();
                contactArrayList.get(i).setPhoneNumber(newPhoneNumber);

                System.out.println("Enter the name to edit Email");
                String newEmail = sc1.next();
                contactArrayList.get(i).setEmail(newEmail);
            } else {
                System.out.println("Contact to edit not found");
            }
        });

    }

    public void deleteContact() {
        System.out.println("Please enter address book name to edit contacts of : ");
        String addressBook = sc1.next();
        if (!multipleAddressBook.containsKey(addressBook)) {
            System.out.println("Address book not present !!");
            return;
        }

        ArrayList<Contact> contactArrayList = multipleAddressBook.get(addressBook);
        int size = contactArrayList.size();
        if (size == 0) {
            System.out.println("Please add contact !!");
            return;
        }
        System.out.println("Enter contact name to delete");
        String firstName = sc1.next();

        for (int i = 0; i < contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getFirstName().equals(firstName)) {
                contactArrayList.remove(i);
            }
        }
    }


    private void createEmptyAddressBook(String bookName) {
        multipleAddressBook.put(bookName, new ArrayList<Contact>());
    }

    private void displayAddressBooks() {
        System.out.println("List of address books available :");
        Set<String> addressBooksKey = multipleAddressBook.keySet();
        if (addressBooksKey.isEmpty()) {
            System.out.println("No address book present Please create one !!");
        }
        addressBooksKey.forEach(address -> System.out.println("* " + address));
    }

    private void createAddressBook(String addressBookName, ArrayList<Contact> contacts) {
        saveContactsToAddressBook(addressBookName, contacts);
        System.out.println("Added Address book with name : " + addressBookName);
    }

    private void saveContactsToAddressBook(String addressBookName, ArrayList<Contact> contacts) {
        multipleAddressBook.put(addressBookName, contacts);
    }

    private boolean isAddressBookExists(String bookName) {
        return multipleAddressBook.containsKey(bookName);
    }
}
