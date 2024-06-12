/**
 * Let's get jiggy with arrays!
 * <p>
 * EXPLANATION:
 * <p>
 * 1) The coding exercise consist on two main things
 * - Of a given arrays, remove duplicates on both
 * - Print the arrays in three different ways:
 * 1. Original collection
 * 2. Collection with duplicates removed
 * 3. Collection with duplicates removed and sorted (ordenada)
 * <p>
 * 2) Output MUST be similar to example below
 * <p>
 * 3) You cannot erase anything that's already part of the exercise (main class, main method, helper method)
 * <p>
 * 4) No restrictions on the amount/names of private methods you can create within the class, as long as names are descriptive or JDoc is included
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * Test, executable method
     * THIS METHOD SHOULD PRINT ALL EXPECTED OUTPUT
     * @param   args
     */
    public static void main(String args[]) {
        Integer[] arrOne =
                {2, 5, 5, 55, 69, 666, 666, 2019, 42, 21, 9, 2, 69, 5};
        String[] arrTwo =
                {"John", "Tina", "Tom", "Jonah", "Laura", "Tina", "Bob", "Bob",
                        "Robert", "John", "Tina", "Tom", "Mike"};

        System.out.println("Original Collection: " + Arrays.toString(arrOne));
        removeDuplicates(arrOne);
        Arrays.parallelSort(arrOne);
        removeDuplicatesSorted(arrOne);

        System.out.println("----------------------------------------------");

        System.out.println("Original Collection: " + Arrays.toString(arrTwo));
        removeDuplicates(arrTwo);
        Arrays.parallelSort(arrTwo);
        removeDuplicatesSorted(arrTwo);
    }

    /**
     * Helper method to remove duplicates
     *  - MUST NOT MODIFY METHOD SIGNATURE!
     * @param   list    The list where duplicates will be removed
     * @return The list without duplicates
     */
    private static <T> List<T> removeDuplicates(T[] list) {

        ArrayList<T> arrAux = new ArrayList<>(Arrays.asList(list));

        for (int i = 0; i < arrAux.size(); i++) {
            List<Object> indexList = new ArrayList<>();
            Object number = arrAux.get(i);
		/*
		   System.out.println("Numero a trabajar: "+number);
		   2 == 2 true
		   2 == 2 true

		   [2, 2, 5,  9, 21, 42, 55, 69, 69, 666, 666, 2019]
		   [0, 1] = 2

		 */
            for (int j = 0; j < arrAux.size(); j++) {
                if (number == arrAux.get(j)) {
                    indexList.add(j);
                }
            }
            //System.out.println(indexList.toString());
            for (int k = 0; k < indexList.size(); k++) {

                Collections.sort(indexList, Collections.reverseOrder());    // Eliminar el indice mayor para mantener un ancla {Obtenido de internet}
                if (indexList.size() > 1) {
                    arrAux.remove((int) indexList.get(k));    // debe ser valor primitivo para que elimine por indice
                    indexList.remove(k);
                }
            }
            //System.out.println("Array Actualizado: "+arrAux.toString());
        }

        System.out.println("Duplicates removed from collection: " +
                arrAux.toString());
        return arrAux;

    }

    // YOU CAN ADD MORE PRIVATE METHODS HERE!

    private static <T> List<T> removeDuplicatesSorted(T[] list) {
        ArrayList<T> arrAux = new ArrayList<>(Arrays.asList(list));

        for (int i = 0; i < arrAux.size(); i++) {
            List<Integer> indexList = new ArrayList<>();
            Object number = arrAux.get(i);

            for (int j = 0; j < arrAux.size(); j++) {
                if (number == arrAux.get(j)) {
                    indexList.add(j);
                }
            }
            for (int k = 0; k < indexList.size(); k++) {

                Collections.sort(indexList, Collections.reverseOrder());
                if (indexList.size() > 1) {
                    arrAux.remove((int) indexList.get(k));
                    indexList.remove(k);
                }
            }
        }

        System.out.println("Duplicates removed from collection and sorted: " +
                arrAux.toString());
        return arrAux;

    }
}

/**
 * EXPECTED OUTPUT WHEN MAIN IS EXECUTED:
 * =======================================
 * 1) Original collection: [2, 5, 5, 55, 69, 666, 666, 2019, 42, 21, 9, 2, 69, 5]
 * 2) Duplicates removed from collection: [2, 5, 55, 69, 666, 2019, 42, 21, 9]
 * 3) Duplicates removed from collection and sorted: [2, 5, 9, 21, 42, 55, 69, 666, 2019]
 * - - - - - - - - - - - - - - - - - - - - (or any text separator)
 * 4) Original collection: [John, Tina, Tom, Jonah, Laura, Tina, Bob, Bob, Robert, John, Tina, Tom, Mike]
 * 5) Duplicates removed from collection: [John, Tina, Tom, Jonah, Laura, Bob, Robert, Mike]
 * 6) Duplicates removed from collection and sorted: [Bob, John, Jonah, Laura, Mike, Robert, Tina, Tom]
 */
