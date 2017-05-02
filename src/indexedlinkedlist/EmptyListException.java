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
public class EmptyListException extends RuntimeException 
{
   // constructor
   public EmptyListException()
   {
      this("List"); // call other EmptyListException constructor
   } 

   // constructor
   public EmptyListException(String name)
   {
      super(name + " is empty"); // call superclass constructor
   } 
} // end class EmptyListException
