package com.grademanagement;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * GradeManager class for Lab 3: Binary I/O Assignment
 * Parts 1a, 1b, and 2b implementation
 * 
 * @author Syarifah Haninah
 */
public class GradeManager {
    
    private static final String BINARY_FILE = "student_grades.dat";
    private static final String OBJECT_FILE = "student_objects.dat";
    
    // Part 1a: Writing Binary Data (1.5 marks) - UPDATED
    /**
     * Write grade data to binary file using DataOutputStream
     */
    public static void writeGradeData(String filename, int studentId, String studentName, String courseCode, double[] grades) {
        // Calculate the 'isPassed' status before writing
        boolean isPassed = calculateAverage(grades) >= 60.0;

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            System.out.println("\n=== WRITING BINARY DATA ===");

            // Write data in the required order
            dos.writeInt(studentId);
            dos.writeUTF(studentName);
            dos.writeUTF(courseCode);

            // Write the number of grades followed by the grades themselves
            dos.writeInt(grades.length);
            for (double grade : grades) {
                dos.writeDouble(grade);
            }

            dos.writeBoolean(isPassed);

            System.out.println("✓ Binary data written successfully to " + filename);

        } catch (IOException e) {
            System.err.println("✗ Error writing binary data: " + e.getMessage());
        }
    }
    
    // Helper method to calculate average
    private static double calculateAverage(double[] grades) {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    
    // Part 1b: Reading Binary Data (1.5 marks) - UPDATED
    /**
     * Read grade data from binary file using DataInputStream
     */
    public static void readGradeData(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Binary data file not found: " + filename);
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\n=== READING BINARY DATA FROM " + filename + " ===");

            // Read data in the same order it was written
            int studentId = dis.readInt();
            String studentName = dis.readUTF();
            String courseCode = dis.readUTF();

            int numGrades = dis.readInt();
            double[] grades = new double[numGrades];
            for (int i = 0; i < numGrades; i++) {
                grades[i] = dis.readDouble();
            }

            boolean isPassed = dis.readBoolean();

            // Display the read data
            System.out.println("Student ID: " + studentId);
            System.out.println("Student Name: " + studentName);
            System.out.println("Course Code: " + courseCode);

            System.out.print("Grades: ");
            for (double grade : grades) {
                System.out.print(grade + " ");
            }
            System.out.println();

            System.out.printf("Average Grade: %.1f\n", calculateAverage(grades));
            System.out.println("Passed: " + isPassed);

        } catch (IOException e) {
            System.err.println("✗ Error reading binary data: " + e.getMessage());
        }
    }
    
    // Part 2b: Object Serialization (1 mark)
    /**
     * Save Student object to file using ObjectOutputStream
     */
    public static void saveStudent(Student student, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println("\n=== SAVING STUDENT OBJECT ===");
            oos.writeObject(student);
            System.out.println("✓ Student object saved successfully to " + filename);
        } catch (IOException e) {
            System.err.println("✗ Error saving student object: " + e.getMessage());
        }
    }

    /**
     * Load Student object from file using ObjectInputStream
     */
    public static Student loadStudent(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No student object file found: " + filename);
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("\n=== LOADING STUDENT OBJECT ===");
            Student student = (Student) ois.readObject();
            System.out.println("✓ Successfully loaded student object from " + filename);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Error loading student object: " + e.getMessage());
            return null;
        }
    }    /**
     * Clear all data files
     */
    public static void clearAllData() {
        File binaryFile = new File(BINARY_FILE);
        File objectFile = new File(OBJECT_FILE);
        
        boolean binaryDeleted = false;
        boolean objectDeleted = false;
        
        if (binaryFile.exists()) {
            binaryDeleted = binaryFile.delete();
        }
        
        if (objectFile.exists()) {
            objectDeleted = objectFile.delete();
        }
        
        System.out.println("\n=== CLEARING DATA FILES ===");
        if (binaryDeleted) {
            System.out.println("✓ Binary data file cleared");
        }
        if (objectDeleted) {
            System.out.println("✓ Object data file cleared");
        }
        if (!binaryDeleted && !objectDeleted) {
            System.out.println("No data files to clear");
        }
    }
}
