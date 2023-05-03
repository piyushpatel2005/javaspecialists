package tricks.annotationprocessing;

public class Test {
    public static void main(String[] args) {
        testCorrect();
        testIncorrect();
    }

    public static void testCorrect() {
        new ExternalizableWithNoArgsPublic();
        new ExternalizableWithDefault();
    }

    public static void testIncorrect() {
        try {
            new ExternalizableWithNoArgsPackage();
            throw new AssertionError();
        } catch (IllegalStateException success) {}

        try {
            new ExternalizableWithNoArgsProtected();
            throw new AssertionError();
        } catch (IllegalStateException success) {}

        try {
            new ExternalizableWithArgsPublic(1);
            throw new AssertionError();
        } catch (IllegalStateException success) {}
    }

}
