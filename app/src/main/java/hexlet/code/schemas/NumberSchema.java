package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addPredicate("isRequired", o -> o instanceof Number && !o.equals(""));
    }

    @Override
    public final NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> isPositive = o -> {
            return o > 0;
        };
        addPredicate("positive", isPositive);
        return this;
    }

    public NumberSchema range(int minNum, int maxNum) {
        Predicate<Integer> isInRange = o -> {
            return o >= minNum && o <= maxNum;
        };
        addPredicate("range", isInRange);
        return this;
    }
}
