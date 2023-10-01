package com.voyager.enterprise.impl.action;

import java.util.function.Consumer;
import java.util.function.Function;

public class ActionQueue<T, R> {
	
	private Function<T, R> action;
	private T data;
	private Consumer<R> call;
	
	public ActionQueue(Function<T, R> action, T data, Consumer<R> call) {
		this.action = action;
		this.data = data;
		this.call = call;
	}
	
	public ActionQueue() {}
	
	public ActionQueue( Function<T, R> action ) {
		this.action = action;
	}
	
	public ActionQueue<T,R> data(T data) {
		this.data = data;
		return this;
	}
	
	public ActionQueue<T, R> action(Function<T, R> action){
		this.action = action;
		return this;
	}
	
	public ActionQueue<T, R> call(Consumer<R> call){
		this.call = call;
		return this;
	}

	public Function<T, R> getAction() {
		return action;
	}

	public void setAction(Function<T, R> action) {
		this.action = action;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Consumer<R> getCall() {
		return call;
	}

	public void setCall(Consumer<R> call) {
		this.call = call;
	}

}
