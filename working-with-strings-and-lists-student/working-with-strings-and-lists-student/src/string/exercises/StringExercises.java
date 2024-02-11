/*
 * Copyright 2021 Marc Liberatore.
 */

package string.exercises;

public class StringExercises {
	/**
	 * Searches for "Marc" in a string.
	 * 
	 * @param string a non-null string
	 * @return the index of the first occurrence of "Marc" in string, or -1 if not
	 *         found
	 */
	public static int findMarc(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (i + 3 < string.length()) {
				if (string.substring(i, i + 4).equals("Marc")) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * Searches for a substring within a string.
	 * 
	 * @param string    a non-null string
	 * @param substring a non-null string
	 * @return the index of the first occurrence of the substring within the string,
	 *         or -1 if not found
	 */
	public static int findSubstring(String string, String substring) {

		for (int i = 0; i <= string.length() - substring.length(); i++) {
			if (string.substring(i, i + substring.length()).equals(substring)) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * Returns true if and only if the string contains the substring.
	 * 
	 * @param string    a non-null string
	 * @param substring a non-null string
	 * @return true if and only if the string contains the substring
	 */
	public static boolean contains(String string, String substring) {
		if (findSubstring(string, substring) != -1) {
			return true;
		}
		return false;
	}

	/**
	 * Splits a string into words, using whitespace to delimit the words.
	 * 
	 * See the assignment writeup for the magic argument to split().
	 * 
	 * @param string a non-null string
	 * @return an array representing the words in the string.
	 */
	public static String[] splitIntoWords(String string) {
		String[] words = string.split("\\s+");
		return words;
	}

	/**
	 * Returns the substring representing the first four characters of the string.
	 * 
	 * @param string a non-null string of length >= 4
	 * @return the substring representing the first four characters of the string
	 */
	public static String firstFour(String string) {
		String four = string.substring(0,4);
		return four;
	}

	/**
	 * Returns the substring representing the first n characters of the string.
	 * 
	 * @param string a non-null string of length >= n
	 * @param n      an integer >= 0
	 * @return the substring representing the first n characters of the string
	 */
	public static String firstN(String string, int n) {
		return string.substring(0,n);
	}

	/**
	 * Returns the substring representing the last four characters of the string.
	 * 
	 * @param string a non-null string of length >= 4
	 * @return the substring representing the last four characters of the string
	 */
	public static String lastFour(String string) {
		return string.substring(string.length()-4);
	}

	/**
	 * Returns the substring representing the last n characters of the string.
	 * 
	 * @param string a non-null string of length >= n
	 * @param n      an integer >= 0
	 * @return the substring representing the last n characters of the string
	 */
	public static String lastN(String string, int n) {
		return string.substring(string.length()-n);
	}
}
