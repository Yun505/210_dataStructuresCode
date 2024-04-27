/*
 * Copyright 2023 Marc Liberatore.
 */

package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import search.SearchProblem;
import search.Searcher;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {

	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 * 
	 * 
	 */
	private static final int PUZZLE_SIZE = 9;
    private static final int PUZZLE_DIMENSION = 3;

	private List<Integer> startingValues;

    private List<Integer> goalState;
    private int[][] moves = {
        {1, 3}, {0, 2, 4}, {1, 5}, 
        {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8}, 
        {3, 7}, {4, 6, 8}, {5, 7}}; 

	public EightPuzzle(List<Integer> startingValues) {
		this.startingValues = startingValues;
		goalState = Arrays.asList(1,2,3,4,5,6,7,8,0);
	}

	@Override
	public List<Integer> getInitialState() {
		return this.startingValues;
		
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		List<List<Integer>> successors = new ArrayList<>();
        int emptySpaceIndex = currentState.indexOf(0);

        for (int move : moves[emptySpaceIndex]) {
            List<Integer> successor = new ArrayList<>(currentState);
            successor.set(emptySpaceIndex, currentState.get(move));
            successor.set(move, 0); // Move the empty space to the swapped position
            successors.add(successor);
        }

        return successors;
	}


	@Override
	public boolean isGoal(List<Integer> state) {
		return state.equals(this.goalState);
	}

	public static void main(String[] args) {
		EightPuzzle eightPuzzle = new EightPuzzle(Arrays.asList(new Integer[] {1, 2, 3, 4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> solution = new Searcher<List<Integer>>(eightPuzzle).findSolution();
		for (List<Integer> state : solution) {
			System.out.println(state);
		}
		System.out.println(solution.size() + " states in solution");
	}
}
