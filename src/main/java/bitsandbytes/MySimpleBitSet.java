package bitsandbytes;

public class MySimpleBitSet {
    private long bitset;

    public void set(int index, boolean value) {
        rangeCheck(index);

        if (value) {
            bitset |= 1 << index;
        } else {
            bitset &= ~(1 << index);
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= 64) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean get(int index) {
        rangeCheck(index);
        return (bitset & (1 << index)) != 0;
    }

    public static void main(String[] args) {
        MySimpleBitSet bs = new MySimpleBitSet();
        bs.set(0, true);
        bs.set(1, true);
        bs.set(2, true);
        System.out.println("bs.bitset = " + bs.bitset);

        bs.set(0, false);
        bs.set(2,false);
        System.out.println("bs.bitset = " + bs.bitset);
        System.out.println("Long.toBinaryString(bs.bitset) = " + Long.toBinaryString(bs.bitset));

        System.out.println("bs.get(1) = " + bs.get(1));
    }
}
