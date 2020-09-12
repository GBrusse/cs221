/**
 * Tests for Change Scenario: [A] -> remove(A) -> [ ]
 * 
 * @author Matt T, mvail
*/
public class Test_A_removeA_emptySet
{
	// Label for tests
	private final String label = "SCENARIO: [A] -> remove(A) -> [ ]";

	/**
	 * Returns an empty set. 
	 *
	 * @return - set that contains [ ] after remove(A)
	 */
	private SimpleSet<Character> newSet()
	{
		// create start state
		SimpleSet<Character> set = new ArraySet<Character>(2); 
		set.add(SetTests.ELEMENT_A);
		// run scenario
		set.remove(SetTests.ELEMENT_A);
		return set;
	}

	/** 
	 * Run tests on scenario: [A] -> remove(A) -> [ ]
	 */
	public void run()
	{
		// result of running tests 
		boolean result; 
		
		try 
		{
			result = SetTests.add(newSet(), SetTests.ELEMENT_A, Result.NoException); 
			RunSetTests.printResults("emptySet_addA", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_A, Result.NoSuchElement);
			RunSetTests.printResults("emptySet_removeA", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_A, Result.False);
			RunSetTests.printResults("emptySet_containsA", result);
			result = SetTests.isEmpty(newSet(), Result.True);
			RunSetTests.printResults("emptySet_isEmpty", result);
			result = SetTests.size(newSet(), 0);
			RunSetTests.printResults("emptySet_size", result);
			result = SetTests.toString(newSet(), Result.ValidString);
			RunSetTests.printResults("emptySet_toString", result);

		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "Test_A_removeA_emptySet");
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
