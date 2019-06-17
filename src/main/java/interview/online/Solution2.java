package interview.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {

    class Person {
        public String Name = "Unknown";
        public Map<String, String> Traits = new TreeMap<>();

        public Person() {
        }

        public Person(String rawInput) {
            String[] traits = rawInput.split(" ");
            for (String trait : traits) {
                String[] keyValuePair = trait.split("=");
                if (keyValuePair.length != 2) {
                    throw new IllegalArgumentException("invalid keyValuePair: " + trait);
                }

                String key = keyValuePair[0];
                String value = keyValuePair[1];

                if (key.equals("Name")) {
                    Name = value;
                }
                Traits.put(key, value);
            }
        }

        boolean hasAllTraits(Map<String, String> soughtTraits) {
            for (Map.Entry<String, String> soughtTrait : soughtTraits.entrySet()) {
                if (!HasTrait(Traits, soughtTrait)) {
                    return false;
                }
            }
            return true;
        }

    }

    static boolean HasTrait(Map<String, String> traits, Map.Entry<String, String> soughtTrait) {
        String personSoughtValue = traits.get(soughtTrait.getKey());
        return soughtTrait.getValue().equals(personSoughtValue);
    }

    class Registry {
        List<Person> mPersons = new ArrayList<>();

        public void add(Person person) {
            mPersons.add(person);
        }

        public Person findMatchingPersonByRawTraits(String rawTraits) {
            Person soughtPerson = new Solution2().new Person(rawTraits);
            for (Person person : mPersons) {
                if (person.hasAllTraits(soughtPerson.Traits)) {
                    return person;
                }
            }
            return new Person();
        }
    }

    // Entry point
    static String GetNameFromRegistryByTraits(String[] rawRegistry, String soughtTraits) {
        try {
            Solution2 solution2 = new Solution2();
            Registry registry = solution2.new Registry();
            for (String rawInput : rawRegistry) {
                Person person = solution2.new Person(rawInput);
                registry.add(person);
            }

            Person person = registry.findMatchingPersonByRawTraits(soughtTraits);
            return person.Name;
        } catch (IllegalArgumentException e) {
            return "Error";
        }
    }
}
