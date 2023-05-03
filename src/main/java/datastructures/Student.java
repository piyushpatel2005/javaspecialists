package datastructures;

import java.util.Objects;

class Student implements Comparable<Student> {
    private final int year;
    private final String name;
    private final double average;

    public Student(int year, String name, double average) {
        this.year = year;
        this.name = name;
        this.average = average;
    }


    @Override
    public int compareTo(Student o) {
        int result = Integer.compare(year, o.year); // do not use year - o.year;
        if (result == 0) {
            return name.compareTo(o.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", average=" + average +
                '}';
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, name);
    }
}
