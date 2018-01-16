package com.daniele.multithreading.threadgroup;

import java.util.HashMap;
import java.util.Map;

public enum Bakery {
	
	BREAD(1,"Bread"), CROISSANT(2,"Croissant"), CAKE(3,"Cake"), PIZZA(4,"Pizza"), KRAFFEN(5,"Kraffen");
	
	private final Integer key;
    private final String value;
    
    /**
     * A mapping between the integer code and its corresponding text to facilitate lookup by code.
     */
    private static Map<Integer, Bakery> valueToTextMapping;

    Bakery(Integer key,String value) {
        this.key = key;
        this.value = value;
    }
    
    public static Bakery getText(String i){
    	if(valueToTextMapping == null){
    		initMapping();
    	}
    	return valueToTextMapping.get(Integer.parseInt(i));
    }
    
    private static void initMapping(){
        valueToTextMapping = new HashMap<Integer, Bakery>();
        for(Bakery s : values()){
            valueToTextMapping.put(s.key,s);
        }
    }

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

   

}
