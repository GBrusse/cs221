import java.util.Iterator;

/**
 * Testing for IndexedUnsortedList interface implementation: 
 * Iterator Tests for Change Scenario 15: [A] -> remove(0) -> [ ]
 *
 * @author Matt T
 *
 */
public class ItrTest_15_A_remove0_emptyList
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	// Iterator list to run tests 
	private Iterator<Character> itr; 
		
	//****** Constants used in tests *****************
	// Name of class
	private static String CLASS_NAME = "ItrTest_15_A_remove0_emptyList"; 
	// Description of change scenario testing 
	private static final String testDescription = 
			"Change Scenario 15: [A] -> remove(0) -> [ ]"; 
	// Number of tests run 
	private static final int NUM_TESTS = 3; 
	// Type of list using in tests
	private ListType listType; 
	// State of iterator 
	private ItrState itrState; 

	// Element not in list - used for negative testing 
	private static final Character INVALID_ELEMENT = IteratorTests.F;
	
	/**
	 * Sets up iterator for testing. 
	 */
	public void initialize()
	{
		// create an empty list 
		list = IteratorTests.newList(listType);
		// initialize list
		list.add(IteratorTests.A);
		// apply change
		list.remove(0); 
		
		// initialize iterator to given state
		itr = IteratorTests.initItr(list, itrState);
	}
		
	/** 
	 * Run tests for this change scenario 
	 */
	public void run(ListType listType)
	{
		// set type of list running tests on 
		this.listType = listType; 

		// result of running tests 
		boolean result; 
		
		try 
		{
			//********* Iterator State: initial position 
			System.out.println("Iterator State: initial position");
			// initial iterator state
			itrState = ItrState.init;

			// hasNext Test
			initialize(); 
			result = IteratorTests.hasNext(itr, Result.False); 
			RunIteratorTests.printResults("hasNext()", result);		

			// next Test
			initialize(); 
			result = IteratorTests.next(itr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunIteratorTests.printResults("next()", result);

			// remove Test
			initialize(); 
			result = IteratorTests.remove(itr, Result.IllegalState); 
			RunIteratorTests.printResults("remove()", result);
				
		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", CLASS_NAME);
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns test description 
	 * @return testDescription - description of test
	 */
	public String getDescription()
	{
		return testDescription;
	}
	
	/**
	 * Returns number of tests in this test class 
	 * @return - int representing number of tests 
	 */
	public int getNumTests()
	{
		return NUM_TESTS; 
	}

}
