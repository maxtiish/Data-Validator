package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    public void testMapSchema() {
        MapSchema obj = Validator.map();
        Assertions.assertInstanceOf(MapSchema.class, obj);
        assertTrue(obj.isValid(""));

        obj.required();

        assertFalse(obj.isValid(""));
        assertFalse(obj.isValid(null));
        assertTrue(obj.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(obj.isValid(data));

        obj.sizeOf(2);
        assertFalse(obj.isValid(data));
        data.put("key2", "value2");
        assertTrue(obj.isValid(data));
    }
}
