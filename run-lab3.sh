#!/bin/bash

# Lab 3: Binary I/O Assignment - Run Script
# Author: Syarifah Haninah

echo "========================================="
echo "  LAB 3: Binary I/O Assignment Runner"
echo "========================================="

# Change to the project directory
cd "/home/nina/Documents/Uni/ITEC627-Advance Programing/Lab3_Syarifah-Haninah"

echo "Current directory: $(pwd)"
echo "Project files:"
ls -la src/main/java/com/grademanagement/*.java *.xml 2>/dev/null || echo "No Java/XML files found"

echo ""
echo "Option 1: Running with Maven..."
echo "========================================="
mvn clean compile exec:java

echo ""
echo "Option 2: Running with direct Java compilation..."
echo "========================================="
echo "Compiling Java files..."
javac -cp target/classes src/main/java/com/grademanagement/*.java -d target/classes

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful"
    echo ""
    echo "Running Lab 3 Binary I/O Assignment..."
    echo "========================================="
    java -cp target/classes com.grademanagement.GradeManagementApp
    echo ""
    echo "========================================="
    echo "✓ Lab 3 execution completed"
    
    echo ""
    echo "Generated data files:"
    ls -la *.dat 2>/dev/null || echo "No data files generated"
else
    echo "✗ Compilation failed"
    exit 1
fi
