package com.jj.learn.api;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

public class TreeMapTest {
	 public static void main(String args[]) {

	      /* This is how to declare TreeMap */
	      TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

	      /*Adding elements to TreeMap*/
	      tmap.put(1, "Data1");
	      tmap.put(23, "Data2");
	      tmap.put(70, "Data3");
	      tmap.put(4, "Data4");
	      tmap.put(2, "Data5");

	      /* Display content using Iterator*/
	      Set<Map.Entry<Integer,String>> set = tmap.entrySet();
	      Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }

	      
	      System.out.println("==== sort by value ===");
	      Map<Integer, String> smap = sortByValues(tmap);
	      /* Display content using Iterator*/
	      Set<Map.Entry<Integer,String>> set2 = smap.entrySet();
	      Iterator<Map.Entry<Integer, String>> iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator2.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }
	   }
	 
	 public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = new Comparator<K>() {
		      public int compare(K k1, K k2) {
			        int compare = map.get(k1).compareTo(map.get(k2));
			        
			        return compare;
			        /*
			        if (compare == 0) 
			          return 1;
			        else 
			          return compare;
			          */
		      }
	    };
	 
	    Map<K, V> sortedByValues = 
	      new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    
	    return sortedByValues;
	  }
}
