package com.java.sum;


public class Sum<T extends Number> {
	private T a;
	private T b;

	public Sum(T a, T b) {
		this.a = a;
		this.b = b;
	}

	public T getA() {
		return a;
	}

	public T getB() {
		return b;
	}

	public double getSum() {
		return getA().doubleValue() + getB().doubleValue();
	}
}