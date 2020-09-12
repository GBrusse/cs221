/**
 * Tests for Change Scenario: no set -> constructor -> [ ]
 * 
 * @author Matt T, mvail
*/
public class Test_emptySet
{
	// Label for tests
	private final String label = "NEW EMPTY SET";

	/**
	 * Returns a SimpleSet for the "new empty set" scenario. Scenario: no set -> constructor -> [ ]
	 *
	 * @return a new, empty SimpleSet
	 */
	private SimpleSet<Character> newSet()
	{
		// create empty set
		return new ArraySet<Character>(2); // intentionally set small enough to exercise set growth
	}

	/** 
	 * Run tests on scenario: no set -> constructor -> [ ]
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
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "Test_emptySet");
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
