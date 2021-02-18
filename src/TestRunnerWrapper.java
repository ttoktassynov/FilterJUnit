import org.junit.runner.*;
import java.util.Set;

public class TestRunnerWrapper {
    public boolean runJUnitTestMethods(String testClass, Set<String> setOfTestMethods) throws ClassNotFoundException{
        if (setOfTestMethods.size() == 0) {
            throw new ClassNotFoundException();
        }
        try{
            Class<?> aClass = Class.forName(testClass);
            Request request = Request.aClass(aClass).filterWith(new CustomFilter(setOfTestMethods));
            if  (!(new JUnitCore().run(request).wasSuccessful())) return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean runJUnitTestClasses(Set<String> setOfTestClasses) throws ClassNotFoundException {
        if (setOfTestClasses.size() == 0) {
            throw new ClassNotFoundException();
        }
        Result testClassResult;
        for (String testClass : setOfTestClasses) {
            try {
                Class<?> aClass = Class.forName(testClass);
                testClassResult = JUnitCore.runClasses(aClass);
                if (!testClassResult.wasSuccessful()) return false;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
