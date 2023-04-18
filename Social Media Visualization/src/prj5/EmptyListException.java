/**
 * 
 */
package prj5;

/**
 * Exception Class for empty DoublyLinkedList.
 * 
 * @author arian
 * 
 * @version 04-18-2023
 *
 */
public class EmptyListException extends Exception {
    public EmptyListException() {
        super("Empty LinkedList");
    }

}
