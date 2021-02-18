import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import java.util.HashSet;
import java.util.Set;

public class CustomFilter extends Filter {
    HashSet<String> methods;
    public CustomFilter(Set<String> methods) {
        this.methods = new HashSet<String>();
        for(String method: methods) {
            this.methods.add(method);
        }
    }
    @Override
    public boolean shouldRun(Description description) {
        return methods.contains(description.getMethodName());
    }

    @Override
    public String describe() {
        return null;
    }
}
