/* Brace Expansion 

Example of Backtracking


Given an input string in the format String s = "abc{d,e}f{gh,ij}".
Expected output: [abcdfgh, abcdfij, abcefgh, abcefij]
This is exact output of echo abc{d,e}f{gh,ij} on a bash terminal. Braces can be nested.

*/

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string");
		String s = br.readLine();
		List<String> list;
		list = braceExpansion(s);
		System.out.println(list);
	}
	public static List<String> braceExpansion(String s)
	{
		// declare result type
		List<String> result = new ArrayList<>();

		// string to build a new string
		String str = "";
		// call backtrack
		backtrack(result, s, str, 0);
		// return result
		return result;
	}

	public static void backtrack(List<String> result, String s, String str, int i)
	{

		int count = 0;
		for(int j = i; j < s.length(); j++)
		{
			char x = s.charAt(j);
			// if its not a brace, add it
			if(x != '{' && x!=','){
				str = str + x;
			}
			// the moment I encounter a brace
			else
			{
				// get index of end brace starting from current position
				int end = s.indexOf('}', j); 

				// build selection list
				String parts[] = s.substring(j+1, end).split(",");
				int len = parts.length;

				// iterate through selection list trying different possibilities through backtrack
				for(String string: parts){
					// keep track of how many parts explored
					count ++;
					// add item to selection list if it isn't already there
					str = str + string;
					// build decision tree on each element of selection list starting with the remaining sequence after end brace
					backtrack(result, s, str, end+1);
					// shrink the built string by new added string length and add back to selection list
					str = str.substring(0, str.length()-string.length());
				}
				// terminate as soon as you explore all parts
				if(count == len){
					return;
				}
			}
		}
		// add string to result
		result.add(str);
	}
}