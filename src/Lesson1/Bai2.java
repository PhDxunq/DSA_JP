package Lesson1;
import java.util.HashMap;
import java.util.Map;

public class Bai2 {
    public static void searchContact(HashMap<String, String> contacts, String phoneNumber) {
        if (contacts.containsKey(phoneNumber)) {
            System.out.println("Contact name: " + contacts.get(phoneNumber));
        } else {
            System.out.println("Contact not found");
        }
    }

    public static void searchContactByName(HashMap<String, String> contacts, String name) {
        for (Map.Entry<String,String> entry: contacts.entrySet()) {
            if (entry.getValue().equals(name)) {
                System.out.println("Contact phone number: " + entry.getKey());
                return;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("123-4567", "Alice");
        contacts.put("123-4567", "Bob");
        contacts.put("987-6543", "Charlie");
        searchContact(contacts, "0123456781");
        searchContactByName(contacts, "Bob");
    }

}
