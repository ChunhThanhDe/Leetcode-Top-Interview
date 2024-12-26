## Let’s explain step by step 🐇

**how to reverse part of a linked list from `left = 2` to `right = 4`** using an `example 1`:

---

### **Input:**

The linked list: `1 -> 2 -> 3 -> 4 -> 5`
We need to reverse the section between positions `left = 2` and `right = 4`.

---

### **Step 1: Initialization**

Create a dummy node to make edge cases easier to handle. The list now looks like this:

```
dummy -> 1 -> 2 -> 3 -> 4 -> 5
```

Declare pointers:

- **`prev`**: Points to the node just before the `left` position. Initially, `prev` points to `dummy`.

- Move `prev` to the node just before `left`. After the loop, `prev` points to:

```
prev -> 1
```

Identify important nodes:

- **`start`**: The first node of the section to be reversed (`left` position), which is `2`.

- **`then`**: The node immediately after `start`, which is `3`.

Initial setup looks like this:

```
dummy -> 1 -> 2 -> 3 -> 4 -> 5
           prev   start   then
```

---

### **Step 2: Reverse the Sublist**

We loop `right - left` times (2 times in this case) to reverse the section between `left` and `right`.

---

#### **Iteration 1:**

**Update links:**

- `start.next = then.next`: Node `2` (`start`) now points to `4` (skipping `3`).

- `then.next = prev.next`: Node `3` (`then`) now points to `2`.

- `prev.next = then`: Node `1` (`prev`) now points to `3`.

The list now looks like this:

```
dummy -> 1 -> 3 -> 2 -> 4 -> 5
         prev   then   start
```

**Move `then` to the next node after `start` (node `4`):**

```
then -> 4
```

---

#### **Iteration 2:**

**Update links:**

- `start.next = then.next`: Node `2` (`start`) now points to `5` (skipping `4`).

- `then.next = prev.next`: Node `4` (`then`) now points to `3`.

- `prev.next = then`: Node `1` (`prev`) now points to `4`.

The list now looks like this:

```
dummy -> 1 -> 4 -> 3 -> 2 -> 5
         prev         start
```

**Move `then` to the next node after `start` (node `5`):**

```
theen -> 5
```

---

### **Step 3: Return the Result**

After completing the loop, the section from `left` to `right` has been reversed. Return the list starting from `dummy.next`:

```
1 -> 4 -> 3 -> 2 -> 5
```
