/**
 * Tests for Change Scenario: empty set -> add(A) -> [A]
 * 
 * @author Matt T, mvail
*/
public class Test_emptySet_addA_A
{
	// Label for tests
	private final String label = "SCENARIO: [ ] -> add(A) -> [A]";

	/**
	 * Returns a SimpleSet with one element A. 
	 *
	 * @return - set that contains [A] after add(A)
	 */
	private SimpleSet<Character> newSet()
	{
		// create start state
		SimpleSet<Character> set = new ArraySet<Character>(2); 
		// run scenario
		set.add(SetTests.ELEMENT_A);
		return set;
	}

	/** 
	 * Run tests on scenario: empty set -> add(A) -> [A]
	 */
	public void run()
	{
		// result of running tests 
		boolean result; 
		
		try 
		{
			result = SetTests.add(newSet(), SetTests.ELEMENT_A, Result.NoException); 
			RunSetTests.printResults("emptySet_addA_A_addA", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_A, Result.MatchingValue);
			RunSetTests.printResults("emptySet_addA_A_removeA", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_B, Result.NoSuchElement);
			RunSetTests.printResults("emptySet_addA_A_removeB", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_A, Result.True);
			RunSetTests.printResults("emptySet_addA_A_containsA", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_B, Result.False);
			RunSetTests.printResults("emptySet_addA_A_containsB", result);
			result = SetTests.isEmpty(newSet(), Result.False);
			RunSetTests.printResults("emptySet_addA_A_isEmpty", result);
			result = SetTests.size(newSet(), 1);
			RunSetTests.printResults("emptySet_addA_A_size", result);
			result = SetTests.toString(newSet(), Result.ValidString);
			RunSetTests.printResults("emptySet_addA_A_toString", result);

		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "Test_emptySet_addA_A");
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
