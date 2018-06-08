package com.jj.learn;

public class SmallestWindowForText {

	public static void main(String[] args) {
		smallestWindow("timetopractice", "toc");
		smallestWindow("zoomlazapzo", "oza");
		
	}
	public static void smallestWindow(String str, String text) {
		String matchedString = null;
		boolean matched = false;
		
		int fromIndex = 0;
		int endIndex = -1;
		
		int index = 0;
		
		fromIndex = str.indexOf(text.charAt(0), fromIndex);
		
		while (fromIndex >= 0) {
			
			matched = false;
			index = fromIndex;
			for (int j = 0; j < text.length(); j ++) {
				index = str.indexOf(text.charAt(j), index);
				
				if (index == -1) {
					break;
				} else {
					index = index + 1;
					
					if (j == text.length() - 1) {
						endIndex = index;
						matched = true;
					}
				}
			}
			
			if (matched) {
				if (matchedString ==  null || matchedString.length() > (endIndex - fromIndex)) {
					matchedString = str.substring(fromIndex, endIndex);
				} 
			}
			fromIndex = str.indexOf(text.charAt(0), fromIndex + 1);
		
		} 
		System.out.println(str + "==>" + text + " " + matchedString);
	}
}
