package com.java;


import javax.swing.JOptionPane;
import com.java.sum.Sum;


public class Main {
	public static void main(String[] args) {
		int a = 12;
		int b = 23;
		Sum<Integer> sum = new Sum<>(a, b);

		JOptionPane.showMessageDialog(null, "Sum is " + sum.getSum());
	}
}