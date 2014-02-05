package com.jayasagar.ds.curious.mis;

import java.util.HashSet;

public class FirstNNaturalNumbers {
	// Holds previous natural numbers 
	private static HashSet<Integer> previousNaturalNumbers = new HashSet<Integer>();

	public static void main(String[] args) {
		// first 1500 natural numbers whose factor(s) is/are either ONLY 2, 3, or 5.

		// change n to any number. 
		int n = 1500;
		
		// Take count to know whether we reached 1500 ?
		int count = 4;
		previousNaturalNumbers.add(2);
		previousNaturalNumbers.add(4);
		previousNaturalNumbers.add(3);
		previousNaturalNumbers.add(5);
		
		int nextNumber = 6;
		
		while (true) {
			
			boolean isNaturalNumber = isNaturalNumber(nextNumber);
			if (isNaturalNumber) {
				previousNaturalNumbers.add(nextNumber);
				count++;
			}
			
			// Stop loop when we got first 1500 natural numbers.
			if (count >= n) {
				break;
			}
			nextNumber++;
		}
		
		System.out.println(previousNaturalNumbers);
	}

	private static boolean isNaturalNumber(int number) {
		if (number % 2 == 0 && previousNaturalNumbers.contains(number/2)) {
			return true;
		} else if (number % 3 == 0 && previousNaturalNumbers.contains(number/3)) {
			return true;
		} else if (number % 5 == 0 && previousNaturalNumbers.contains(number/5)) {
			return true;
		}
		
		return false;
	}

}
