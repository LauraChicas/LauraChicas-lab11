import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.io.*;
import java.net.*;
import java.time.*;

public class Lab11_Tests {
    /*
        Complete the test case below that checks to see that threads A and B have both contributed 100 entries respectively
        to the shared ArrayList when they have both finished running.
    */
    @Test
    public void test1() {
        Lab11_Thread threadA = new Lab11_Thread("A1", 100);
        Lab11_Thread threadB = new Lab11_Thread("B1", 100);

        threadA.setData(new ArrayList<String>());

        threadA.start();
        threadB.start();
        
        try{
            threadA.join();
            threadB.join();
        }catch(InterruptedException e){
            e.printStackTrace();;
        }
        ArrayList<String> result1 = threadA.getData();
        ArrayList<String> result2 = threadB.getData();
        int countA = 0;
        int countB = 0;
        for(String startA : result1){
            if(startA.startsWith("A1")){
                countA++;
            }
            if(startA.startsWith("B1")){
                countB++;
            }
        }
        assertEquals("100", 100, countA); //Checks that threadA makes 100 entries
        assertEquals("100", 100,countB); //Checks that threadB makes 100 entries
        assertEquals("Result 200",200, result1.size(), result2.size()); //Check that both results equals 200 entries.

    }

    /*
        Complete the test case below that checks to see if the shared ArrayList has at least 10 entries after 500ms of system time
    */
    @Test
    public void test2() {

        Lab11_Thread threadA = new Lab11_Thread("A2", 500);
        Lab11_Thread threadB = new Lab11_Thread("B2", 500);

        threadA.start();
        threadB.start();
        try {
            Thread.sleep(500); 
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
        Complete the test case below that checks to see if thread A finishes adding its 10 entries before thread B was allowed to 
        add anything to the shared ArrayList
    */
    @Test
    public void test3() {
        Lab11_Thread threadA = new Lab11_Thread("A3", 10);
        Lab11_Thread threadB = new Lab11_Thread("B3", 10);

        threadA.start();
        
        try {
            threadA.join(); //it should 
        } catch (Exception e){
            e.printStackTrace();
        }
        
        threadB.start();
    }
}