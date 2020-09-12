/**
 * Runs a set of black box tests that
 * should work for any implementation of SimpleSet ADT.
 * 
 * @author Matt T, mvail
 */

public class RunSetTests
{
	// total test count
	private static int TOTAL_TESTS = 111;

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
	 * Run tests to confirm required functionality of constructors and methods 
	*/
	private static void runTests()
	{
		// aka noSet_constructor_emptySet
		Test_emptySet test_emptySet = new Test_emptySet(); 
		printLabel(test_emptySet.getLabel());
		test_emptySet.run(); 
		printLine(); 
		
		Test_emptySet_addA_A emptySet_addA_A = new Test_emptySet_addA_A();
		printLabel(emptySet_addA_A.getLabel());
		emptySet_addA_A.run(); 
		printLine(); 
		
		Test_A_removeA_emptySet test_A_removeA_emptySet = new Test_A_removeA_emptySet();
		printLabel(test_A_removeA_emptySet.getLabel());
		test_A_removeA_emptySet.run(); 
		printLine(); 
		
		Test_A_addA_A test_A_addA_A = new Test_A_addA_A();
		printLabel(test_A_addA_A.getLabel());
		test_A_addA_A.run(); 
		printLine(); 
		
		Test_A_addB_AB test_A_addB_AB = new Test_A_addB_AB();
		printLabel(test_A_addB_AB.getLabel());
		test_A_addB_AB.run(); 
		printLine(); 
		
		Test_AB_removeA_B test_AB_removeA_B = new Test_AB_removeA_B();
		printLabel(test_AB_removeA_B.getLabel());
		test_AB_removeA_B.run(); 
		printLine(); 
		
		Test_AB_removeB_A test_AB_removeB_A = new Test_AB_removeB_A();
		printLabel(test_AB_removeB_A.getLabel());
		test_AB_removeB_A.run(); 
		printLine(); 
		
		Test_AB_addC_ABC test_AB_addC_ABC = new Test_AB_addC_ABC();
		printLabel(test_AB_addC_ABC.getLabel());
		test_AB_addC_ABC.run(); 
		printLine(); 
		
		Test_ABC_removeA_BC test_ABC_removeA_BC = new Test_ABC_removeA_BC();
		printLabel(test_ABC_removeA_BC.getLabel());
		test_ABC_removeA_BC.run(); 
		printLine(); 
		
		Test_ABC_removeB_AC test_ABC_removeB_AC = new Test_ABC_removeB_AC();
		printLabel(test_ABC_removeB_AC.getLabel());
		test_ABC_removeB_AC.run(); 
		printLine(); 
		
		Test_ABC_removeC_AB test_ABC_removeC_AB = new Test_ABC_removeC_AB();
		printLabel(test_ABC_removeC_AB.getLabel());
		test_ABC_removeC_AB.run(); 
		printLine(); 
		
		Test_BigSet test_BigSet = new Test_BigSet(); 
		printLabel(test_BigSet.getLabel());
		test_BigSet.run(); 
		printLine(); 

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
				           + "Failed: %d\n", total, TOTAL_TESTS, passes, failures);
	}
	
	/**
	 * Prints label for sets of tests
	 * @param label - name of set of tests 
	 */
	private static void printLabel(String label)
	{
		System.out.println(label);		
	}

	/** 
	 * Prints line between sets of tests
	 */
	private static void printLine()
	{
		System.out.println("=======================================================");
		
	}
}
