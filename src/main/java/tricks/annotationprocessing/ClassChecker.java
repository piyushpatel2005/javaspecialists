package tricks.annotationprocessing;

public class ClassChecker {

    public static void checkConstructorIsNoArgsPublic(Class<?> clazz) {
        try {
            clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(
                    "Class does not have a public no-args constructor"
            );
        }
    }
}
