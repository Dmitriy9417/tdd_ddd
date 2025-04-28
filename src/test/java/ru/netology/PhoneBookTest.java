package ru.netology;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PhoneBookTest {
    @Test
    public void testAddNewContact() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(2, phoneBook.add("Bob", "67890"));
    }

    @Test
    public void testAddDuplicateName() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(1, phoneBook.add("Alice", "54321")); // не должен добавить
    }
    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        assertEquals("Alice", phoneBook.findByNumber("12345"));
        assertEquals("Bob", phoneBook.findByNumber("67890"));
        assertNull(phoneBook.findByNumber("99999")); // несуществующий номер
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        assertEquals("12345", phoneBook.findByName("Alice"));
        assertEquals("67890", phoneBook.findByName("Bob"));
        assertNull(phoneBook.findByName("Charlie")); // несуществующее имя
    }

    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob", "67890");
        phoneBook.add("Alice", "12345");
        phoneBook.add("Charlie", "54321");

        // Проверяем порядок вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        phoneBook.printAllNames();
        String output = outContent.toString().trim();
        assertEquals("Alice\nBob\nCharlie", output);
    }
}
