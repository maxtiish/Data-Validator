package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    public void testNumberSchema() {
        NumberSchema obj = Validator.number();
        Assertions.assertInstanceOf(NumberSchema.class, obj);
        assertTrue(obj.isValid(""));
        assertTrue(obj.isValid("string"));

        obj.required();

        assertFalse(obj.isValid(""));
        assertFalse(obj.isValid(null));
        assertTrue(obj.isValid(5));

        obj.positive();

        assertTrue(obj.isValid(5));
        assertFalse(obj.isValid(-5));

        obj.range(1, 10);

        assertTrue(obj.isValid(1));
        assertTrue(obj.isValid(10));
        assertTrue(obj.isValid(5));
        assertFalse(obj.isValid(12));
    }
}
