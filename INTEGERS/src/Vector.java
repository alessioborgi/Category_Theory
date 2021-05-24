

public class Vector<T> extends java.util.Vector {

    /**
    Morphism that returns the number of elements contained in the vector,
    the input is a vector, the output is an integer.
     */
    public Integer length() {
        return this.size();  // using the method .size() from java.util.Vector
    }

    /**
    Morphism that returns the dot product of two vectors,
     the inputs are from the category of vectors, the output is an integer.
     */
    public Integer dotProduct(java.util.Vector v2) {
        if (this.size() != v2.size()) {  // checks if the sizes of the two vectors are equal
            // throws an error in case they are not equal
            throw new RuntimeException("The lengths of the vectors are different.");
        }
        int x = 0;
        // creates an index that goes from zero to the number of elements of one vector
        for (int i = 0; i < this.size(); i++) {
            int a = (int) this.elementAt(i); // the i-th element of vector 1
            int b = (int) v2.elementAt(i); // the i-th element of vector 2
            x =  x+(a*b); // their product is added to the dot product x
        }
        return x;
    }

    /**
     Morphism of vector addition: given two vector of the same size returns a third vector
     containing the sum of the elements with the same index.
     */
    public java.util.Vector addition(java.util.Vector v2) {
        if (this.size() != v2.size()) { // checks if the size of the two input vectors is the same
            // if the sizes are different an exception occurs
            throw new RuntimeException("The lengths of the vectors are different.");
        }
        java.util.Vector sum = new java.util.Vector(); // creates a new vector sum
        // creates an index that goes from zero to the number of elements of the vectors
        for (int i = 0; i < v2.size(); i++) {
            int a  = (int) this.elementAt(i); // the i-th element of vector 1
            int b = (int) v2.elementAt(i); // the i-th element of vector 2
            sum.add(a + b); // the sum of the two elements is added to the vector sum
        }
        return sum;
    }

    /**
     Morphism of vector subtraction: given two vector of the same size returns a third vector
     containing the difference between the elements with the same index.
     */
    public java.util.Vector subtraction(java.util.Vector v2) {
        if (this.size() != v2.size()) { // checks if the size of the two input vectors is the same
            // if the sizes are different an exception occurs
            throw new RuntimeException("The lengths of the vectors are different.");
        }
        java.util.Vector diff = new java.util.Vector(); // creates a new vector for the differences
        // creates an index that goes from zero to the number of elements of the vectors
        for (int i = 0; i < v2.size(); i++) {
            int a = (int) this.elementAt(i); // the i-th element of vector 1
            int b = (int) v2.elementAt(i); // the i-th element of vector 2
            diff.add(a - b); // the difference between the two elements is added to the vector diff
        }
        return diff;
    }

    /**
     Implementation of Scalar Multiplication: Morphism that takes as input a vector and a
     scalar, and returns a new vector containing the elements of the input vector
     multiplied by the scalar.
     */
    public java.util.Vector scalarMul(int k) {
        java.util.Vector mult = new java.util.Vector<Integer>(); // a new empty vector is created (mult)
        // creates an index that goes from zero to the number of elements of the vector
        for (int i = 0; i < this.size(); i++) {
            int a = (int) this.elementAt(i); // i-th element of the vector
            mult.add(a *k); // the element multiplied by the scalar is added to the vector mult
        }
        return mult;
    }

    /**
     Here the identity of the morphism "Scalar Multiplication" is checked, the procedure
     is done by multiplying the victor given in input by the scalar 1, that is the
     neutral element of scalar multiplication.
     */
    public Object IdMul(java.util.Vector v) {
        java.util.Vector test = new java.util.Vector<Integer>(); // creates a new empty vector (test)
        // creates an index that goes from zero to the number of elements of the vector
        for (int i = 0; i < v.size(); i++) {
            int a = (int) v.elementAt(i); // "a" is the i-th element of the vector
            // the i-th element is multiplied by the neutral element (1) and added to the test vector
            test.add(a*1);
        }
        // checks the identity (if the new vector test and the original vector are the same)
        if (v.equals(test)) {
            System.out.println("The identity is satisfied");
            return true; // the identity is satisfied
        } else {
            System.out.println("The identity is not satisfied");
            // the vector test is different from the original vector, then the identity is not satisfied
            return false;
        }
    }

    /**
     Implementation of Scalar Division: Morphism that takes as input a vector and a
     scalar, and returns a new vector containing the elements of the input vector
     divided by the scalar.
     */
    public java.util.Vector scalarDiv(int k) {
        if (k == 0) { // checks if the scalar is equal to zero
            throw new AssertionError("Division by zero"); // division by zero creates an error
        }
        java.util.Vector div = new java.util.Vector<Integer>(); // a new empty vector is created (div)
        // creates an index that goes from zero to the number of elements of the vector
        for (int i = 0; i < this.size(); i++) {
            int a = (int) this.elementAt(i); // i-th element of the vector
            div.add(a / k); // the element divided by the scalar is added to the vector div
        }
        return div;
    }

    /**
     Here the identity of the morphism "Scalar Division" is checked, the procedure
     is done by dividing the victor given in input by the scalar 1, that is the
     neutral element of scalar division.
     */
    public Object IdDiv(java.util.Vector v) {
        java.util.Vector test = new java.util.Vector<Integer>(); // creates a new empty vector (test)
        // creates an index that goes from zero to the number of elements of the vector
        for (int i = 0; i < v.size(); i++) {
            int a = (int) v.elementAt(i); // "a" is the i-th element of the vector
            // the i-th element is divided by the neutral element (1) and added to the test vector
            test.add(a / 1);
        }
        // checks the identity (if the new vector test and the original vector are the same)
        if (v.equals(test)) {
            System.out.println("The identity is satisfied");
            return true; // the identity is satisfied
        } else {
            System.out.println("The identity is not satisfied");
            // the vector test is different from the original vector, then the identity is not satisfied
            return false;
        }
    }
}


