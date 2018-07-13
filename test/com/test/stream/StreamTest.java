package com.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {
        
        
        List<Integer> listToTest = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            listToTest.add(i);
        }

        long t0 = System.nanoTime();
        List<Integer> list = listToTest.stream().filter(p -> p > 1)
                .collect(Collectors.<Integer> toList());

        long t1 = System.nanoTime();
        System.out.println("time " + (t1 - t0));
        
        List<Integer> list1 = listToTest.stream().parallel().filter(p -> p > 1)
                .collect(Collectors.<Integer> toList());

        long t2 = System.nanoTime();
        System.out.println("time " + (t2 - t1));
        
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1-t0)*1e-9, (t2-t1)*1e-9);
        
        
        
        long t3=System.nanoTime();
        int[] a=IntStream.range(0, 1_000_000).filter(p -> p > 1).toArray();
        long t4=System.nanoTime();
        int[] b=IntStream.range(0, 1_000_000).parallel().filter(p -> p > 1).toArray();
        long t5=System.nanoTime();
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t4-t3)*1e-9, (t5-t4)*1e-9);

    }

}
