import java.util.*;

// Custom class implementing Comparable for natural sorting (by GPA descending)
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    // Natural ordering: Sort by GPA in descending order (highest GPA first)
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gpa, this.gpa);
    }

    // hashCode and equals based on 'id' to ensure uniqueness in Sets
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }
}

public class CustomObjectCollectionsDemo {
    public static void main(String[] args) {

        // ==========================================
        // a. List Interface with Custom Objects & Sorting
        // ==========================================
        System.out.println("--- 1. List Interface with Custom Objects ---");
        List<Student> studentList = new ArrayList<>();
        
        studentList.add(new Student(101, "Alice", 3.5));
        studentList.add(new Student(102, "Bob", 3.9));
        studentList.add(new Student(103, "Charlie", 3.2));

        System.out.println("Original Student List:");
        for (Student s : studentList) {
            System.out.println("  " + s);
        }

        // 1. Sort using Comparable (Natural order defined in Student class: GPA descending)
        Collections.sort(studentList);
        System.out.println("\nSorted by GPA (Natural Order - Descending):");
        for (Student s : studentList) {
            System.out.println("  " + s);
        }

        // 2. Sort using Comparator (Custom order: Name ascending)
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by Name (Custom Order - Alphabetical):");
        for (Student s : studentList) {
            System.out.println("  " + s);
        }


        // ==========================================
        // b. Set Interface with Custom Objects
        // ==========================================
        System.out.println("\n--- 2. Set Interface with Custom Objects ---");
        Set<Student> studentSet = new HashSet<>();
        
        studentSet.add(new Student(201, "David", 3.7));
        studentSet.add(new Student(202, "Emma", 3.6));
        // This duplicate ID (201) will be ignored because equals() and hashCode() use 'id'
        studentSet.add(new Student(201, "David Duplicate", 4.0)); 

        System.out.println("Unique Students in Set (Duplicates by ID rejected):");
        for (Student s : studentSet) {
            System.out.println("  " + s);
        }


        // ==========================================
        // c. Map Interface with Custom Objects
        // ==========================================
        System.out.println("\n--- 3. Map Interface with Custom Objects ---");
        // Mapping Student ID (Integer) to Student Object
        Map<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(301, new Student(301, "Frank", 3.4));
        studentMap.put(302, new Student(302, "Grace", 3.8));

        System.out.println("Student Map Entries:");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("  ID " + entry.getKey() + " -> " + entry.getValue());
        }

        // Retrieving a specific student from the map using their ID key
        int searchId = 302;
        if (studentMap.containsKey(searchId)) {
            System.out.println("\nFound student with ID " + searchId + ": " + studentMap.get(searchId));
        }
    }
}