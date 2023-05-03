package tricks.hashing;

import java.util.Objects;

public class JavaSpecialistClubMember implements Comparable<JavaSpecialistClubMember> {


    private String username;
    private String email;
    private String firstName;
    private String surname;
    private String birthday;

    public JavaSpecialistClubMember(String username, String email, String firstName, String surname, String birthday) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.birthday = birthday;
    }

    public JavaSpecialistClubMember(String username, String email) {
        this(username, email, null, null, null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaSpecialistClubMember that = (JavaSpecialistClubMember) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username + " <" + email + ">";
    }

    @Override
    public int compareTo(JavaSpecialistClubMember o) {
        return username.compareTo(o.username);
    }
}
