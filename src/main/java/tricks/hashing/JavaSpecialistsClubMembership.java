package tricks.hashing;

import java.util.HashSet;

public class JavaSpecialistsClubMembership extends HashSet<JavaSpecialistClubMember> {
    public boolean isMember(String email) {
        for (JavaSpecialistClubMember member: this) {
            if (member.getEmail().equals(email)) return true;
        }
        return false;
    }

    public boolean isMemberWithCodeRule(String email) {
        boolean found = false;
        for (JavaSpecialistClubMember member: this) {
            if (member.getEmail().equals(email)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
