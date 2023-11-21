package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public class StringSchema {
    protected boolean isRequired = false;

    protected LinkedHashMap<String, Predicate> predicates = new LinkedHashMap<>();

    protected final void addPredicate(String name, Predicate predicate) {
        this.predicates.put(name, predicate);
    }
    public StringSchema() {
        addPredicate("isRequired", o -> o instanceof String && !(o.equals("")));
    }

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<Object> isMinLength = o -> {
            String str = o.toString();
            return str.length() >= minLength;
        };
        addPredicate("minLength", isMinLength);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<Object> contains = o -> o.toString().contains(str);
        addPredicate("contains", contains);
        return this;
    }
    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.entrySet().stream()
                .allMatch(o -> o.getValue().test(obj));
    }
}
