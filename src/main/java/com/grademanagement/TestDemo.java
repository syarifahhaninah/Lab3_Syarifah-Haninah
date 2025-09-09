package com.grademanagement;

/**
 * Comprehensive test to demonstrate all assignment requirements
 */
public class TestDemo {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  COMPREHENSIVE LAB 3 DEMONSTRATION");
        System.out.println("========================================");
        
        // Test Part 1: Multiple binary data records with course codes and pass status
        testBinaryDataOperations();
        
        // Test Part 2: Object serialization
        testObjectSerialization();
        
        System.out.println("\n========================================");
        System.out.println("  ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("========================================");
    }
    
    private static void testBinaryDataOperations() {
        System.out.println("\n--- Testing Binary Data Operations with All Required Fields ---");
        
        // Test individual records in separate files (as per the updated method signature)
        System.out.println("\n=== Testing Student 1: Alice Johnson (Should PASS) ===");
        GradeManager.writeGradeData("alice_grades.dat", 12345, "Alice Johnson", "CS101", new double[]{85.5, 92.0, 78.5, 88.0});
        GradeManager.readGradeData("alice_grades.dat");
        
        System.out.println("\n=== Testing Student 2: Bob Smith (Should FAIL) ===");
        GradeManager.writeGradeData("bob_grades.dat", 67890, "Bob Smith", "MATH201", new double[]{45.0, 52.0, 48.5, 38.0});
        GradeManager.readGradeData("bob_grades.dat");
        
        System.out.println("\n=== Testing Student 3: Carol Davis (Should PASS) ===");
        GradeManager.writeGradeData("carol_grades.dat", 54321, "Carol Davis", "ENG102", new double[]{95.0, 97.5, 91.0});
        GradeManager.readGradeData("carol_grades.dat");
    }
    
    private static void testObjectSerialization() {
        System.out.println("\n--- Testing Object Serialization ---");
        String objectFile = "test_student.dat";
        
        // Create and save a student object
        Student originalStudent = new Student(99999, "Test Student", new double[]{72.5, 68.0, 75.5, 80.0});
        System.out.println("Original Student Object:");
        System.out.println(originalStudent.toString());
        
        // Save to file
        GradeManager.saveStudent(originalStudent, objectFile);
        
        // Load from file
        Student loadedStudent = GradeManager.loadStudent(objectFile);
        
        if (loadedStudent != null) {
            System.out.println("\nDeserialized Student Object:");
            System.out.println(loadedStudent.toString());
            
            // Verify data integrity
            boolean dataIntegrityOk = originalStudent.getStudentId() == loadedStudent.getStudentId() &&
                                    originalStudent.getName().equals(loadedStudent.getName()) &&
                                    Math.abs(originalStudent.calculateAverage() - loadedStudent.calculateAverage()) < 0.01;
            
            System.out.println("\n✓ Data integrity check: " + (dataIntegrityOk ? "PASSED" : "FAILED"));
        }
    }
}
