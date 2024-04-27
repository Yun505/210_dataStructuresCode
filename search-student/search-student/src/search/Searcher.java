/*
 * Copyright 2023 Marc Liberatore.
 */

package search;

import java.util.List;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 * @author liberato
 *
 * @param <T> the type for each vertex in the search graph
 */
public class Searcher<T> {
	private final SearchProblem<T> searchProblem;

	/**
	 * Instantiates a searcher.
	 * 
	 * @param searchProblem
	 *                      the search problem for which this searcher will find and
	 *                      validate solutions
	 */
	public Searcher(SearchProblem<T> searchProblem) {
		this.searchProblem = searchProblem;
	}

	/**
	 * Finds and return a solution to the problem, consisting of a list of
	 * states.
	 * 
	 * The list should start with the initial state of the underlying problem.
	 * Then, it should have one or more additional states. Each state should be
	 * a successor of its predecessor. The last state should be a goal state of
	 * the underlying problem.
	 * 
	 * If there is no solution, then this method should return an empty list.
	 * 
	 * @return a solution to the problem (or an empty list)
	 */
	public List<T> findSolution() {
		Stack<T> frontier = new Stack<>();
		Set<T> expanded = new HashSet<>();

		LinkedList<T> path = new LinkedList<>();
		Map<T, T> predecessor = new HashMap<>();
		predecessor.put(searchProblem.getInitialState(), null);
		frontier.add(searchProblem.getInitialState());

		while (!frontier.isEmpty()) {
			T current = frontier.pop();

			if (searchProblem.isGoal(current)) {
				T curr = current;
				path.add(curr);
				while (curr != searchProblem.getInitialState()) {
					path.addFirst(predecessor.get(curr));
					curr = predecessor.get(curr);
				}

				return path;
			} else if (!expanded.contains(current)) {
				expanded.add(current);
				for (T next : searchProblem.getSuccessors(current)) {
					if (!expanded.contains(next)) {
						frontier.push(next);
						predecessor.put(next, current);
					}
				}
			}

		}
		return path;
	}

	/**
	 * Checks that a solution is valid.
	 * 
	 * THIS METHOD DOES NOT PERFORM SEARCH! It only checks if a provided solution
	 * is valid!
	 * 
	 * A valid solution consists of a list of states. The list should start with
	 * the initial state of the underlying problem. Then, it should have one or
	 * more additional states. Each state should be a successor of its
	 * predecessor. The last state should be a goal state of the underlying
	 * problem.
	 * 
	 * @param solution
	 * @return true iff this solution is a valid solution
	 * @throws NullPointerException
	 *                              if solution is null
	 */
	public final boolean isValidSolution(List<T> solution) {
		for (int i = 0; i < solution.size() - 1; i++) {
			if (searchProblem.getSuccessors(solution.get(i)).contains(solution.get(i + 1)) != true) {
				return false;
			}
		}
		if (solution.get(0).equals(searchProblem.getInitialState()) != true) {
			return false;
		}
		if (searchProblem.isGoal(solution.get(solution.size() - 1)) != true) {
			return false;
		}
		return true;
	}
}
