import java.util.ArrayList;

public class ExempleArraylist {
    public static void main(String[] args) {
        /* DEFINITION
        *   ##The ArrayList class is a resizable array##, which can be found in the java.util package.
            The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified.
*           While elements can be added and removed from an ArrayList whenever you want*/

        /*CREATION
         *   To create a ArraList we can do it like
         * ArrayList <type> name = new ArrayList <type>();*/
        ArrayList<String> palabras = new ArrayList<String>();

        //ADDING ITEMS .add()
        palabras.add("Ejemplo");
        palabras.add("para");
        palabras.add("APrender");
        //Always add items of the same class/type
        //palabras.add(4);

        //ACCESING CONTENT .get(index)
        System.out.println(palabras.get(2));

        //CHANGE AN ITEM .set(index,newValue)
        palabras.set(2, "Jugar");

        //REMOVB AN ITEM .remove(index);
        //to remove all elements we use .clear();

        //We get the size or length with .size();
        System.out.println(palabras.size());

        // Loop Through an ArrayList
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
        // or we can do it with a foreach loop
        for (String x : palabras) {
            System.out.println(x);
        }

        //NOTES

        //The poweer here is that our array have a kind of unlimited size like a gum , the next line wouldn´t work
        //System.out.println(palabras.get(4));

        /*To use other types, such as int, you must specify an equivalent wrapper class: "Integer"
        For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:
        Example
        * ArrayList <Integer> name = new ArrayList <Integer>();*/

        // We can also sort with another package
        //import java.util.Collections;

        /*    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(33);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(34);
    myNumbers.add(8);
    myNumbers.add(12);

    Collections.sort(myNumbers);  // Sort myNumbers

    for (int i : myNumbers) {
      System.out.println(i);
    }*/

    }
}

