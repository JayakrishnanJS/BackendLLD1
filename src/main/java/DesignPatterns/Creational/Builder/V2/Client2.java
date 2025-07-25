package DesignPatterns.Creational.Builder.V2;

import java.util.HashMap;
import java.util.Map;

public class Client2 {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 107);
        params.put("name", "Phone");
        params.put("price", 30000);
        params.put("quantity", 1);
        params.put("isPrime", true);
        params.put("discount", 10.0);
        params.put("paymentMethod", "Credit Card");
        SoldItem item7 = new SoldItem(params);
        System.out.println();
    }
}
/*
| Benefit                         | Description                                           |
| ------------------------------- | ----------------------------------------------------- |
| 🧩 Flexible input               | Pass only what you need; order doesn’t matter         |
| 🔁 Avoid constructor explosion  | One constructor handles all combinations              |
| 🎯 Centralized default handling | `getOrDefault()` provides easy fallback values        |
| 📦 Future-proof                 | Add new fields without breaking existing constructors |

Limitations of hashmap approach
    1. No compile-time type checking - A hash map cannot have values with different types. If we want to use
                                       different types, we need to use a hash map with a string key and an
                                       object value. However, this will result in a runtime error if we try to
                                       cast the object to the wrong type.

    2. Defined parameters - With the above approach, identifying the parameters is difficult. We need to read
                            the code to identify the parameters. This is not a good approach because it is
                            difficult to maintain and extend the code.
    3. Harder to read and understand
    4. No IDE autocomplete for field names
 */