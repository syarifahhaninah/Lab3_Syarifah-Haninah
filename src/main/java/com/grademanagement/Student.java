package com.grademanagement;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Student class implementing Serializable for Lab 3: Binary I/O Assignment
 * Part 2a: Student Class (1 mark)
 * 
 * @author Syarifah Haninah
 */
public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int studentId;
    private String name;
    private double[] grades;
    
    /**
     * Constructor for Student class
     */
    public Student(int studentId, String name, double[] grades) {
        this.studentId = studentId;
        this.name = name != null ? name : "";
        this.grades = grades != null ? grades.clone() : new double[0];
    }
    
    /**
     * Default constructor
     */
    public Student() {
        this(0, "", new double[0]);
    }
    
    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name != null ? name : "";
    }
    
    public double[] getGrades() {
        return grades != null ? grades.clone() : new double[0];
    }
    
    public void setGrades(double[] grades) {
        this.grades = grades != null ? grades.clone() : new double[0];
    }
    
    /**
     * Calculate average grade
     */
    public double calculateAverage() {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    
    /**
     * Check if student passed (average >= 60)
     */
    public boolean hasPassed() {
        return calculateAverage() >= 60.0;
    }
    
    /**
     * String representation of Student
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Student Information ===\n");
        sb.append("Student ID: ").append(studentId).append("\n");
        sb.append("Student Name: ").append(name).append("\n");
        sb.append("Grades: ");
        
        if (grades != null && grades.length > 0) {
            for (int i = 0; i < grades.length; i++) {
                sb.append(String.format("%.1f", grades[i]));
                if (i < grades.length - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("No grades");
        }
        
        sb.append("\n");
        sb.append("Average Grade: ").append(String.format("%.1f", calculateAverage())).append("\n");
        sb.append("Status: ").append(hasPassed() ? "PASSED" : "FAILED").append("\n");
        sb.append("==========================");
        
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return studentId == student.studentId &&
               name.equals(student.name) &&
               Arrays.equals(grades, student.grades);
    }
    
    @Override
    public int hashCode() {
        int result = Integer.hashCode(studentId);
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }
}
