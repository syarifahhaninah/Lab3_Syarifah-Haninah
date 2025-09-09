package com.grademanagement;

public class GradeManagementApp {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  LAB 3: BINARY I/O ASSIGNMENT DEMO");
        System.out.println("========================================");
        
        // --- Part 1 Demonstration ---
        System.out.println("\n--- Part 1: Binary Data Operations ---");
        String binaryFilename = "student_grades.dat";
        double[] grades1 = {85.5, 92.0, 78.5, 88.0};
        
        // 1a: Write data
        GradeManager.writeGradeData(binaryFilename, 12345, "John Smith", "CS101", grades1);
        
        // 1b: Read data
        GradeManager.readGradeData(binaryFilename);
        
        // --- Part 2 Demonstration ---
        System.out.println("\n--- Part 2: Object Serialization ---");
        String objectFilename = "student_object.dat";
        
        // 2a: Create Student object
        Student student = new Student(54321, "Jane Doe", new double[]{95.0, 89.5, 92.0});
        System.out.println("Created Student Object:");
        System.out.println(student.toString());
        
        // 2b: Serialize and Deserialize
        GradeManager.saveStudent(student, objectFilename);
        Student loadedStudent = GradeManager.loadStudent(objectFilename);
        
        if (loadedStudent != null) {
            System.out.println("\nLoaded Student Object from file:");
            System.out.println(loadedStudent.toString());
        }
        
        System.out.println("\n========================================");
        System.out.println("  LAB 3 DEMONSTRATION COMPLETE");
        System.out.println("========================================");
    }
}
