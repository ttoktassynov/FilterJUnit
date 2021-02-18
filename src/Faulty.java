import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Faulty {
    //test1-321-ok
    //test2-132-ok
    //test3-213-no
    int mid(int x, int y, int z) {
        int m = z;
        if (y < z) {
            if (x < y)
                m = y;
            else if (x < z)
                m = y;//should be m = x;
        } else {
            if (x > y)
                m = y;
            else if (x > z)
                m = x;
        }
        return m;
    }
    public static void main(String args []){
        TestRunnerWrapper runnerWrapper = new TestRunnerWrapper();
        try {
            Set<String> setOfTestMethods = new HashSet<>(
                    List.of("test1", "test2")
            );

            boolean resultForMethods = runnerWrapper.runJUnitTestMethods("FaultyTest", setOfTestMethods);
            System.out.println("Unit tests for test methods was successful: " + resultForMethods);

            Set<String> setOfTestClasses = new HashSet<>(
                    List.of("FaultyTest")
            );
            boolean resultForClasses = runnerWrapper.runJUnitTestClasses(setOfTestClasses);
            System.out.println("Unit tests for test classes was successful: " + resultForClasses);

        }
        catch(ClassNotFoundException ex) {
            System.out.printf(ex.getMessage());
        }

    }
}