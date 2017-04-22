import junit.framework.TestCase;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SinglyLinkedListTest extends TestCase {
    //several lists for testing
    private SinglyLinkedList<String> emptyList;
    private SinglyLinkedList<String> listOne;
    private SinglyLinkedList<String> longList;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        emptyList = new SinglyLinkedList<>();
        listOne = new SinglyLinkedList<>();
        listOne.add("One");
        longList = new SinglyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            longList.add(Integer.toString(i));
        }
    }

    @Test
    public void testClear() throws Exception {
        emptyList.add("hi");
        assertFalse(emptyList.isEmpty());
        assertEquals(1, emptyList.size());
        emptyList.clear();
        assertNull(emptyList.get(0));
        assertEquals(0, emptyList.size());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("One", listOne.get(0));
        assertEquals(null, emptyList.get(0));
        assertEquals(null, listOne.get(2));
        assertEquals(null, listOne.get(-1));
        assertEquals("3", longList.get(3));
    }

    @Test
    public void testAdd() throws Exception {
        assertFalse(longList.add(-1, "2"));
        assertFalse(longList.add(5, "adding past index"));
        assertTrue(longList.add(0, "adding to head"));
        assertEquals(5, longList.size());
        assertEquals("adding to head", longList.get(0));
        assertTrue(longList.add(2, "index 2"));
        assertEquals(6, longList.size());
        assertEquals("index 2", longList.get(2));
        assertTrue(listOne.add(1, "index 1"));
        assertEquals("index 1", listOne.get(1));
    }

    @Test
    public void testRemove() throws Exception {
        assertEquals(null, emptyList.remove(0));
        assertEquals(null, listOne.remove(-1));
        assertEquals(null, listOne.remove(4));
        assertEquals("One", listOne.remove(0));
        assertEquals(0, listOne.size());
        assertEquals("3", longList.remove(3));
        assertTrue(longList.remove("2"));
        assertEquals(2, longList.size());

    }

    @Test
    public void testContains() throws Exception {
        assertTrue(longList.contains("1"));
        assertFalse(emptyList.contains("1"));
        assertFalse(longList.contains("Five"));
    }
}
