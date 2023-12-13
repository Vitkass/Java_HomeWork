import java.lang.reflect.Field;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 30);
        PersonDTO personDTO = new PersonDTO();

        BeanUtils.assign(personDTO, person);

        System.out.println(personDTO.getFirstName()); // "John"
        System.out.println(personDTO.getLastName()); // "Doe"
        System.out.println(personDTO.getAge()); // 30

    }
}