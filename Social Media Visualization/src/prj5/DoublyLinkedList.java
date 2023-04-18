package prj5;

/**
 * A class representing a doubly linked list data structure.
 *
 *@author Arian Assadzadeh, Kevin, Jon
 *
 *@version 04-18-2023
 *
 * @param <T>
 *            the type of data stored in the linked list
 */
public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    /**
     * Constructs an empty DoublyLinkedList object.
     */
    public DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.numberOfEntries = 0;
    }


    /**
     * Returns the first node in the linked list.
     *
     * @return the first node in the linked list
     */
    public Node<T> getFirstNode() {
        return firstNode;
    }


    /**
     * Returns the last node in the linked list.
     *
     * @return the last node in the linked list
     */
    public Node<T> getLastNode() {
        return lastNode;
    }


    /**
     * Adds a new node with the given data to the end of the linked list.
     *
     * @param data
     *            the data to be added to the linked list
     */
    public void add(T data) {
        add(numberOfEntries, data);
    }


    /**
     * Adds a new node with the given data at the specified index in the linked
     * list.
     *
     * @param index
     *            the index where the new node should be added
     * @param data
     *            the data to be added to the linked list
     * @throws IndexOutOfBoundsException
     *             if the given index is out of range
     */
    public void add(int index, T data) {
        if (index < 0 || index > numberOfEntries) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

    }


    /**
     * Removes all nodes from the linked list.
     */
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }


    /**
     * Removes the first occurrence of the given data from the linked list, if
     * it exists.
     *
     * @param data
     *            the data to be removed from the linked list
     * @return true if the data was removed, false otherwise
     */
    public boolean remove(T data) {

    }


    /**
     * Returns the data stored in the node at the specified index in the linked
     * list.
     *
     * @param index
     *            the index of the node whose data should be retrieved
     * @return the data stored in the node at the specified index
     * @throws IndexOutOfBoundsException
     *             if the given index is out of range
     */
    public T getEntry(int index) {
        if (index < 0 || index >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

    }


    /**
     * Returns true if the linked list is empty, false otherwise.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Returns the number of nodes in the linked list.
     *
     * @return the number of nodes in the linked list
     */
    public int getLength() {
        return numberOfEntries;
    }


    /**
     * Returns an array of the data stored in the nodes of the linked list.
     *
     * @return an array of the data stored in the nodes of the linked list
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        Node<T> currentNode = firstNode;
        int index = 0;

        while (currentNode != null) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }

        return result;
    }


    /**
     * Replaces the data in the node at the specified index with the given data.
     *
     * @param index
     *            the index of the node whose data should be replaced
     * @param data
     *            the data to replace the existing data
     * @throws IndexOutOfBoundsException
     *             if the given index is out of range
     */
    public void replace(int index, T data) {
        if (index < 0 || index >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

    }


    /**
     * Returns true if the linked list contains the given data, false otherwise.
     *
     * @param data
     *            the data to search for in the linked list
     * @return true if the linked list contains the given data, false otherwise
     */
    public boolean contains(T data) {
        Node<T> currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    /**
     * A class representing a node in a doubly linked list data structure.
     *
     * @param <T>
     *            the type of data stored in the node
     */
    public class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        /**
         * Constructs a new Node object with the given data.
         *
         * @param data
         *            the data to be stored in the node
         */
        public Node(T data) {
            this(data, null, null);
        }


        /**
         * Constructs a new Node object with the given data, next node, and
         * previous node.
         *
         * @param data
         *            the data to be stored in the node
         * @param next
         *            the next node in the linked list
         * @param prev
         *            the previous node in the linked list
         */
        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }


        /**
         * Sets the next node in the linked list.
         *
         * @param next
         *            the next node in the linked list
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }


        /**
         * Sets the previous node in the linked list.
         *
         * @param prev
         *            the previous node in the linked list
         */
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }


        /**
         * Returns the next node in the linked list.
         *
         * @return the next node in the linked list
         */
        public Node<T> getNext() {
            return next;
        }


        /**
         * Returns the previous node in the linked list.
         *
         * @return the previous node in the linked list
         */
        public Node<T> getPrev() {
            return prev;
        }


        /**
         * Returns the data stored in the node.
         *
         * @return the data stored in the node
         */
        public T getData() {
            return data;
        }
    }

}
