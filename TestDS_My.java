//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: TestDS_My.java
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
//
// for each data structure class file you wish to test:
//     1. create a test class (like this one) 
//     2. edit the actual type being created (line 16)
//     3. run this test class 
//     4. OR, configure Eclipse project to run all tests
//        Eclipse: Run->Run Configurations->"Run All Tests..."

@SuppressWarnings("rawtypes")
public class TestDS_My extends DataStructureADTTest {

	// the return type must be the name of the data structure class you are testing
	@Override
	protected DataStructureADT createInstance() {
		return new DS_My();
	}

}
