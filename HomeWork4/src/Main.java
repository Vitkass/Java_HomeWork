import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str1 = new String("First");
        String str2 = new String("Second");
        String str3 = new String("Third");
        String str4 = new String("Fourth");

        String strInsert1 = new String("First Insert");;
        String strInsert2 = new String("Second Insert");;
        String strInsert3 = new String("Third Insert");;

        LinkedList<String> myLinkedList = new LinkedList<>();
        // add(E e)
        myLinkedList.add(str1);
        myLinkedList.add(str2);
        myLinkedList.add(str3);
        myLinkedList.add(str4);

        System.out.println(myLinkedList);
        // add(int index, E element)
        myLinkedList.add(1, strInsert1);
        myLinkedList.add(2, strInsert2);
        myLinkedList.add(3, strInsert3);

        System.out.println(myLinkedList);

        // E get(int index)
        String first_get = myLinkedList.get(1);
        System.out.println(first_get);

        // E remove(int index)
        myLinkedList.remove(1);
        System.out.println(first_get);

        // Iterator<E> iterator()
        ListIterator<String> linkIterator = myLinkedList.listIterator();
        while (linkIterator.hasNext()){
            System.out.println(linkIterator.next());
        }

        // boolean addAll(Collection c)

        Collection<String> collect = new ArrayList<String>();
        collect.add("A");
        collect.add("Computer");
        collect.add("Portal");
        collect.add("for");
        collect.add("Geeks");
        myLinkedList.addAll(collect);


        // boolean copy(Collection c)


    }
}