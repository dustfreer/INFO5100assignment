package assignment6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Assignment6 {
	/*
	 * II, Write two differences between ArrayList and LinkedList. 
	 * Designed by Kai Tian;
	 * 1.Users can use index of ArrayList to easily locate data, 
	 * while for LinkedList, users need to iterate LinkedList from front to back until find the data.
	 * 2.Insert and remove operation for LinkedList is easy and efficient because users only need to add or remove their
	 * next node. However, for arrayList these operations are complex since users needs to shift all data after the data which needs to be modified.
	 *  
	 */
	
	/*
	 * III, Given two strings s and t , write a function to determine if t is an anagram of s. (
	 * Designed by Kai Tian;
	 */
	public boolean isAnagram(String s, String t) {
		if ( s.length() != t.length() ) return false;		
		if ( s.length()== 0 || t.length() == 0) return true;

		Map<Character, Integer> map = new HashMap<Character, Integer>(); 
		
		for ( int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ( !map.containsKey(ch) ) map.put(ch, 1);
			else map.put(ch,map.get(ch)+1);
		}
		for ( int i = 0; i < t.length(); i++ ) {
			char ch = t.charAt(i);
			if ( !map.containsKey(ch)) return false;
			else {
				map.put(ch, map.get(ch)-1);
			}
		}
		for ( Map.Entry<Character, Integer> entry : map.entrySet()) {
			if ( entry.getValue() != 0)
				return false;
		}
		return true;
	 }
	
	/*
	 * IV, write a function that returns true if and only if the number of occurrences of each value in the array is unique. (Score 1)
	 * Designed by Kai Tian;
	 */
	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
		for ( int i = 0; i < arr.length; i++) {
			if ( !map.containsKey(arr[i])) map.put(arr[i], 1);
			else map.put(arr[i], map.get(arr[i])+1);
		}
		for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if ( !temp.containsValue(value)) temp.put(key, value);
			else return false;
		}
		return true;
	}
	
	/*
	 * V, Design a HashMap without using any built-in hash table libraries. 
	 * Designed by Kai Tian;
	 */
	static class MyHashMap {
		int[] arr = new int[1000001];
	    public MyHashMap() {
	        for ( int i = 0; i < arr.length; i++) arr[i] = -1;
	    }
	    
	    public void put(int key, int value) {
	        arr[key] = value;
	    }
	    
	    public int get(int key) {
	        return arr[key];
	    }
	    
	    public void remove(int key) {
	        arr[key] = -1;
	    }
	}
	
	public static void main(String[] args) {
		
	}
}
