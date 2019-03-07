package Lists.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {


    private LinkedList<String> list;

    public LinkedListTest() {

    }

    /**
     * Test method isEmpty, by creating empty list
     */
    @Test
    public void testIsEmpty() {
        LinkedList list = new LinkedList<Integer>();
        boolean result = list.isEmpty();
        Assert.assertEquals(true, result);
    }

    /**
     * Test method isEmpty, by creating non-empty list
     */
    @Test
    public void testIsNotEmpty() {
        LinkedList list = new LinkedList<>(1);
        boolean result = list.isEmpty();
        Assert.assertEquals(false, result);
    }

    /**
     * Test that after appending to the list, new element is created.
     * 0: Test
     * 1: Test1
     * size should equal 1.
     */
    @Test
    public void testAppendOne() {
        LinkedList list = new LinkedList<>("Test");
        list.append("Test1");
        Assert.assertEquals(1, list.getSize());
    }

    /**
     * Test that after appending 99 elements to the list, new element is created.
     * 0: Test
     * 1: Test0
     * 99: Test99
     * Assert that total size is 99 (100 including head at index=0).
     */
    @Test
    public void testAppendHundred() {
        LinkedList list = new LinkedList<>("Test");
        for(int i = 0; i < 99; i++) {
            list.append("Test"+i);
        }
        Assert.assertEquals(99, list.getSize());
    }

    /**
     * Try removing element 88 of the list.
     */
    @Test
    public void testRemove() {
        LinkedList list = new LinkedList<>("Test");
        for(int i = 0; i < 99; i++) {
            list.append("Test"+i);
        }
        if(list.remove(88)) {
            Assert.assertEquals(98, list.getSize());
        }
        else {
            Assert.fail("Couldn't delete element 88");
        }
    }

    /**
     * Try removing head of the list without affecting it's structure.
     */
    @Test
    public void testRemoveHead() {
        LinkedList list = new LinkedList<>("Test");
        for(int i = 0; i < 99; i++) {
            list.append("Test"+i);
        }
        if(list.remove(0)) {
            if(list.getHead().hasNext()) {
                Assert.assertEquals(98, list.getSize());
            }
        }
        else {
            Assert.fail("Couldn't delete head!");
        }
    }

    /**
     * Try removing last element of the list.
     */
    @Test
    public void testRemoveLast() {
        LinkedList list = new LinkedList<>("Test");
        for(int i = 0; i < 99; i++) {
            list.append("Test"+i);
        }
        if(list.remove(list.getSize())) {
                Assert.assertEquals(98, list.getSize());
        }
        else {
            Assert.fail("Couldn't delete head!");
        }
    }

    /**
     * Try setting an element
     */
    @Test
    public void testSet() throws LinkedListException {
        LinkedList list = new LinkedList<>("Test0");
        for(int i = 1; i < 100; i++) {
            list.append("Test"+i);
        }
        list.set(0,"Test3");
        Assert.assertEquals("Test3", list.get(0));
    }

    /**
     * Test adding elements at the index of the list.
     * @throws LinkedListException
     */
    @Test
    public void testAdd() throws LinkedListException {
        LinkedList list = new LinkedList<>("Test0");
        for(int i = 1; i < 100; i++) {
            list.append("Test"+i);
        }
        list.add(1, "Test123");
        Assert.assertEquals("Test123", list.get(1));
    }

    /**
     * Test copy constructor
     */
    @Test
    public void testCopyCtor() throws LinkedListException {
        LinkedList list = new LinkedList<>("Test0");
        LinkedList cpy;
        boolean status = true;
        for(int i = 1; i < 100; i++) {
            list.append("Test"+i);
        }
        cpy = new LinkedList<>(list);
        for(int i = 0; i < 99; i++) {
            if(cpy.get(i) != list.get(i)) {
                status = false;
            }
        }
        Assert.assertEquals(status, true);
    }
}