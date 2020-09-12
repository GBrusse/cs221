/**
 * Tests for Change Scenario: [A,B,C] -> remove(B) -> [A,C]
 * 
 * @author Matt T, mvail
*/
public class Test_ABC_removeB_AC
{
	// Label for tests
	private final String label = "SCENARIO: [A,B,C] -> remove(B) -> [A, C]";

	/**
	 * Returns a SimpleSet with two elements A and C. 
	 *
	 * @return - set that contains [A, C] after remove(B)
	 */
	private SimpleSet<Character> newSet()
	{
		// create start state
		SimpleSet<Character> set = new ArraySet<Character>(2); 
		set.add(SetTests.ELEMENT_A);
		set.add(SetTests.ELEMENT_B);
		set.add(SetTests.ELEMENT_C);
		// run scenario
		set.remove(SetTests.ELEMENT_B);
		return set;
	}

	/** 
	 * Run tests on scenario: [A,B,C] -> remove(B) -> [A,C]
	 */
	public void run()
	{
		// result of running tests 
		boolean result; 
		
		try 
		{
			result = SetTests.add(newSet(), SetTests.ELEMENT_A, Result.NoException); 
			RunSetTests.printResults("emptySet_addA_A_addA", result);
			result = SetTests.add(newSet(), SetTests.ELEMENT_B, Result.NoException); 
			RunSetTests.printResults("emptySet_addA_A_addB", result);
			result = SetTests.add(newSet(), SetTests.ELEMENT_C, Result.NoException); 
			RunSetTests.printResults("emptySet_addA_A_addC", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_A, Result.MatchingValue);
			RunSetTests.printResults("emptySet_addA_A_removeA", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_B, Result.NoSuchElement);
			RunSetTests.printResults("emptySet_addA_A_removeB", result);
			result = SetTests.remove(newSet(), SetTests.ELEMENT_C, Result.MatchingValue);
			RunSetTests.printResults("emptySet_addA_A_removeC", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_A, Result.True);
			RunSetTests.printResults("emptySet_addA_A_containsA", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_B, Result.False);
			RunSetTests.printResults("emptySet_addA_A_containsB", result);
			result = SetTests.contains(newSet(), SetTests.ELEMENT_C, Result.True);
			RunSetTests.printResults("emptySet_addA_A_containsC", result);
			result = SetTests.isEmpty(newSet(), Result.False);
			RunSetTests.printResults("emptySet_addA_A_isEmpty", result);
			result = SetTests.size(newSet(), 2);
			RunSetTests.printResults("emptySet_addA_A_size", result);
			result = SetTests.toString(newSet(), Result.ValidString);
			RunSetTests.printResults("emptySet_addA_A_toString", result);

		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "Test_ABC_removeB_AC");
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
