package com.voyager.util;

import java.util.Map.Entry;

public class MyPair<T,C> implements Entry<T, C>{
    
	private T key;
    private C value;
    
    public MyPair(T key, C value) {
    	this.key = key;
    	this.value = value;
    }
    
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public C getValue() {
		return value;
	}
	public C setValue(C value) {
		return this.value = value;
	}
    
}