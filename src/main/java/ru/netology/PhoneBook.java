package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {
    private final Map<String, String> nameToNumber = new HashMap<>();
    private final Map<String, String> numberToName = new HashMap<>();
    private final TreeSet<String> names = new TreeSet<>();

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size();
        }

        nameToNumber.put(name, number);
        numberToName.put(number, name);
        names.add(name);

        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    public void printAllNames() {
        //заглушка печати
    }
}
