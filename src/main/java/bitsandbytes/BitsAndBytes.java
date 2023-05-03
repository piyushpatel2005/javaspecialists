package bitsandbytes;

import java.util.BitSet;

public class BitsAndBytes {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Integer.toBinaryString(number) = " + Integer.toBinaryString(number));
        System.out.println("Integer.toHexString(number) = " + Integer.toHexString(number));
        boolean comparison = 124 == 0124; // These two are not equal because 0124 is actually octal number 124
        System.out.println("comparison = " + comparison);
        // Usually binary AND and OR are similar to boolean AND OR except that boolean AND and OR are short-circuited but binary ones are not.
        String john = null;
        // replace below boolean AND (&&) with binary (&)
        if (john != null && john.equals("John")) System.out.println("This is really john");
        int xor = 0b1001 ^ 0b1010;
        System.out.println("Integer.toBinaryString(xor) = " + Integer.toBinaryString(xor));
        int complement = ~0b1100;
        System.out.println("Integer.toBinaryString(complement) = " + Integer.toBinaryString(complement));
        // Shifting bits to left
        System.out.println("Integer.toHexString(0x1234 << 4) = " + Integer.toHexString(0x1234 << 4)); // shifting by single bit is same as multiplying by 2
        System.out.println("Integer.toString(15 << 4) = " + Integer.toString(15 << 4));
        // Right shifting is like dividing by 2 with power of given number
        System.out.println("Integer.toString(65536 >> 4) = " + Integer.toString(65536 >> 8));
        System.out.println("Integer.toString((-1023 >> 2) << 2) = " + Integer.toString((-1023 >> 2) << 2));
        // If we right shift with three arrows, it will discard overflowing numbers
        System.out.println("Integer.toHexString(0xcafebabe >>> 16) = " + Integer.toHexString(0xcafebabe >>> 16));
        System.out.println("intToBits(16) = " + intToBits(16));
        // negative numbers in bitwise format are represented using first bit as 1. This means there is one more negative number than positive.
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("-Integer.MIN_VALUE = " + -Integer.MIN_VALUE); // returns the same number instead of positive number
        // below works which is relatively new method
//        System.out.println("Math.negateExact(Integer.MIN_VALUE) = " + Math.negateExact(Integer.MIN_VALUE));
        System.out.println("intToBits(Integer.MIN_VALUE) = " + intToBits(Integer.MIN_VALUE));
        System.out.println("intToBits(Integer.MAX_VALUE) = " + intToBits(Integer.MAX_VALUE));
        // Hashcode should be as unique as possible and as small as possible for better distribution.

        // BitSet is useful when we have more than 64 bits else we can use long. It provides nice api
        System.out.println(" ==== Bitset Examples =====");
        BitSet set = new BitSet(1000);

        // Finding midpoint neatly
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE - 2;
        System.out.println(String.format("a = %d, b = %d, midPoint = %d", a, b, (a+b) >>> 1));
        a= 20;
        b = 22;
        System.out.println(String.format("a = %d, b = %d, midPoint = %d", a, b, (a+b) >>> 1));
        b = 21;
        System.out.println(String.format("a = %d, b = %d, midPoint = %d", a, b, (a+b) >>> 1));

    }

    public static CharSequence intToBits(int num) {
        StringBuilder result = new StringBuilder();
        for (int bit = 31; bit >= 0; bit--) {
            if ((num & (1 << bit)) != 0) // verify if the given bit is set by masking
                result.append(1);
            else 
                result.append(0);
            if (bit > 0) {
                // bit % 4 == 0 => nibble, bit % 8 == 0 => byte
                if ((bit & 0b11) == 0)
                    result.append('_');
                if ((bit & 0b111) == 0)
                    result.append('_');
            }
        }
        return result;
    }
}
