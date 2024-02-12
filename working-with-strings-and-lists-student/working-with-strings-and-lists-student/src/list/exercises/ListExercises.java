/*
 * Copyright 2021 Marc Liberatore.
 */

package list.exercises;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

	/**
	 * Counts the number of characters in total across all strings in the supplied
	 * list;
	 * in other words, the sum of the lengths of the all the strings.
	 * 
	 * @param l a non-null list of strings
	 * @return the number of characters
	 */
	public static int countCharacters(List<String> l) {
		int count = 0;
		for (int i = 0; i < l.size(); i++) {
			count += l.get(i).length();
		}
		return count;
	}

	/**
	 * Splits a string into words and returns a list of the words.
	 * If the string is empty, split returns a list containing an empty string.
	 * 
	 * @param s a non-null string of zero or more words
	 * @return a list of words
	 */
	public static List<String> split(String s) {
		List<String> words = new ArrayList<>();
		String word = "";

		if (s.length() == 0) {
			words.add("");
			return words;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			// If the character is not whitespace, add it to the current word
			if (!Character.isWhitespace(ch)) {
				word += ch;
			} else {
				// If the current word is not empty, add it to the list of words
				if (word.length() > 0) {
					words.add(word.toString());
					word = ""; 
				}
			}
		}

		// Add the last word if it's not empty
		if (word.length() > 0) {
			words.add(word.toString());
		}

		return words;
	}

	/**
	 * Returns a copy of the list of strings where each string has been
	 * uppercased (as by String.toUpperCase).
	 * 
	 * The original list is unchanged.
	 * 
	 * @param l a non-null list of strings
	 * @return a list of uppercased strings
	 */
	public static List<String> uppercased(List<String> l) {
		List<String> a = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			a.add(l.get(i).toUpperCase());
		}
		return a;
	}

	/**
	 * Returns true if and only if each string in the supplied list of strings
	 * starts with an uppercase letter. If the list is empty, returns false.
	 * 
	 * @param l a non-null list of strings
	 * @return true iff each string starts with an uppercase letter
	 */
	public static boolean allCapitalizedWords(List<String> l) {
		if (l.isEmpty()) {
			return false;
		}
		for (String word : l) {
			if (word.isEmpty() || !Character.isUpperCase(word.charAt(0))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a list of strings selected from a supplied list, which contain the
	 * character c.
	 * 
	 * The returned list is in the same order as the original list, but it omits all
	 * strings
	 * that do not contain c.
	 * 
	 * The original list is unmodified.
	 * 
	 * @param l a non-null list of strings
	 * @param c the character to filter on
	 * @return a list of strings containing the character c, selected from l
	 */
	public static List<String> filterContaining(List<String> l, char c) {
		List<String> a = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).contains(Character.toString(c))) {
				a.add(l.get(i));
			}
		}
		return a;
	}

	/**
	 * Inserts a string into a sorted list of strings, maintaining the sorted
	 * property of the list.
	 * 
	 * @param s the string to insert
	 * @param l a non-null, sorted list of strings
	 */
	public static void insertInOrder(String s, List<String> l) {
		int index = 0;

		// Find the correct position to insert the string
		while (index < l.size() && s.compareTo(l.get(index)) > 0) {
			index++;
		}

		// Insert the string at the correct position
		l.add(index, s);
	}
}
