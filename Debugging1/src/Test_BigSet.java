/**
 * Tests a set with 1000 elements. 
 * 
 * @author Matt T, mvail
*/
public class Test_BigSet
{
	// Label for tests
	private final String label = "SCENARIO: [] -> add 1000 elements";

	/**
	 * Returns a SimpleSet with 1000 elements. 
	 *
	 * @return - set that contains 1000 elements
	 */
	private SimpleSet<Integer> newSet()
	{
		// create empty set
		SimpleSet<Integer> set = new ArraySet<Integer>(2); 
		return set;
	}

	/** 
	 * Run tests on scenario: empty_addManyElements_bigSet
	 */
	public void run()
	{
		// result of running tests 
		boolean result; 
		
		try
		{
			result = SetTests.bigSet(newSet(), Result.NoException); 
			RunSetTests.printResults("empty_addManyElements_bigSet", result);
		}
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "Test_BigSet");
			e.printStackTrace();
		}

	}

	/**
	 * Returns test label 
	 * @return label - name of the set of tests
	 */
	public String getLabel()
	{
		return label;
	}

}
