/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexedlinkedlist;

import java.util.Scanner;

/**
 *
 * @author Timothy
 */
public class IndexedLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> list = new List<>();

        for (int i = 0; i < 10; i++) {
            list.insertAtFront("a");
        }
        
        // insert integers in list
        list.insertAtFront("Tim");
        list.print('T');
        list.insertAtFront("Bob");
        list.print('b');
        list.insertAtBack("Jim");
        list.print('J');
        list.insertAtBack("Kat");
        list.print('k');

        // remove objects from list; print after each removal
        try {
            String removedItem = list.removeFromFront('t');
            System.out.println("removed " + removedItem);
            list.print('t');

            removedItem = list.removeFromFront('b');
           System.out.println("removed " + removedItem);
            list.print('b');

            removedItem = list.removeFromBack('j');
            System.out.println("removed " + removedItem);
            list.print('j');

            removedItem = list.removeFromBack('k');
            System.out.println("removed " + removedItem);
            list.print('k');
        } catch (EmptyListException emptyListException) {
            emptyListException.printStackTrace();
        } catch (NullPointerException n){
        
        }
    }

}
