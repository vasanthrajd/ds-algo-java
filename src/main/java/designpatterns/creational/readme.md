Singleton Pattern — “Ensure only one instance exists”

Goal: Control instance creation.

Clues:

Think: What mechanism controls object creation in a class?

You want to prevent direct construction — how can you do that?

You also want to store one shared instance — where can it be stored?

Who should be responsible for giving access to it?

How will you handle thread-safety if multiple threads ask for it at once?