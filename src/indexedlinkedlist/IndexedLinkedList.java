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
        IndexedList<String> list = new IndexedList<>();

        for (int i = 0; i < 10; i++) {
            list.insertAtFront("a");
        }
        
        // insert integers in list
        list.insertAtFront("Tim");
        list.insertAtFront("Tom");
        list.insertAtFront("T-loc");
        list.insertAtFront("Bob");
        list.insertAtBack("Jim");
        list.insertAtBack("Kat");
        list.print('k');

        // remove objects from list; print after each removal
        try {
         
            System.out.println(list.search("Tom"));
        } catch (EmptyListException emptyListException) {
            emptyListException.printStackTrace();
        } catch (NullPointerException n){
        
        }
    }

}
