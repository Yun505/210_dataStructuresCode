/*
 * Copyright 2021 Marc Liberatore.
 */

 package sequencer;

 import java.util.ArrayList;
 import java.util.List;
 
 public class Assembler {
 
	 /**
	  * Creates a new Assembler containing a list of fragments.
	  * 
	  * The list is copied into this assembler so that the original list will not be
	  * modified by the actions of this assembler.
	  * 
	  * @param fragments
	  * 
	  */
	 private List<Fragment> fragments = new ArrayList<Fragment>();
 
 
	 public Assembler(List<Fragment> fragments) {
		 for (Fragment fragment: fragments){
			 this.fragments.add(fragment);
		 }
		 // this.fragments = new ArrayList<>(fragments);
	 }
 
	 /**
	  * Returns the current list of fragments this assembler contains.
	  * 
	  * @return the current list of fragments
	  */
	 public List<Fragment> getFragments() {
		 return fragments;
	 }
 
	 /**
	  * Attempts to perform a single assembly, returning true iff an assembly was
	  * performed.
	  * 
	  * This method chooses the best assembly possible, that is, it merges the two
	  * fragments with the largest overlap, breaking ties between merged fragments by
	  * choosing the shorter merged fragment.
	  * 
	  * Merges must have an overlap of at least 1.
	  * 
	  * After merging two fragments into a new fragment, the new fragment is inserted
	  * into the list of fragments in this assembler, and the two original fragments
	  * are removed from the list.
	  * 
	  * @return true iff an assembly was performed
	  */
	 public boolean assembleOnce() {
		 boolean assemblyPerformed = false;
 
		 for (int i = 0; i < fragments.size(); i++) {
			 for (int j = i + 1; j < fragments.size(); j++) {
				 Fragment one = fragments.get(j);
				 Fragment two = fragments.get(i);
				 int overlap = one.calculateOverlap(two);
	 
				 if (overlap > 0) {
					 Fragment merged = one.mergedWith(two);
					 fragments.remove(one);
					 fragments.remove(two);
					 fragments.add(merged);
					 assemblyPerformed = true;
					 break;
				 }
			 }
			 if (assemblyPerformed) {
				 break;
			 }
		 }
		 return assemblyPerformed;
	 }
	 
 
	 // public boolean assembleOnce() {
	 // 	int[] assembly = new int[3];
 
	 // 	assembly[2] = Integer.MAX_VALUE;
 
	 // 	for (int i = 0; i < fragments.size(); i++) {
	 // 		for (int j = i + 1; j < fragments.size(); j++) {
	 // 			int one = this.fragments.get(i).calculateOverlap(this.fragments.get(j));
	 // 			int two = this.fragments.get(j).calculateOverlap(this.fragments.get(i));
 
	 // 			if (one > assembly[2]) {
	 // 				assembly[0] = i;
	 // 				assembly[1] = j;
	 // 				assembly[2] = one;
	 // 			}
 
	 // 			if (two > assembly[2]) {
	 // 				assembly[0] = j;
	 // 				assembly[1] = i;
	 // 				assembly[2] = two;
	 // 			}
	 // 		}
	 // 	}
 
	 // 	if (assembly[2] >= 1){
	 // 		this.fragments.add(this.fragments.get(assembly[0]).mergedWith(this.fragments.get(assembly[1]) ) );
 
	 // 		if (assembly[0] < assembly[1]){
	 // 			this.fragments.remove(this.fragments.get(assembly[0]));
	 // 			this.fragments.remove(this.fragments.get(assembly[1] -1));
 
	 // 		}
	 // 		else{
	 // 			this.fragments.remove(this.fragments.get(assembly[1]));
	 // 			this.fragments.remove(this.fragments.get(assembly[0] -1 ));
	 // 		}
	 // 		return true;
	 // 	}
	 // 	return false;
	 // }
 
	 // /**
	 //  * Repeatedly assembles fragments until no more assembly can occur.
	 //  */
	 public void assembleAll() {
		 boolean assemblyPerformed = true;
 
		 while (assemblyPerformed) {
			 assemblyPerformed = assembleOnce();
		 }
	 }
 }
 