package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected boolean isRequired = false;

    protected LinkedHashMap<String, Predicate> predicates = new LinkedHashMap<>();

    public abstract BaseSchema required();

    protected final void addPredicate(String name, Predicate predicate) {
        this.predicates.put(name, predicate);
    }

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.entrySet().stream()
                .allMatch(o -> o.getValue().test(obj));
    }
}
