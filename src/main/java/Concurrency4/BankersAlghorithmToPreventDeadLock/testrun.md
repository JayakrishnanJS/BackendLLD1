## Initial State:
- **Available Resources**: [3, 3, 2]
- **Need Matrix**: Maximum need as no resources are allocated yet.

---

### Customer Requests and Results

1. **Customer 0** requests `[0, 2, 0]`
    - **Available**: [3, 3, 2]
    - **Need**: [7, 5, 3]
    - **Result**: **GRANTED**
        - Request ≤ Need and Request ≤ Available; safe-state check passes.
        - **New Available**: [3, 1, 2]
        - **New Need[0]**: [7, 3, 3]

---

2. **Customer 1** requests `[2, 0, 0]`
    - **Available**: [3, 1, 2]
    - **Need**: [3, 2, 2]
    - **Result**: **GRANTED**
        - Request ≤ Need and Request ≤ Available; safe-state check passes.
        - **New Available**: [1, 1, 2]
        - **New Need[1]**: [1, 2, 2]

---

3. **Customer 2** requests `[1, 0, 2]`
    - **Available**: [1, 1, 2]
    - **Need**: [9, 0, 2]
    - **Result**: **GRANTED**
        - Request ≤ Need and Request ≤ Available; safe-state check passes.
        - **New Available**: [0, 1, 0]
        - **New Need[2]**: [8, 0, 0]

---

4. **Customer 3** requests `[0, 1, 0]`
    - **Available**: [0, 1, 0]
    - **Need**: [2, 2, 2]
    - **Result**: **GRANTED**
        - Request ≤ Need and Request ≤ Available; safe-state check passes.
        - **New Available**: [0, 0, 0]
        - **New Need[3]**: [2, 1, 2]

---

5. **Customer 4** requests `[0, 0, 2]`
    - **Available**: [0, 0, 0]
    - **Need**: [4, 3, 3]
    - **Result**: **DENIED**
        - Request cannot be fulfilled immediately as `request[2]=2 > available[2]=0`.
        - The system remains **in a safe state**, ensuring no deadlock occurs.