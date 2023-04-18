package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A basic double linked list class with sentinel nodes
 * 
 * @author Jon Church (Jrchurch02)
 * @version 2023.04.17
 * @param <T>
 *            The type of data to be stored
 */
public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    /**
     * Generic constructor for the class.
     * Creates sentinel nodes at the front and back
     * Sets the numberOfEntries to 0
     */
    public DoublyLinkedList() {
        firstNode = new Node<T>(null, null, null);
        lastNode = new Node<T>(null, firstNode, null);
        firstNode.setNext(lastNode);
        numberOfEntries = 0;
    }


    /**
     * gets the first node if there is one, otherwise returns
     * null
     * 
     * @return the first node
     */
    public Node<T> getFirstNode() {
        Node<T> out = firstNode.getNext();
        if (out.getData() == null) {
            return null;
        }
        return out;
    }


    /**
     * gets the last node if there is one, otherwise returns
     * null
     * 
     * @return the last node
     */
    public Node<T> getLastNode() {
        Node<T> out = lastNode.getPrev();
        if (out.getData() == null) {
            return null;
        }
        return out;
    }


    /**
     * adds an entry in the first place in the list
     * 
     * @param entry
     *            the entry to add to the list
     */
    public void add(T entry) {
        this.add(0, entry);
    }


    /**
     * adds an entry to a given place in the list
     * 
     * @param pos
     *            the 0 based index to put the entry at
     * @param entry
     *            the entry to add to the list
     */
    public void add(int pos, T entry) {
        if (pos >= numberOfEntries || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = firstNode;
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
        Node<T> entryNode = new Node<T>(entry, curr, curr.getNext());
        curr.getNext().setPrev(entryNode);
        curr.setNext(entryNode);
        numberOfEntries++;
    }


    /**
     * clears the list by
     * removing every node from the list and sets
     * numberOfEntries to 0
     */
    public void clear() {
        firstNode.setNext(lastNode);
        lastNode.setPrev(firstNode);
        numberOfEntries = 0;
    }


    /**
     * 
     * @param pos
     *            the 0 besed index of the position to remove
     * @return the data of the removed node
     */
    public T remove(int pos) {
        if (pos >= numberOfEntries || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = firstNode.getNext();
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
        curr.getNext().setPrev(curr.getPrev());
        curr.getPrev().setNext(curr.getNext());
        numberOfEntries--;
        return curr.getData();
    }


    /**
     * finds the first entry with the given data and removes.
     * 
     * @param entry
     *            the entry to remove
     * @return true if an entry is removed, false otherwise
     */
    public boolean remove(T entry) {
        Node<T> curr = firstNode.getNext();
        while (curr.getData() != null) {
            if (curr.getData() == entry) {
                curr.getNext().setPrev(curr.getPrev());
                curr.getPrev().setNext(curr.getNext());
                return true;
            }
            numberOfEntries--;
            curr = curr.getNext();
        }
        return false;
    }


    /**
     * returns the data of the entry at the given position
     * 
     * @param pos
     *            the position of the entry to get
     * @return the data from the entry
     */
    public T getEntry(int pos) {
        if (pos >= numberOfEntries || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = firstNode.getNext();
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }


    /**
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * @return the number of entries in the list
     */
    public int getLength() {
        return numberOfEntries;
    }


    /**
     * generates an array of the data from the list
     * 
     * @return an array representation of the list
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        T[] out = (T[])new Object[numberOfEntries];
        IteratorDLL<T> iter = iterator();
        int i = 0;
        while (iter.hasNext()) {
            out[i++] = iter.next();
        }
        return out;
    }


    /**
     * replaces the data in a node of a given position
     * with given data
     * 
     * @param pos
     *            the 0 based position to replace
     * @param entry
     *            the entry to replace with
     */
    public void replace(int pos, T entry) {
        if (pos > numberOfEntries || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        // TODO implement this
    }


    /**
     * checks if specific data is contained within the list
     * 
     * @param check
     *            the data to check for
     * @return true if the list has that data, false otherwise
     */
    public boolean contains(T check) {
        Node<T> curr = firstNode.getNext();
        while (curr.getData() != null) {
            if (curr.getData() == check) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }


    /**
     * creates and returns an iterator for the list
     * 
     * @return an iterator object at the start of the list
     */
    public IteratorDLL<T> iterator() {
        return new IteratorDLL<T>();
    }


    /**
     * sorts the list based on a specified comparator
     * 
     * @param comp
     *            the comparator to sort by
     */
    public void sort(Comparator<T> comp) {
        Node<T> current = firstNode.getNext();
        if (current != null && current.getNext() != null) {
            Node<T> unsorted = current.getNext();
            Node<T> sorted = current;
            sorted.setNext(null); // To be sorted
            sorted.setPrev(new Node<T>(null)); // Put a the sentinel node there
            firstNode = sorted.getPrev();
            unsorted.setPrev(null); // Unlink it from the sorted portion
                                    // entirely

            while (unsorted != null) {
                Node<T> tempToInsert = unsorted;
                unsorted = unsorted.getNext();
                insertIntoSorted(tempToInsert, comp);
            }
        }

    }


    /**
     * Helper method to insert a node into its proper location in a sorted
     * linked chain.
     * 
     * @param nodeToInsert:
     *            node to add to sorted section of list
     */
    public void insertIntoSorted(Node<T> nodeToInsert, Comparator<T> comp) {
        T item = nodeToInsert.getData();
        Node<T> currentNode = firstNode.getNext();
        Node<T> previousNode = null;

        while (currentNode != null && comp.compare(item, currentNode
            .getData()) > 0) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        } // Go up to the place where the new node should be inserted
        if (previousNode != null) { // Insert it here
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrev(previousNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrev(nodeToInsert);
            }
        }
        else { // Never entered the while loop
            nodeToInsert.setNext(firstNode.getNext());
            firstNode.getNext().setPrev(nodeToInsert);
            firstNode.setNext(nodeToInsert);
        }

    }// end insertIntoSorted

    /**
     * iterator class for the
     * 
     * @author Jon Church (Jrchurch02)
     *
     * @param <T>
     *            The type of data to be stored
     */
    @SuppressWarnings("hiding")
    private class IteratorDLL<T> implements Iterator<T> {

        private Node<T> next;
        private boolean calledNext;

        @SuppressWarnings("unchecked")
        public IteratorDLL() {
            next = (Node<T>)firstNode;
            calledNext = false;
        }


        /**
         * checks if the iterator hasa next node
         * 
         * @return true if there is another node, false otherwise
         */
        public boolean hasNext() {
            return next.getNext().getData() != null;
        }


        /**
         * removes the next node and sets the next node to be the
         * one after the removed node
         */
        public void remove() {
            if (calledNext) {
                Node<T> tempNext = next.getNext();
                next.getNext().setPrev(next.getPrev());
                next.getPrev().setNext(next.getNext());
                next = tempNext;
            }
            calledNext = false;
        }


        /**
         * moves the iterator forward one node
         * 
         * @return the data of the node
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            next = next.getNext();
            if (hasNext()) {
                calledNext = true;
            }
            else {
                calledNext = false;
            }
            return next.getData();
        }

    }


    /**
     * A node class to hold the data and link the chain for
     * the DoubleLinkedList class
     * 
     * @author Jon Church (Jrchurch02)
     * @version 2023.04.17
     * @param <T>
     *            The type of data to be stored
     */
    private class Node<T> {

        private Node<T> next;
        private Node<T> prev;
        private T data;

        Node(T data) {
            this(data, null, null);
        }


        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }


        public Node<T> getNext() {
            return next;
        }


        public Node<T> getPrev() {
            return prev;
        }


        public void setNext(Node<T> next) {
            this.next = next;
        }


        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

// public void setData(T data) {
// this.data = data;
// }


        public T getData() {
            return data;
        }

    }

}
