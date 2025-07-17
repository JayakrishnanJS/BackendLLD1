**Java Collections Framework: Data Structures Cheat Sheet**

This note summarizes and compares the primary data structures in the Java Collections Framework. It covers:

* **Core Interfaces & Implementations**: List, Set, Queue/Deque, Map
* **Time Complexity** (average / worst) for common operations
* **Space Overhead** considerations
* **Real‑World Use Cases** and recommendations

---

## 1. List

| Implementation | Access | Search | Insertion    | Deletion     | Memory Overhead                | Use Case                                    |
| -------------- | ------ | ------ | ------------ | ------------ | ------------------------------ | ------------------------------------------- |
| **ArrayList**  | O(1)   | O(n)   | O(n) (shift) | O(n) (shift) | Low (backed by array)          | Random access, dynamic array, iterate fast  |
| **LinkedList** | O(n)   | O(n)   | O(1) at ends | O(1) at ends | High (node objects + pointers) | Frequent add/remove at ends, queues, deques |

**Real‑World:**

* **ArrayList**: ideal for implementing a dynamic array of GUI elements, storing sensor readings, bulk operations.
* **LinkedList**: useful for LRU caches, undo/redo stacks, double‑ended queues.

---

## 2. Set

| Implementation    | Add/Remove/Search     | Iteration Order       | Memory Overhead             | Use Case                                                   |
| ----------------- | --------------------- | --------------------- | --------------------------- | ---------------------------------------------------------- |
| **HashSet**       | O(1) avg / O(n) worst | Unordered             | Moderate (HashMap buckets)  | Fast membership test, de‑duplication                       |
| **LinkedHashSet** | O(1) avg              | Insertion order       | Higher (doubly linked list) | Preserving insertion order (caches, predictable iteration) |
| **TreeSet**       | O(log n)              | Sorted (natural/comp) | Moderate (tree nodes)       | Range views, sorted data (leaderboards, navigation menus)  |

---

## 3. Queue & Deque

| Implementation | Enqueue/Dequeue | Memory Overhead      | Use Case                                           |
| -------------- | --------------- | -------------------- | -------------------------------------------------- |
| **ArrayDeque** | O(1)            | Low (circular array) | Stacks/queues, recursion elimination, parser state |
| **LinkedList** | O(1) at ends    | High                 | Legacy queue, deque implementations                |

**Thread‑safe variants:** `ConcurrentLinkedQueue` (non‑blocking, high‑throughput), `LinkedBlockingQueue` (blocking).

---

## 4. Map

| Implementation        | Put/Get               | Search   | Iteration Order           | Memory Overhead              | Use Case                                        |
| --------------------- | --------------------- | -------- | ------------------------- | ---------------------------- | ----------------------------------------------- |
| **HashMap**           | O(1) avg              | O(1) avg | Unordered                 | Moderate (buckets + entries) | Caching, indexing, frequency counts             |
| **LinkedHashMap**     | O(1) avg              | O(1) avg | Insertion or access order | Higher (linked entries)      | LRU cache (access-order), order‑preserving maps |
| **TreeMap**           | O(log n)              | O(log n) | Sorted                    | Moderate (tree nodes)        | Sorted keys, range queries, navigable maps      |
| **ConcurrentHashMap** | O(1) avg (concurrent) | O(1) avg | Unordered                 | High (segments/locks)        | High‑concurrency maps without blocking          |

---

## 5. Summary Comparison

| DS Category       | Best for…                           | Avoid when…                                  |
| ----------------- | ----------------------------------- | -------------------------------------------- |
| ArrayList         | Random access, frequent reads       | Frequent mid‑list inserts/removals           |
| LinkedList        | Frequent head/tail inserts/removals | Random access, memory‑sensitive environments |
| HashSet           | Fast membership, de‑duplication     | Need predictable iteration order             |
| LinkedHashSet     | Order‑preserving set                | Strict memory constraints                    |
| TreeSet           | Sorted set operations               | Very large datasets with simple membership   |
| ArrayDeque        | Fast stack/queue                    | Need thread safety                           |
| HashMap           | General‑purpose key/value storage   | Need sorted keys or guaranteed order         |
| LinkedHashMap     | Cache implementations               | Very high insert volume (memory overhead)    |
| TreeMap           | Range queries, sorted keys          | Extremely large key spaces                   |
| ConcurrentHashMap | Multi‑threaded access               | Single thread without contention             |

---

### Space vs. Time Tradeoffs

* **Array‑based** (ArrayList, ArrayDeque): contiguous memory, low per‑element overhead, excellent cache performance.
* **Linked‑node** (LinkedList, TreeSet): high per‑element overhead (pointers/links), stable insert/remove at arbitrary positions.
* **Hash‑based** (HashSet, HashMap): fast average operations, moderate overhead for buckets and entries.
* **Tree‑based** (TreeSet, TreeMap): sorted guarantees, O(log n) costs, balanced‑tree overhead.

---

### Real‑World Applications

* **Caching**: `LinkedHashMap` (access‑order) for LRU caches.
* **Scheduling**: `PriorityQueue` (min/max), `TreeMap` for time‑based events.
* **Graph algorithms**: `HashSet` for visited nodes, `HashMap` for adjacency lists.
* **Streaming & Filtering**: `ArrayDeque` for sliding‑window operations.
* **Concurrent Systems**: `ConcurrentHashMap`, `LinkedBlockingQueue` for producer‑consumer patterns.

---

*Compiled by Your Name — Java Collections Cheat Sheet*
