// JAVA CODE FOR INTERVIEW CODING QUESTIONS
// *Not meant to compile
// Sam Kececi - August 2017

// Arrays: Left Rotation
public static int[] rotateArray(int[] arr, int d){
    // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
    int n = arr.length;

    // Create new array for rotated elements:
    int[] rotated = new int[n]; 

    // Copy segments of shifted elements to rotated array:
    System.arraycopy(arr, d, rotated, 0, n - d);
    System.arraycopy(arr, 0, rotated, n - d, d);

    return rotated;
}

// Determine if a LinkedList has a cycle
boolean hasCycle(Node head) {
    Node fast = head;
    
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        head = head.next;
        
        if(head.equals(fast)) {
            return true;
        }
    }
    return false;
}

/* Convert a String to the desired base 
(i.e. base 10, hexadecimal, binary, etc.*/
public in convertToBase(String number, int base) {
	if (base <2 || (base > 10 && base != 16)) return -1; //invalid base
	int val = 0;
	for (int i = number.length() - 1; i >= 0; i--) {
		int digit = Integer.parseInt(number.charAt(i));
		if (digit < 0 || digit >= base) {
			return -1; // invalid input
		}
		int exp = number.length() - 1 - i;
		val += digit * Math.pow(base, exp);
	}
	return val;
}

// Find the median of two sorted arrays.

// ANSWER: Find the sizes of the two arrays, 
// and then do a merge sort until we reach the number that 
// indicates the median of the two arrays.

int ReturnMedianOfTwoArrays(vector<int> a, vector<int> b) {
	if (a.empty() && b.empty()) {
		return 0;
	} 
	else if (a.empty()) {
		int median_idx = (b.size() - 1) / 2.0;
		if (b.size() % 2 == 0) {
			return (b[median_idx] + b[++median_idx]) / 2;
		} else {
			return b[median_idx];
		}
	} 
	else if (b.empty()) {
		int median_idx = (a.size() - 1) / 2.0;
		if (a.size() % 2 == 0) {
			return (a[median_idx] + a[++median_idx]) / 2;
		} else {
			return a[median_idx];
		}
	}

	int total_size = a.size() + b.size();
	int median_idx = ceil((total_size - 1) / 2.0);
	int a_idx = 0;
	int b_idx = 0;
	int previous_median;
	int median;
	for (int i = 0; i <= median_idx; ++i) {
		int a_value;
		int b_value;
		previous_median = median;
		if (!a.empty()) { 
			a_value = a[a_idx];
		} 
		else {
			median = b[++b_idx];
	
		} 
		if (!b.empty()) { 
			b_value = b[b_idx];
		} 
		else {
			median = a[++a_idx]’
		}
		if (a_value <= b_value) {
			median = a_value;
			a_idx++;
		} else {
			median = b_value;
			b_idx++;
		}
			}
			if (total_size % 2 == 0) {
				return (median + previous_median) / 2;
			} else {
			return median;
			}
		}


/* CRACKING THE CODING INTERVIEW QUESTIONS */
// Part 1: Arrays and Strings

// 1.1: Determine if a string has all unique characters
public boolean uniqueChars(String s) {
	ArrayList<Characters> chars = new ArrayList<>();
	for (int i = 0; i <s.length; i++) {
		if (chars.contains(s.charAt(i))) {
			return false;
		}
		else {
			chars.add(s.charAt(i));
		}
	}
	return true;
}

// without ArrayList
public static boolean isUniqueChars2(String str) {
	if (str.length() > 128)
	// ASCII = 256 chars
	// Unicode = 128
	{
		return false;
	}
	boolean[] char_set = new boolean[128];
	for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i);
		if (char_set[val]) return false;
		char_set[val] = true;
	}
	return true;
}

// 1.3: Given two strings, write a method to decide if one is a permutation of the other.
// Ask whether case-sensitive and whether whitespace matters
public boolean permutation(String s1, String s2) {
	if (s1.length != s2.length) return false;
	Hashmap<Character, Integer> chars1 = new Hashmap<>();
	for (int i = 0; i <s1.length; i++) {
		char c = s1.charAt(i);
		if (chars1.contains(c) {
			chars1.put(c, (chars1.get(c) + 1));
		}
		else {
			chars1.put(c, 1);
			// if it does not contain the character
			// make a new key with a value of 1
		}
	}
	// go through the second string and for each character, 
	// look up the hash table and decrement the number if it is greater than zero. 
	// If you don't find an entry or if it is already 0, the strings are not a permutation of each other
	for (int j = 0; k < s2.length; j++) {
		char c2 = s2.charAt(c2);
		if (!chars1.contains(c2) || chars1.get(c2) < 1) {
			return false;
		}
		else {
			chars.put(c2, chars.get(c2) - 1);
		}
		return true;
	}
}



