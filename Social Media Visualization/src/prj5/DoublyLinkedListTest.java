/**
 * 
 */
package prj5;

import static org.junit.Assert.*;
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
    }


    /**
     * Test method for getLastnode.
     */
    @Test
    public void testGetLastNode() {
        assertEquals(3, (int)t1.getLastNode().getData());
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

        assertEquals(1, (int)t1.getFirstNode().getData());
        t1.remove(0);
        assertEquals(2, (int)t1.getFirstNode().getData());
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
     * Test method for sort.
     */
    @Test
    public void testSort() {
        fail("Not yet implemented");
    }

}
