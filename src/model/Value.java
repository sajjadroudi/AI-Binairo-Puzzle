package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Value {
    WHITE,
    BLACK;

    public static Set<Value> valueSet() {
        return new HashSet<>(Arrays.asList(values()));
    }
}
