package com.jj.learn.api;

import java.util.*;
import java.util.stream.Collectors;

public class ATest {
	public static void main(String[] args) {
        int[] testData = {1,4,3,5,2,7,6};
        ArrayList<Integer> result  = kAwayAlmostSorted(testData, 3);
        
        Iterator<Integer> it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        String testString = "aaabacaab";
        		
        int index = findFirstNonRepeatedCharacter(testString);
        if (index == -1) {
        	System.out.println("not found");
        } else {
        	System.out.println(testString + " @" + index);
        	
        }
        
        
        testString = "aaaaaaaaafghaaaaaaabbbbbbbbbbbccccccccccccccccbbbbbbbbbbbbbbb6";
		
        index = findFirstNonRepeatedCharacter(testString);
        if (index == -1) {
        	System.out.println("not found");
        } else {
        	System.out.println(testString + " @" + index);
        	
        }
        
        char[] allChars = findAllCharactersInString(testString);
        System.out.println(Arrays.toString(allChars));
        
        methodA();
        
        findAllCharactersInString2(testString);
    }
    
	public static void methodA() {
		
		NavigableMap<String, Object> smap = new TreeMap<>();
		
		smap.put("c", 'c');
		smap.put("a", null);
		smap.put("b", 1);
		smap.put("z", "zzzzentry");
		smap.put("d", "whatd");
		smap.put("f", 45);
		smap.put("p", "whatd");
		smap.put("m", 45);
		
		//retrieve values in key order
		System.out.println("values:");
		Iterator<Object> values = smap.values().iterator();
		while (values.hasNext()) {
			System.out.println(values.next());
		}
		
		System.out.println("keys:");
		Iterator<String> keys = smap.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(keys.next());
		}
		
		System.out.println("submap from c to p non inclusive:");
		NavigableMap<String, Object> nmap = smap.subMap("c", true, "p", false);
		keys = nmap.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(keys.next());
		}
		
		
	}
	public static int findFirstNonRepeatedCharacter(String input) {

	    if (input == null || input.equals("")) {
	        return -1;
	    }
	    
	    char[] chars = input.toCharArray();
	    
	    //character and its index of first occurrence in string; repeated char will have index of -1
	    LinkedHashMap<Character, Integer> charIndexMap = new LinkedHashMap<>();
	    
	    for (int i = 0; i < chars.length; i ++) {
	    	char ch = chars[i];
	        Character chObject = new Character(ch);
	        
	        if (!charIndexMap.containsKey(chObject)) {
	        	
	        	charIndexMap.put(chObject, new Integer(i));
	        } else {
	        	charIndexMap.put(chObject, -1);
	        }
	        
	    }
	    
	    Iterator<Integer> it = charIndexMap.values().iterator();
	    while (it.hasNext()) {
	    	Integer pos = it.next();
	    	if (pos.intValue() != -1) {
	    		return pos;
	    	}
	    }
	    
	    return -1;

	}
	
	//preserve order
	public static char[] findAllCharactersInString(String input) {
		char[] chars = input.toCharArray();
		
		LinkedHashSet<Character> map = new LinkedHashSet<>();
		
		for (char c : chars) {
			map.add(new Character(c));
		}
		
		char[] result = new char[map.size()];
		Iterator<Character> it = map.iterator();
		for (int i = 0; i < result.length; i ++) {
			result[i] = it.next();
		}
		
		return result;
	}
	
	
	public static void findAllCharactersInString2(String input) {
		String joined = input.chars().distinct().mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining());
		System.out.println(joined);
	}
	public static ArrayList<Integer> kAwayAlmostSorted(int[] data, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0;i < k + 1; i ++) {
            q.offer(data[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int index = k + 1;
        while (!q.isEmpty() && index < data.length) {
            result.add(q.poll());
            q.offer(data[index]);
            index ++;
        }
        
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        
        return result;
    }
}
