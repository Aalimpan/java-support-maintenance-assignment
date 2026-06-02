# Task 2 Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is structurally modified while it is being iterated using an Iterator, enhanced for-loop, or similar traversal mechanism, except through the iterator's own remove() method.

---

## 2. What code pattern at line 142 most likely triggered this error?

A collection was likely modified while iterating over it.

Example:

```java
for (Transaction tx : transactions) {
    if (shouldRemove(tx)) {
        transactions.remove(tx);
    }
}
```

---

## 3. Provide the minimal code change (one or two lines) that resolves this safely.

Use Iterator.remove() instead of modifying the collection directly.

```java
Iterator<Transaction> iterator = transactions.iterator();

while (iterator.hasNext()) {
    Transaction tx = iterator.next();

    if (shouldRemove(tx)) {
        iterator.remove();
    }
}
```
