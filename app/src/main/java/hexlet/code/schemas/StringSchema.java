package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        addPredicate("isRequired", o -> o instanceof String && !(o.equals("")));
    }

    @Override
    public final StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<Object> isMinLength = o -> {
            String str = o.toString();
            return str.length() >= minLength;
        };
        addPredicate("minLength", isMinLength);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<Object> contains = o -> o.toString().contains(str);
        addPredicate("contains", contains);
        return this;
    }
}
