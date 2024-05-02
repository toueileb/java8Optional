package optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> optionalString = Optional.of("Hello World");
        System.out.println(optionalString.isPresent());
        System.out.println(optionalString.get());

        Optional<Object> nullableOptional = Optional.ofNullable(null);
        System.out.println(nullableOptional);
        System.out.println(nullableOptional.isPresent());

        optionalString.ifPresent(System.out::println);

        String orElseDefaultValue = (String) emptyOptional.orElse("orElse Default Value");
        System.out.println(orElseDefaultValue);

        String orElseGetDefaultValue = (String) nullableOptional.orElseGet(() -> "orElseGet Default Value");
        System.out.println(orElseGetDefaultValue);

        // emptyOptional.orElseThrow(() -> new NoSuchElementException("No value is present"));

        System.out.println("UNKNOWN".equals(convertToUpperCaseOrUnknown(null))); // true
        System.out.println("HELLO".equals(convertToUpperCaseOrUnknown("hello"))); // true
        System.out.println("UNKNOWN".equals(convertToUpperCaseOrUnknown("hello"))); // false

        // Création d'un Optional<Person> avec une Address
        Optional<Address> addressOptional1 = Optional.of(new Address("New York"));
        Optional<Person> personOptional1 = Optional.of(new Person(addressOptional1));

        // Utilisation de map() pour obtenir le nom de la ville (avec un Optional)
        Optional<String> cityOptional1 = personOptional1.map(person -> person.getAddress().map(Address::getCity))
                .orElse(Optional.empty());

        // Utilisation de flatMap() pour obtenir directement le nom de la ville
        Optional<String> cityFlatMapOptional1 = personOptional1.flatMap(Person::getAddress)
                .map(Address::getCity);

        // Affichage des résultats
        cityOptional1.ifPresent(city -> System.out.println("Ville (avec map()): " + city)); // Output: Ville (avec
        // map()): Optional[New York]
        cityFlatMapOptional1.ifPresent(city -> System.out.println("Ville (avec flatMap()): " + city)); // Output:
        // Ville (avec flatMap()): New York// Création d'un Optional<Person> avec une Address
        Optional<Address> addressOptional = Optional.of(new Address("New York"));
        Optional<Person> personOptional = Optional.of(new Person(addressOptional));

        // Utilisation de map() pour obtenir le nom de la ville (avec un Optional)
        Optional<String> cityOptional = personOptional.map(person -> person.getAddress().map(Address::getCity))
                .orElse(Optional.empty());

        // Utilisation de flatMap() pour obtenir directement le nom de la ville
        Optional<String> cityFlatMapOptional = personOptional.flatMap(Person::getAddress)
                .map(Address::getCity);

        // Affichage des résultats
        cityOptional.ifPresent(city -> System.out.println("Ville (avec map()): " + city)); // Output: Ville (avec map
        // ()): Optional[New York]
        cityFlatMapOptional.ifPresent(city -> System.out.println("Ville (avec flatMap()): " + city)); // Output:
        // Ville (avec flatMap()): New York
        String data = "";
        String result = getDataOrThrow(data);
        System.out.println("Donnée récupérée : " + result); // Cette ligne ne sera pas exécutée si l'Optional est vide

        String data2 = "example";

        String message = checkData(data2);
        System.out.println(message); // Output: La donnée est valide : example


    }

    public static String checkData(String data) {
        return Optional.of(data).filter(s -> !s.isEmpty())
                .map(s -> "La donnée est valide : " + s)
                .orElse("La donnée est absente");
    }

    private static String convertToUpperCaseOrUnknown(String input) {
        return Optional.ofNullable(input)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
    }

    public static String getDataOrThrow(String data) {
        return Optional.of(data).orElseThrow(() -> new NoSuchElementException("Donnée non trouvée"));
    }


}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

class Person {
    private Optional<Address> address;

    public Person(Optional<Address> address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

