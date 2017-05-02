/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexedlinkedlist;

/**
 *
 * @author ^_^
 */
public class List<T> {

    private ListNode<T>[] firstNode = new ListNode[27];
    private ListNode<T>[] lastNode = new ListNode[27];
    private String name; // string like "list" used in printing

    //Create an array of the alphabet for indexing names
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * constructor creates empty List with "list" as the name
     */
    public List() {
        this("list");
    }

    /**
     * constructor creates an empty List with a name
     *
     * @param listName
     */
    public List(String listName) {
        name = listName;
    }

    /**
     * insert item at front of List
     *
     * @param insertItem
     */
    public void insertAtFront(T insertItem) {
        int i = stringIndex(insertItem.toString().charAt(0));

        if (isEmpty(i)) // firstNode and lastNode refer to same object
        {
            firstNode[i] = lastNode[i] = new ListNode<T>(insertItem);
        } else // firstNode refers to new node
        {
            firstNode[i] = new ListNode<T>(insertItem, firstNode[i]);
        }
    }

    /**
     * insert item at end of List
     *
     * @param insertItem
     */
    public void insertAtBack(T insertItem) {
        int i = stringIndex(insertItem.toString().charAt(0));
        if (isEmpty(i)) // firstNode and lastNode refer to same object
        {
            firstNode[i] = lastNode[i] = new ListNode<T>(insertItem);
        } else // lastNode's nextNode refers to new node
        {
            lastNode[i] = lastNode[i].nextNode = new ListNode<T>(insertItem);
        }
    }

    /**
     *
     * @param index the index of the English alphabet you would like to remove
     * @return the item that was removed
     * @throws EmptyListException
     */
    public T removeFromFront(int index) throws EmptyListException {
        if (isEmpty(index)) // throw exception if List is empty
        {
            throw new EmptyListException(name);
        }

        T removedItem = firstNode[index].data; // retrieve data being removed

        // update references firstNode and lastNode 
        if (firstNode[index] == lastNode[index]) {
            firstNode[index] = lastNode[index] = null;
        } else {
            firstNode[index] = firstNode[index].nextNode;
        }

        return removedItem; // return removed node data
    } // end method removeFromFront

    /**
     *
     * @param index a letter of the English
     * @return the item that was removed
     * @throws EmptyListException
     */
    public T removeFromFront(char index) throws EmptyListException {
        return removeFromFront(stringIndex(index));
    }

    /**
     *
     * @param index the index of the English alphabet you would like to remove
     * @return the item that was removed
     * @throws EmptyListException
     */
    public T removeFromBack(int index) throws EmptyListException {
        if (isEmpty(index)) // throw exception if List is empty
        {
            throw new EmptyListException(name);
        }

        T removedItem = lastNode[index].data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else // locate new last node
        {
            ListNode<T> current = firstNode[index];

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode[index]) {
                current = current.nextNode;
            }

            lastNode[index] = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    /**
     *
     * @param index a letter of the English
     * @return the item that was removed
     * @throws EmptyListException
     */
    public T removeFromBack(char index) throws EmptyListException {
        return removeFromBack(stringIndex(index));
    }

    /**
     * determine whether list is empty
     *
     * @param i
     * @return true if list is empty
     */
    public boolean isEmpty(int i) {
        if (firstNode == null) {
            return firstNode == null; // return true if list is empty; // return true if list is empty
        }
        return firstNode[i] == null;
    }

    /**
     *
     * @param i index of a letter in the English alphabet
     */
    public void print(int i) {
        if (isEmpty(i)) {
            System.out.printf("Empty %s%n", name);
            System.out.println();
            return;
        }

        System.out.printf("The %s of " + Character.toString(stringIndex(i)) + " is: ", name);

        ListNode<T> current = firstNode[i];

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            System.out.println();
            current = current.nextNode;
        }
        System.out.println();
    }

    /**
     *
     * @param i a letter of the English alphabet
     */
    public void print(char i) {
        print(stringIndex(i));
    }

    /**
     *
     * @param c the first letter of the string
     * @return position of letter in array. if it does not exist than 26
     */
    private int stringIndex(char c) {
        c = Character.toLowerCase(c);
        return this.alphabet.indexOf(c) > 0 ? this.alphabet.indexOf(c) : 26;
    }

    /**
     *
     * @param c the first letter of the string
     * @return position of letter in array. if it does not exist than 26
     */
    private char stringIndex(int c) {
        return this.alphabet.charAt(c);
    }
} // end class List<T>
