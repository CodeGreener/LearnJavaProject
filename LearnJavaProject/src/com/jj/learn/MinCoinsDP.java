package com.jj.learn;

public class MinCoinsDP {
	
	public static void main(String[] args) {
		int[] coins = {1, 3, 5};
		
		System.out.println(minCoins(coins, 11));
		System.out.println(minCoins2(coins, 11));
		
		System.out.println(minCoins(coins, 25));
		System.out.println(minCoins2(coins, 25));
		
		System.out.println(minCoins(coins, 26));
		System.out.println(minCoins2(coins, 26));
		
		System.out.println("==============");
		System.out.println(minCoins(coins, 28));
		System.out.println(minCoins2(coins, 28));
	}
	public static int minCoins(int[] coins, int sum) {

	    int impossible = Integer.MAX_VALUE;
	    
	    //end state
	    if (coins.length == 0 && sum > 0) {
	        return impossible;
	    }
	    if (sum == 0) {
	    	return 0;
	    }
	    
	    int[] minCoins = new int[sum+1];
	    minCoins[0] = 0;
	    
	    for (int i = 1; i < minCoins.length; i ++) {
	        minCoins[i] = impossible;
	    }
	    
	    for (int amount = 1; amount <= sum; amount ++) {
	        
	        for (int j = 0; j < coins.length; j ++) {
	            if (coins[j] > amount) {
	                continue;
	            }
	            
	            int coinCount = impossible;
	            
	            if (coins[j] == amount) {
	                coinCount = 1;
	            } else {
	            	int prevCoins = minCoins[amount - coins[j]];
	    	        
		            
		            if (prevCoins != impossible) {
		                coinCount = prevCoins + 1;
		            }
	            }
	            
	           
	            minCoins[amount] = (int)Math.min(coinCount, minCoins[amount]);

	        }
	  
	    }
	    
	    return minCoins[sum];
	}
	
	public static int minCoins2(int[] coins, int sum) {

	    int impossible = Integer.MAX_VALUE;
	    
	    //end state
	    if (coins.length == 0 && sum > 0) {
	        return impossible;
	    }
	    
	    int[] minCoins = new int[sum+1];
	    minCoins[0] = 0;
	    for (int i = 1; i < minCoins.length; i ++) {
	    	minCoins[i] = impossible;
	    }
	    
	    for (int c = 0; c < coins.length; c ++) {
	    	int thisCoinValue = coins[c];
	    	for (int s = 0; s <= sum; s++) {
	    		for (int t = s + 1; t <= sum; t ++) {
	    			if (minCoins[s] != impossible && t - s == thisCoinValue) {
	    				minCoins[t] = Math.min(minCoins[s] + 1, minCoins[t]);
	    			}
	    		}
	    	}
	    }
	   
	    return minCoins[sum];
	}
	
	

}
