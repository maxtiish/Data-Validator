package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private String testText1 = "Pumpkin pie";
    private String testText2 = "Pumpkin pumpkin pie";
    private final int minLength = 15;
    @Test
    public void testStringSchema() {
        StringSchema obj = Validator.string();
        Assertions.assertInstanceOf(StringSchema.class, obj);
        assertTrue(obj.isValid(""));

        obj.required();

        assertFalse(obj.isValid(""));
        assertFalse(obj.isValid(null));
        assertTrue(obj.isValid(testText1));

        obj.minLength(minLength);

        assertTrue(obj.isValid(testText2));
        assertFalse(obj.isValid(testText1));

        obj.contains(testText2);

        assertTrue(obj.isValid(testText2));
        assertFalse(obj.isValid(testText1));
    }
}
