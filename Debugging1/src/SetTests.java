import java.util.NoSuchElementException;

/**
 * A unit test class for implementations of the SimpleSet ADT.
 * 
 * @author Matt T, mvail
 */

public class SetTests
{
	// named elements for use in tests
	public static final Character ELEMENT_A = Character.valueOf('A');
	public static final Character ELEMENT_B = Character.valueOf('B');
	public static final Character ELEMENT_C = Character.valueOf('C');
	public static final Character ELEMENT_D = Character.valueOf('D');

	/**
	 * Runs add() method on given set and checks result against expectedResult
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param element - element to add
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean add(SimpleSet<Character> set, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			set.add(element);
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "add", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs remove() method on given set and checks result against expectedResult
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param element - element to remove
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean remove(SimpleSet<Character> set, Character element, Result expectedResult)
	{
		Result result;
		try {
			Character retVal = set.remove(element);
			if (retVal.equals(element)) 
			{
				result = Result.MatchingValue;
			} else 
			{
				result = Result.Fail;
			}
		} 
		catch (NoSuchElementException e) 
		{
			result = Result.NoSuchElement;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "remove", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs contains() method on a given set and element and checks result against expectedResult
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param element - possible element in set 
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean contains(SimpleSet<Character> set, Character element, Result expectedResult)
	{
		Result result;
		try {
			if (set.contains(element)) {
				result = Result.True;
			} else {
				result = Result.False;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "contains", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs isEmpty() method on a given set and checks result against expectedResult
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean isEmpty(SimpleSet<Character> set, Result expectedResult)
	{
		Result result;
		try {
			if (set.isEmpty()) {
				result = Result.True;
			} else {
				result = Result.False;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "isEmpty", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs size() method on a given set and checks result against expectedResult
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean size(SimpleSet<Character> set, int expectedSize)
	{
		try {
			return (set.size() == expectedSize);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "size", e.toString());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Runs toString() method on given set and attempts to confirm non-default or empty String difficult
	 * to test - just confirm that default address output has been overridden
	 * 
	 * @param set - a set already prepared for a given change scenario
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean toString(SimpleSet<Character> set, Result expectedResult)
	{
		Result result;
		try {
			String str = set.toString();
			System.out.println("toString() output: " + str);
			if (str.length() == 0) {
				result = Result.Fail;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@") && !str.contains(" ") && Character.isLetter(str.charAt(0)) && (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				result = Result.Fail; // looks like default toString()
			} else {
				result = Result.ValidString;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "toString", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/** Adds 1000 elements expecting no exceptions
	 * @param expectedResult - expected return result 
	 * @return test success - whether passes test or not
	 */
	public static boolean bigSet(SimpleSet<Integer> set, Result expectedResult) 
	{
		Result result;
		try 
		{
			for (int i = 0; i < 1000; i++) 
			{
				set.add(new Integer(i));
			}
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "bigSet", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}


} // SetTests
