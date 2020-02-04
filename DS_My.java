//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DS_My.java
// Files: DS_My.java TestDS_My.java DataStructureADTTest.java
// Course: Comp Sci 400, section 002
//
// Author: Shihan Cheng
// Email: scheng93@wisc.edu
// Lecturer's Name: Debra Deppeler
// Description: This program is designed to create a Data Structure storing the
// data of pairs of key and value, to create tests to test if the Data Structure
// works via using JUnit test.
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This program is designed to create a Data Structure storing the data of pairs
 * of key and value. We choose BST to maintain the Data Structure
 * 
 * @author shihan
 *
 */
public class DS_My implements DataStructureADT {

  /**
   * Inner class to create the data structure
   * 
   * @author shihan
   *
   */
  private class Pair {
    // Private Fields of the inner class
    private Comparable key;
    private Object value;
    private Pair leftChild;
    private Pair rightChild;

    /**
     * Constructor of the inner class
     * 
     * @param key    Pair's key
     * @param value  Pair's value
     * @param parent Pair's parent
     */
    private Pair(Comparable key, Object value, Pair leftChild,
        Pair rightChild) {
      this.key = key;
      this.value = value;
      this.leftChild = null;
      this.rightChild = null;
    }
  }

  // Private Fields of the class
  private Pair root;
  private int size;

  /**
   * The constructor of the outer class
   */
  public DS_My() {
    // Initialize the constructor
    this.root = null;
    this.size = 0;
    

  }

  /**
   * This method works for inserting a Pair into BST
   * 
   * @param k Pair's key
   * @param v Pair's value
   */
  @Override
  public void insert(Comparable k, Object v) {
    // Check if k is null or already in BST
    if (k == null)
      throw new IllegalArgumentException("null key");
    if (this.contains(k))
      throw new RuntimeException("duplicate key");
    // If not, call helper method to insert it in
    this.root = insertHelper(k, v, this.root);
  }

  /**
   * Helper method to insert a new Pair in
   * 
   * @param pair    Pair to insert in
   * @param current The root of BST
   */
  public Pair insertHelper(Comparable k, Object v, Pair n) {
    // Base case
    if (n == null) {
      // If Data Structure is empty, set pair to root
      // If n is null, set pair to n
      this.size++;
      return new Pair(k, v, null, null);
      // Size increases
    } else if (n.key.compareTo(k) > 0) {
      n.leftChild = insertHelper(k, v, n.leftChild);
    } else {
      n.rightChild = insertHelper(k, v, n.rightChild);
    }
    return n;
  }

  /**
   * This method works for removing a Pair from BST
   * 
   * @param k The key of the Pair
   * @return true if method successfully removes the Pair, false otherwise
   */
  @Override
  public boolean remove(Comparable k) {
    // Check if k is null
    if (k == null)
      throw new IllegalArgumentException("null key");
    // If not, call helper method to remove the Pair
    return removeHelper(k, this.root);
  }

  /**
   * Helper method to remove a Pair
   * 
   * @param k       Pair's key
   * @param current The root of BST
   * @return true if method successfully removes the Pair, false otherwise
   */
  public boolean removeHelper(Comparable k, Pair n) {
    // If root is null, nothing is in BST
    if (n == null) {
      return false;
    }
    // Base case, matching Pair found
    if (n.key.compareTo(k) == 0) {
      // Case 1: the matching Pair has no child
      if (n.leftChild == null && n.rightChild == null) {
        // Special Case: if matching Pair is the root and root is the only Pair
        // in BST, then empty BST
        if (this.size() == 1) {
          this.root = null;
          this.size = 0;
          return true;
        }
        // Otherwise, remove the Pair and decrease size

        n = null;

        this.size--;
        return true;
      } else if (n.leftChild == null && n.rightChild != null) {
        // Case 2: matching Pair only has right child, turn n's right child to n
        n.key = n.rightChild.key;
        n.value = n.rightChild.value;

        Pair temp = n.rightChild;

        if (n.rightChild.leftChild != null)
          n.leftChild = n.rightChild.leftChild;

        if (n.rightChild.rightChild != null)
          n.rightChild = n.rightChild.rightChild;

        temp.leftChild = null;
        temp.rightChild = null;

        this.size--;
        return true;
      } else if (n.leftChild != null && n.rightChild == null) {
        // Case 4: matching Pair only has left child, turn n's left child to n
        n.key = n.leftChild.key;
        n.value = n.leftChild.value;

        Pair temp = n.leftChild;

        if (n.leftChild.leftChild != null)
          n.leftChild = n.leftChild.leftChild;
        if (n.leftChild.rightChild != null)
          n.rightChild = n.leftChild.rightChild;

        temp.leftChild = null;
        temp.rightChild = null;

        this.size--;
      } else { // Case 4: matching Pair has two children
        Pair temp = n.leftChild;
        while (temp.rightChild != null) {
          temp = temp.rightChild;
        }
        n.key = temp.key;
        n.value = temp.value;
        removeHelper(temp.key, n.leftChild);
      }
    } else if (n.key.compareTo(k) > 0) { // Recursion case
      removeHelper(k, n.leftChild);
    } else {
      removeHelper(k, n.rightChild);
    }
    return false;
  }

  /**
   * This method works for checking if a Pair is in the Data Structure
   * 
   * @param k Pair's key
   * @return true if the Pair is in Data Structure, false otherwise
   */
  @Override
  public boolean contains(Comparable k) {
    if (k == null)
      return false;
    // Call helper method to check
    return containsHelper(k, this.root);
  }

  /**
   * Helper method to check if the Pair is in Data Structure
   * 
   * @param k       Pair's key
   * @param current The root of the Data Structure
   * @return true if the Pair is in Data Structure, false otherwise
   */
  private boolean containsHelper(Comparable k, Pair current) {
    if (current == null) { // Base case
      return false;
    } else if (current.key.compareTo(k) == 0) { // Matching Pair found
      return true;
    } else if (current.key.compareTo(k) < 0) { // R
      return containsHelper(k, current.rightChild);
    } else {
      return containsHelper(k, current.leftChild);
    }
  }

  /**
   * This method works for getting the value of a Pair
   * 
   * @param k key of the Pair
   * @return the value of the Pair
   */
  @Override
  public Object get(Comparable k) {
    if (k == null)
      throw new IllegalArgumentException("null key");

    return getHelper(k, this.root);
  }

  /**
   * Helper method to get Pair's value
   * 
   * @param k       key of the Pair
   * @param current The root of BST
   * @return the value of the Pair
   */
  public Object getHelper(Comparable k, Pair current) {
    if (current == null) {
      return null;
    } else if (current.key.compareTo(k) < 0) {
      getHelper(k, current.rightChild);
    } else if (current.key.compareTo(k) > 0) {
      getHelper(k, current.leftChild);
    } else {
      return current.value;
    }
    return null;
  }

  /**
   * This method returns the number of elements in the data structure
   * 
   * @return size of BST
   */
  @Override
  public int size() {
    return this.size;
  }

}
