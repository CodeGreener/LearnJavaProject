package com.jj.learn;

public class PatternMatching {

	/**
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * The matching should cover the entire input string (not partial).
	 * 
	 * 
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		//base case
    	if (p.equals(".")) {
    		return s.length() == 1;
    	}
    	if (p.equals(".*")) {
    		return true;
    	}
    	if (p.length() == 2 && p.charAt(0) != '.' && p.charAt(1) == '*') {
    		return matchAllChar(s, p.charAt(0));
    	}
        int specialIndex = 0;
        specialIndex = nextIndexOfSpcial(p, specialIndex);
        
        if (specialIndex == -1) {
        	return s.equals(p);
        } else {
        	
        	char specCh = p.charAt(specialIndex);
        	switch (specCh) {
        	case '.':
        		if (specialIndex < p.length() - 1) {
        			char chAfter = p.charAt(specialIndex+1);
        			if (chAfter == '*') {
        				//any character, any length
        				if (s.length() == 0) {
        					return isMatch("", p.substring(0, specialIndex));
        				}
        				for (int i = 1; i < s.length(); i ++) {
        					if (isMatch(s.substring(0, i), p.substring(0, specialIndex))) {
        						if (specialIndex < p.length() - 2) {
        							for (int j = i+1; j < s.length(); j ++) {
            							if (isMatch(s.substring(j), p.substring(specialIndex + 2) )) {
            								return true;
            							}
            						}
        						}
        						else {
        							return true;
        						}
        					}
        						
        				}
        				return false;
        			}
        			else {
        				//any one character
        				if (s.length() == 0) {
                			return false;
                		}
                		
        				for (int i = 1; i < s.length() - 1; i ++) {
        					if (isMatch(s.substring(0, i), p.substring(0, specialIndex))) {
        						if (specialIndex < p.length() - 1) {
        							return isMatch(s.substring(i + 1), p.substring(specialIndex + 1));
        						} else {
        							if (i == s.length() - 1) {
        								return true;
        							}
        						}
        					}
        				}
        				return false;
        			}
        		} else {
        			//. is the last character in pattern
        			if (s.length() > 0) {
        				return isMatch(s.substring(0, s.length() - 1), p.substring(0, specialIndex));
        			} else {
        				return false;
        			}
        		}
        		

        	case '*':
        		char charBefore = p.charAt(specialIndex-1);		//any number of this characters
        		String restPattern = "";
				if (specialIndex < p.length() - 1) {
					restPattern = p.substring(specialIndex + 1);
				}
        		if (s.length() == 0) {
        			return isMatch(s, restPattern);
        		}
        		for (int i = 0; i < s.length(); i ++) {
        			if (isMatch(s.substring(0, i), p.substring(0, specialIndex-1))) {
        				String middlePattern = p.substring(specialIndex - 1, specialIndex + 1);
        				
        				for (int j = i; j < s.length(); j ++) {
        					if (isMatch(s.substring(i, j), middlePattern)) {
        						if (i == s.length() - 1) {
        							if (isMatch("", restPattern)) {
                						return true;
                					} 
                				}
                				else {
                					if (isMatch(s.substring(j), restPattern)) {
                						return true;
                					}
                				}
                				
        						
        					}
        				}
        			}
        		}
        		return false;
        		
        	default:
        			
        	}
        }
		return true;
    }
	
	
	public static int nextIndexOfSpcial(String p, int startFrom) {
		int dot = p.indexOf(".");
		int star = p.indexOf("*");
		
		if (dot == -1) {
			return star;
		} else if (star == -1) {
			return dot;
		} else {
			return dot < star? dot : star;
		}
	}
	
	public static boolean matchAllChar(String s, char c) {
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) != c) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "cdc";
		String p = "c*c";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "ccccccccccccc";
		p = "c*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "aa";
		p = "aa";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "aa";
		p = ".*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));

		s = "aba";
		p = "a.a";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "aba";
		p = "ab.";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "a";
		p = ".";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "ab";
		p = ".";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "aab";
		p = "c*a*b";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "";
		p = "c*a*b*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "";
		p = ".a*b*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "";
		p = ".*a*b*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "abcd";
		p = "d*";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
		
		s = "aaa";
		p = "ab*a";
		System.out.println(s + "->" + p + " " + isMatch(s, p));
	}
}
