# FilterJUnit
This program allows to run individual JUnit test methods in a test class

The idea is to extend abstract Filter class and overwrite ShouldRun method, that will filter out methods that is needed to run:

```
@Override
public boolean shouldRun(Description description) {
    return methods.contains(description.getMethodName());
}
```
In the method of running the actual test one need to create a Request object based on aClass name filtered with CustomFilter:
```
try{
    Class<?> aClass = Class.forName(testClass);
    Request request = Request.aClass(aClass).filterWith(new CustomFilter(setOfTestMethods));
    if  (!(new JUnitCore().run(request).wasSuccessful())) return false;
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```
Alternatively, in maven projects one can use Maven Surefire Plugin to run set of test methods:
```
mvn -Dtest=FaultyTest#test1+test2+test3 test
```
