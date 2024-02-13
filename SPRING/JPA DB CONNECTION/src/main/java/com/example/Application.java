package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.DataOutput;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

/*		Function<Double, Double> function = x -> {
			int a[] = new int[5];
			for(int i = 0; i < 5; i++)
				a[i] = i + 1;

			try {
				return (Math.pow(x, x - 8) + a[5]);
			} catch (Exception e) {
				return 0.0;
			}
		};
		System.out.println("RESULT: " + function.apply((double)10));*/

		SpringApplication.run(Application.class, args);
	}

}
