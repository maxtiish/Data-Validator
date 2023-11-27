### Hexlet tests and linter status:
[![Actions Status](https://github.com/maxtiish/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/maxtiish/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/a5d0b734732ae3e09489/maintainability)](https://codeclimate.com/github/maxtiish/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a5d0b734732ae3e09489/test_coverage)](https://codeclimate.com/github/maxtiish/java-project-78/test_coverage)

Data Validator is a library that is used to validate data. There are three types of data that can be checked with this tool: String, Map, Number.

## How to use validator
### Instruction:
* Download files;
* Use ```make install``` command to create a .jar file;
* Put the .jar file in the same folder as your code;
* Import the necessary class or package into your project;

### Example of using Data Validator:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// String
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Number
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Объект Map с поддержкой проверки структуры
schema.isValid(-10); // false
schema.isValid(10); // true

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "James");
human1.put("age", 18);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
