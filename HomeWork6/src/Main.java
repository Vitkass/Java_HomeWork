import java.lang.reflect.Field;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        String name = null;
        int number = myClass.getNumber();
        System.out.println(number+name);

        try {
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(number + name);

        MyClass clas = null;
        try{
            Class clazz = Class.forName(MyClass.class.getName());
            clas = (MyClass) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(clas);



    }
}