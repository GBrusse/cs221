/**
 * Runs a set of black box tests for lists that 
 * implement IndexedUnsortedList ADT. 
 * This is a set of black box tests that should 
 * work for any implementation.
 * 
 * @author CS221
 */
public class RunIndexedUnsortedTests
{
	// TODO: make sure using correct list when running tests 
	
	// Which list to use in tests:
	// { goodList, arrayList, singleLinkedList, doubleLinkedList, wrappedDLL }
	
	private final static ListType LIST_TYPE = ListType.doubleLinkedList; 

	// total test count
	private static int totalTests = 0; 

	// instance variables for tracking test results
	private static int passes = 0;
	private static int failures = 0;
	private static int total = 0;

	/** 
	 * Run tests
	 * @param args - not used in this test suite
	 */
	public static void main(String[] args)
	{
		runTests();
		
		// report final verdict
		printFinalSummary();
	}
	
	/** 
	 * Run tests to confirm required functionality of implementation
	*/
	private static void runTests()
	{		
		// Tests for given change scenarios
		Test_1_constructor_emptyList constructor_emptyList = new Test_1_constructor_emptyList();
		printDescription(constructor_emptyList.getDescription());
		constructor_emptyList.run(LIST_TYPE); 
		totalTests += constructor_emptyList.getNumTests(); 
		printLine(); 
			
		Test_6_A_addToFrontB_BA A_addToFrontB_BA = new Test_6_A_addToFrontB_BA();
		printDescription(A_addToFrontB_BA.getDescription());
		A_addToFrontB_BA.run(LIST_TYPE); 
		totalTests += A_addToFrontB_BA.getNumTests(); 
		printLine(); 
		
		Test_39_ABC_remove1_AC ABC_remove1_AC = new Test_39_ABC_remove1_AC();
		printDescription(ABC_remove1_AC.getDescription());
		ABC_remove1_AC.run(LIST_TYPE); 
		totalTests += ABC_remove1_AC.getNumTests(); 
		printLine(); 
		
		// TODO: Add instances of your test classes here 
		

	}
	
	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc - description of the test
	 * @param result - indicates whether the test passed or failed
	 */	
	public static void printResults(String testDesc, boolean result)
	{
		total++;
		if (result) 
		{
			passes++;
		} 
		else 
		{
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** 
	 * Print a final summary 
	 */
	private static void printFinalSummary()
	{
		System.out.printf("\nTotal Tests Run: %d of %d,  Passed: %d,  "
				           + "Failed: %d\n", total, totalTests, passes, failures);
	}
	
	/**
	 * Prints description of tests 
	 * @param description - description of tests 
	 */
	private static void printDescription(String description)
	{
		System.out.println(description);		
	}

	/** 
	 * Prints line between tests
	 */
	private static void printLine()
	{
		System.out.println("=======================================================");
		
	}

}
