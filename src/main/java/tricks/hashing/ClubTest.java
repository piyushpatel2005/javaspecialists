package tricks.hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/*
Hash code must be immutable
must be fast to calculate
does not have to be unique
must be paired with equals
 */
public class ClubTest {
    public static void main(String[] args) {
        test(new HashMap());
        test(new Hashtable());
        test(new ConcurrentHashMap());
        test(new TreeMap());
    }

    private static void test(Map map) {
        JavaSpecialistClubMember heinz = new JavaSpecialistClubMember("Heinz", "heinz@gmail.com");
        JavaSpecialistClubMember john = new JavaSpecialistClubMember("John", "john@gmail.com");
        JavaSpecialistClubMember marco = new JavaSpecialistClubMember("Marco", "marco@gmail.com");

        map.put(heinz, "Heinz");
        map.put(marco, "Marco");
        map.put(john, "John");

        System.out.println(map);

        heinz.setUsername("Kabutz");
        JavaSpecialistClubMember heinz1 = new JavaSpecialistClubMember("Heinz", "heinz@gmail.com");
        JavaSpecialistClubMember heinz2 = new JavaSpecialistClubMember("Kabutz", "heinz@gmail.com");

        System.out.println("============ After adding multiple users with same key ===========");
        System.out.println("map.get(heinz1) = " + map.get(heinz1)); // returns null for some reason
        System.out.println("map.get(heinz2) = " + map.get(heinz2)); // return null for this too

        System.out.println("======== Map has that user =============");
        System.out.println("map = " + map);

        System.out.println("map.get(heinz) = " + map.get(heinz));

        // If you change key of the map, it disappears and again reappears
//        System.out.println("============ Change back to original user name ========");
//        heinz.setUsername("Heinz");
//        System.out.println("map = " + map);
//
//        System.out.println("map.get(heinz) = " + map.get(heinz));

        System.out.println("=========== Add more members =========== ");
        // When we add many new members, then it does rehashing, which may make members re-appear.
        for (int i = 0; i < 1000; i++) {
            JavaSpecialistClubMember peter = new JavaSpecialistClubMember("Peter" + i, "peter" + i + "@gmail.com");
            map.put(peter, "Peter" + i);
        }
        System.out.println("map.get(heinz1) = " + map.get(heinz1));
        System.out.println("map.get(heinz2) = " + map.get(heinz2));

    }
}
