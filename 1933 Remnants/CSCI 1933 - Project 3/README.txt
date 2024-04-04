Alek Holiman
holim004

To run code properly, compile from SparceIntMatrixTest with correct file input.

It should be assumed that no negative entries are given in file inputs, and that
formatting is done correctly.

Implemented a helper function getEntry(int row, int col) to help check location existence.
Put in a toString() method to be used during testing.

Source 1 (Hashmaps): https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
Source 2 (String formatting): https://www.geeksforgeeks.org/java-string-format-method-with-examples/

1.) Sparce: O(N^2)
    2D: O(N^2)

2.) The efficency when compared to that of the 2D Array is equal to 10,000r, where r is the 
constant space ratio between an integer and a MatrixEntry object.
When r * (10,000,000,000 / m) is less than one, the 2D array becomes more efficient.

“I certify that the information contained in this README file is 
complete and accurate. I have both read and followed the course policies in the ‘Academic 
Integrity - Course Policy’ section of the course syllabus.” 