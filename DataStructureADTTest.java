//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DataStructureADTTest.java
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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing
 * @author shihan
 *
 * @param <T>
 */
abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T dataStructureInstance;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
    dataStructureInstance = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    dataStructureInstance = null;
  }


  @Test
  // test00_empty_ds_size
  void test00_empty_ds_size() {
    if (dataStructureInstance.size() != 0)
      fail("data structure should be empty, with size = 0, but size="
          + dataStructureInstance.size());
  }

  @Test
  // test01_after_insert_one_size_is_one
  void test01_after_insert_one_size_is_one() {
    dataStructureInstance.insert("1", "p1");
    if (dataStructureInstance.size() != 1)
      fail("data structure should be with size = 1, but size="
          + dataStructureInstance.size());
  }

  @Test
  // test02_after_insert_one_remove_one_size_is_0
  void test02_after_insert_one_remove_one_size_is_0() {
    dataStructureInstance.insert("1", "p1");
    dataStructureInstance.remove("1");
    if (dataStructureInstance.size() != 0)
      fail("data structure should be empty, with size = 0, but size="
          + dataStructureInstance.size());
  }

  @Test
  // test03_duplicate_exception_is_thrown
  void test03_duplicate_exception_is_thrown() {
    try {
      dataStructureInstance.insert("1", "p1");
      dataStructureInstance.insert("1", "p2");
      fail(
          "Tried to insert duplicate key, RuntimeException should have been thrown");
    } catch (RuntimeException e) {
    }
  }

  @Test
  // test04_remove_returns_false_when_key_not_present
  void test04_remove_returns_false_when_key_not_present() {
    dataStructureInstance.insert("1", "p1");
    if (dataStructureInstance.remove("11"))
      fail("Tried to remove unexsiting pair, should return false");
  }

  @Test
  // test05_null_exception_is_thrown_when_insert_null_key
  void test05_null_exception_is_thrown_when_insert_null_key() {
    try {
      dataStructureInstance.insert(null, "p1");
      fail(
          "Tried to insert null key, IllegalArgumentException should have been thrown");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  // test06_remove_null__key_exception_is_thrown
  void test06_remove_null__key_exception_is_thrown() {
    try {
      dataStructureInstance.insert("1", "p1");
      dataStructureInstance.remove(null);
      fail(
          "Tried to remove null key, IllegalArgumentException should have been thrown");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  // test07_remove_returns__false_when_ds_is_empty
  void test07_remove_returns__false_when_ds_is_empty() {
    if (dataStructureInstance.remove("1"))
      fail("Tried to remove ds, should return false");
  }

  @Test
  // test08_contains_return_false_when_key_presents
  void test08_contains_return_false_when_key_presents() {
    dataStructureInstance.insert("1", "p1");
    if (!dataStructureInstance.contains("1"))
      fail("Key should be contained in ds but it is not");
  }

  @Test
  // test09_get_return_wrong_value_associated_with_key
  void test09_get_return_wrong_value_associated_with_key() {
    dataStructureInstance.insert("1", "p1");
    if (!dataStructureInstance.get("1").equals("p1"))
      fail("Get() method returns unassocaited value");
  }

  @Test
  // test10_throws_RuntimeException_when_insert_removed_key
  void test10_throws_RuntimeException_when_insert_removed_key() {
    try {
      dataStructureInstance.insert("1", "p1");
      dataStructureInstance.remove("1");
      dataStructureInstance.insert("1", "p2");
    } catch (RuntimeException e) {
      fail("Tried to insert a removed key agian, but exception was thrown " + dataStructureInstance.get("1"));
    }
  }

  @Test
  // test11_check_insert_multiple_new_keys_size
  void test11_check_insert_multiple_new_keys_size() {
    dataStructureInstance.insert("1", "p1");
    dataStructureInstance.insert("2", "p2");
    dataStructureInstance.insert("3", "p3");
    dataStructureInstance.insert("4", "p4");
    dataStructureInstance.insert("5", "p5");
    dataStructureInstance.insert("6", "p6");
    dataStructureInstance.insert("7", "p7");
    dataStructureInstance.insert("8", "p8");
    dataStructureInstance.insert("9", "p9");
    dataStructureInstance.insert("10", "p10");
    dataStructureInstance.insert("11", "p11");
    if (dataStructureInstance.size() != 11)
      fail("Size should be 11, but it is " + dataStructureInstance.size());
  }

  @Test
  // test12_check_contains_multiple_inserted_keys
  void test12_check_contains_multiple_inserted_keys() {
    dataStructureInstance.insert("1", "p1");
    dataStructureInstance.insert("2", "p2");
    dataStructureInstance.insert("3", "p3");
    dataStructureInstance.insert("4", "p4");
    dataStructureInstance.insert("5", "p5");
    dataStructureInstance.insert("6", "p6");
    dataStructureInstance.insert("7", "p7");
    dataStructureInstance.insert("8", "p8");
    dataStructureInstance.insert("9", "p9");
    dataStructureInstance.insert("10", "p10");
    dataStructureInstance.insert("11", "p11");
    if (!dataStructureInstance.contains("7"))
      fail("Tried to check if ds contains key 7, but ds does not");
  }

  @Test
  // test13_check_remove_multiple_inserted_key_size
  void test13_check_remove_multiple_inserted_key_size() {
    dataStructureInstance.insert("2", "p2");
    dataStructureInstance.insert("5", "p5");
    dataStructureInstance.insert("11", "p11");
    dataStructureInstance.insert("4", "p4");
    dataStructureInstance.insert("1", "p1");
    dataStructureInstance.insert("6", "p6");
    dataStructureInstance.insert("9", "p9");
    dataStructureInstance.insert("10", "p10");
    dataStructureInstance.insert("8", "p8");
    dataStructureInstance.insert("7", "p7");
    dataStructureInstance.insert("3", "p3");
    dataStructureInstance.remove("7");
    dataStructureInstance.remove("3");
    if (dataStructureInstance.size() != 9)
      fail("Size should be 9, but it is not");
    if (dataStructureInstance.contains("3"))
      fail("DS should not contains key 3");
    if (dataStructureInstance.contains("7"))
      fail("DS should not contains key 7");
    if (dataStructureInstance.contains("3"))
      fail("DS should not contains key 3");
    
  }
  // TODO: add tests to ensure that you can detect implementation that fail

  // Tip: consider different numbers of inserts and removes and how different
  // combinations of insert and removes


}
