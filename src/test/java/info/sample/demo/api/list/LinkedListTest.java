package info.sample.demo.api.list;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testAssertList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        // Check size
        assertThat(linkedList.size(), is(6));
        // Check value
        assertThat(linkedList.toString(), is("[1][2][3][4][5][6]"));
        
        // Remove tail
        linkedList.removeTail();
        assertThat(linkedList.toString(), is("[1][2][3][4][5]"));
        
        // Remove greater than
        linkedList.removeGt(3);
        assertThat(linkedList.toString(), is("[1][2][3]"));
    }

}
