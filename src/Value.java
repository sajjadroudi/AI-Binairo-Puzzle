import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

enum Value {
    WHITE,
    BLACK;

    public static Set<Value> valueSet() {
        return new HashSet<>(Arrays.asList(values()));
    }
}
