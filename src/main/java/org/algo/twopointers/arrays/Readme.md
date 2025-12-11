
There are prerequisites to solve the problem using 
2 pointers

1) Linear DS : linear sequences like arrays, strings, or linked lists.
2) Ordered/Sorted Data : Require the data to be sorted
3) Direction of Movement: The pointers should move in a way that efficiently narrows down the solution
4) Clear Condition for Pointer Movement: There should be a well-defined rule for when to move each pointer 

------------------
Failure points

When Two-Pointer Fails
Non-linear Data Structures (Trees, Graphs) – Not directly applicable.
Unordered Data Without Sorting – If sorting is not allowed, some two-pointer techniques won't work.
Problems Requiring Backtracking – Two-pointer is greedy; it doesn’t revisit previous states.
Problems with Random Access Requirement – If moving pointers doesn’t help in reducing the problem size logically, it won’t work.

------------------

Examples of Two-Pointer Problems

1) Sorted Array → Two Sum, Three Sum, Remove Duplicates.
2) Unsorted Array → Dutch National Flag (Partitioning).
3) String → Valid Palindrome, Longest Substring Without Repeating Characters (Sliding Window).
4) Linked List → Detect Cycle, Find Middle, Reverse List.

Conclusion

1) Must-Have: Linear traversal + clear movement logic.
2) Good-to-Have: Sorted data (for efficient comparisons).
3) Not Suitable: Non-linear or problems requiring exhaustive search.


