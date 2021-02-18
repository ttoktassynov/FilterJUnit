import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;



public class FaultyTest {
    Faulty faulty = new Faulty();
    @Test
    public void test1() {
        assertEquals(2, faulty.mid(3,2, 1));
    }
    @Test
    public void test2(){
        assertEquals(2, faulty.mid(1,3,2));
    }
    @Test
    public void test3(){
        assertEquals(2, faulty.mid(2,1,3));
    }
    @Test
    public void test4(){
        assertEquals(2, faulty.mid(2,2,1));
    }
    @Test
    public void test5(){
        assertEquals(2,faulty.mid(2,1,2));
    }
    @Test
    public void test6(){
        assertEquals(2, faulty.mid(1,2,2));
    }

}
