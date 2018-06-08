package com.jj.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AmazonSeattle {

	public static void main(String[] args) {
		
		/*
		List<String> what = new AmazonSeattle().subStringsLessKDist("awaglk", 4);
		System.out.println(what);
		
		List<String> what2 = new AmazonSeattle().subStringsLessKDist("democracy", 5);
		System.out.println(what2);
		*/
		
		AmazonSeattle a = new AmazonSeattle();
		
		Character[] list = {'a', 'b', 'c'};
		System.out.println(Arrays.toString(list) + a.lengthEachScene(Arrays.stream(list).collect(Collectors.toList())));
		
		
		Character[] list2 = {'a', 'b', 'c', 'a', 'a', 'c','a', 'a', 'c', 'c','c','e'};
		System.out.println(Arrays.toString(list2) + a.lengthEachScene(Arrays.stream(list2).collect(Collectors.toList())));
		
		Character[] list3 = {'a', 'b', 'c', 'd', 'd', 'd', 'd', 'c', 'e'};
		System.out.println(Arrays.toString(list3) + a.lengthEachScene(Arrays.stream(list3).collect(Collectors.toList())));
		
		Character[] list4 = {'a', 'c', 'd', 'a', 'd', 'd', 'd', 'c', 'e'};
		System.out.println(Arrays.toString(list4) + a.lengthEachScene(Arrays.stream(list4).collect(Collectors.toList())));
	}
	
	 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsLessKDist(String inputString, int num)
	{
        // WRITE YOUR CODE HERE
    	
    	List<String> result = new ArrayList<String>();
        
        for (int i = 0; i <= inputString.length() - num; i ++)  {
            String subStr = inputString.substring(i,  num + i);
            //System.out.println(subStr);
            
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            String repeatedLetter = null;
            boolean found = true;
            for (int j = 0; j < subStr.length(); j ++) {
            	String s = String.valueOf(subStr.charAt(j));
            	if (map.containsKey(s)) {
            		if (repeatedLetter == null) {
            			repeatedLetter = s;
            		} else {
            			found = false;
            			break;
            		}
            	} else {
            		map.put(String.valueOf(subStr.charAt(j)), null);
            	}
            }
            if (found && repeatedLetter != null) {
            	result.add(subStr);
            }
            
        }
        
        return result;
    }
    
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
    	
    	ArrayList<Integer> r = breakDownScence(inputList);
    	return r;
    }
    
    /**
     * segment of characters: begin and end with same character.
     * 
     * Break down a list of characters with fewest segments. each segment has the same beginning and ending letter. return array of length of each segment.
     * For example, 'abca' returns [4]; 'abcad' returns [4, 1]; 'abcddddce' returns [1,1,6,1]
     * 
     * @param inputList
     * @return
     */
    ArrayList<Integer> breakDownScence(List<Character> inputList) {
    	//base case
    	if (inputList.size() == 0) {
    		return new ArrayList<Integer>();
    	}
    	else if (inputList.size() == 1) {
    		ArrayList<Integer> r = new ArrayList<Integer>();
    		r.add(1);
    		return r;
    	}
    	
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<Integer> minResult = null;
    	
    	int fromCharacterIndex = 0;
    	Character firstChar = inputList.get(fromCharacterIndex);
    	//int nextOccurIndex = this.findNextIndexOfCharacter(inputList, firstChar, fromCharacterIndex + 1);
    	int nextOccurIndex = 0;	//start with one character
    	
    	while (fromCharacterIndex < inputList.size()) {
    		result = new ArrayList<Integer>();
    		
    		if (nextOccurIndex == -1) {
        		result.add(1);
        		List<Character> restOfTheList = new ArrayList<Character>();
        		for (int i = 1; i < inputList.size(); i ++) {
        			restOfTheList.add(inputList.get(i));
        		}
        		
        		List<Integer> rest = breakDownScence(restOfTheList);
        		if (rest != null) {
        			result.addAll(rest);
        		}
        		
        		if (minResult == null || minResult.size() > result.size()) {
        			minResult = result;
        		}
        		break;
        	} else {
        		result.add(nextOccurIndex + 1);
        		List<Character> restOfTheList = new ArrayList<Character>();
        		for (int i = nextOccurIndex + 1; i < inputList.size(); i ++) {
        			restOfTheList.add(inputList.get(i));
        		}
        		
        		List<Integer> rest = breakDownScence(restOfTheList);
        		if (rest != null) {
        			result.addAll(rest);
        		}
        		
        		
        		fromCharacterIndex = nextOccurIndex + 1;
        		nextOccurIndex = this.findNextIndexOfCharacter(inputList, firstChar, fromCharacterIndex);
        		

        		if (minResult == null || minResult.size() > result.size()) {
        			minResult = result;
        		}
        		
        	}
    	}
    	
    	return minResult;
    }
    
    int findNextIndexOfCharacter(List<Character> list, Character c, int startFrom) {
    	for (int i = startFrom; i < list.size(); i ++) {
    		if (list.get(i).charValue() == c.charValue()) {
    			return i;
    		}
    	}
    	
    	//not found
    	return -1;
    }
}
