/**
 * 
 */
package prj5;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author arian
 *
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> t1;
    private DoublyLinkedList<Integer> t4;
    private DoublyLinkedList<String> t5;

    /**
     * Set up method that creates pre-test condition.
     * 
     * @throws lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        t1 = new DoublyLinkedList<>();

        t1.add(1);
        t1.add(2);
        t1.add(3);

        t4 = new DoublyLinkedList<>();

        t5 = new DoublyLinkedList<>();

    }


    /**
     * Test method for getFirstNode.
     */
    @Test
    public void testGetFirstNode() {
        assertEquals(1, (int)t1.getFirstNode().getData());
        t1.add(0, null);
        assertNull(t1.getFirstNode());
    }


    /**
     * Test method for getLastnode.
     */
    @Test
    public void testGetLastNode() {
        assertEquals(3, (int)t1.getLastNode().getData());
        t1.add(null);
        assertNull(t1.getLastNode());
    }


    /**
     * Test method for add.
     */
    @Test
    public void testAddT() {
        assertEquals(3, (int)t1.getLastNode().getData());
        t1.add(5);
        assertEquals(5, (int)t1.getLastNode().getData());

    }


    /**
     * Test method for add.
     */
    @Test
    public void testAddIntT() {

        Exception thrown = null;
        try {
            t1.add(10, 10);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        thrown = null;
        try {
            t1.add(-10, 10);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        assertEquals(3, (int)t1.getLastNode().getData());
        t1.add(1, 6);
        assertEquals(6, (int)t1.getFirstNode().getNext().getData());
    }


    /**
     * Test method for clear.
     */
    @Test
    public void testClear() {
        assertFalse(t1.isEmpty());
        t1.clear();
        assertTrue(t1.isEmpty());
    }


    /**
     * Test method for remove method that removes a specific index.
     */
    @Test
    public void testRemoveInt() {
        Exception thrown = null;
        try {
            t4.remove(0);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            t4.remove(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals(1, (int)t1.getFirstNode().getData());
        t1.remove(0);
        assertEquals(2, (int)t1.getFirstNode().getData());
        t1.add(10);
        t1.add(20);
        t1.add(30);
        t1.add(40);
        t1.add(50);
        t1.add(60);
        assertEquals(40, (int)t1.remove(5));

    }


    /**
     * Test method for remove that removes a specific data entry.
     */
    @Test
    public void testRemoveT() {
        assertFalse(t5.remove("nothing"));

        t5.add("1");
        t5.add("2");
        t5.add("3");
        t5.add("4");

        assertEquals("1", t5.getFirstNode().getData());
        t5.remove("1");
        assertEquals("2", t5.getFirstNode().getData());
        t5.remove("3");
        assertEquals("2", t5.getLastNode().getPrev().getData());
    }


    /**
     * Test method for getEntry.
     */
    @Test
    public void testGetEntry() {
        assertEquals(3, (int)t1.getEntry(2));

        Exception thrown = null;
        try {
            t4.getEntry(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            t4.getEntry(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * Test method for isEmpty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(t4.isEmpty());
        assertFalse(t1.isEmpty());
    }


    /**
     * Test method for getLength.
     */
    @Test
    public void testGetLength() {
        assertEquals(3, t1.getLength());
        t1.add(5);
        assertEquals(4, t1.getLength());
    }


    /**
     * Test method for toArray.
     */
    @Test
    public void testToArray() {
        assertNull(t4.toArray());
        Integer[] temp = { 1, 2, 3 };
        assertArrayEquals(temp, t1.toArray());
    }


    /**
     * Test method for replace.
     */
    @Test
    public void testReplace() {
        assertEquals(2, (int)t1.getFirstNode().getNext().getData());
        t1.replace(1, 5);

        assertEquals(5, (int)t1.getFirstNode().getNext().getData());

        assertEquals(3, (int)t1.getEntry(2));

        Exception thrown = null;
        try {
            t4.replace(3, 10);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            t4.replace(-1, 10);
        }
        catch (Exception exception) {
            thrown = exception;
        }
    }


    /**
     * Test method for contains.
     */
    @Test
    public void testContains() {
        assertTrue(t1.contains(3));
        assertFalse(t1.contains(6));
    }


    /**
     * Test method for sort
     */
    @Test
    public void testSort() {
        t1 = new DoublyLinkedList<Integer>();
        t1.add(1);
        t1.add(3);
        t1.add(4);
        t1.add(2);
        assertEquals("[1, 3, 4, 2]", t1.toString());
        t1.sort(new CompareIntegers());
        assertEquals("[1, 2, 3, 4]", t1.toString());
    }

    /**
     * Helper comparator to test the sort method
     */
    private class CompareIntegers implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

}
