# Lab 3: Binary I/O and Object Serialization

**Author:** Syarifah Haninah  
**ID:** S00394184 

---

## 1. Introduction

This project demonstrates advanced Java programming concepts through the implementation of binary file input/output operations and object serialization mechanisms. The application manages student grade data using two distinct methodologies, primitive data type manipulation through binary streams and object oriented data persistence via the `Serializable` interface.

The implementation addresses core concepts in data persistence, demonstrating proficiency in stream management, exception handling, and file system interactions within the Java ecosystem.


## 2. System Architecture

The application follows a modular design pattern with clear separation of concerns across three primary components:

### 2.1 Core Components

- **`Student.java`**
  - Plain Old Java Object (POJO) representing student entities
  - Implements `java.io.Serializable` interface for object persistence
  - Encapsulates student attributes: ID, name, and grade array

- **`GradeManager.java`**
  - Service layer class containing all file I/O operations
  - Implements binary data read/write functionality
  - Manages object serialization and deserialization processes

- **`GradeManagementApp.java`**
  - Main application entry point
  - Orchestrates demonstration of all system functionalities
  - Provides comprehensive testing of implemented features

### 2.2 Build Configuration

The project utilizes Apache Maven for dependency management and build automation, configured through the `pom.xml` file.

## 3. Implementation Details

### 3.1 Part 1: Binary Data Operations

#### 3.1.1 Data Writing Process
The `writeGradeData()` method implements binary data persistence through the following process:

1. Utilizes `DataOutputStream` for type-safe binary writing
2. Maintains strict data structure ordering:
   - Student ID (`int`)
   - Student Name (`String`)
   - Course Code (`String`)
   - Grade Array Length (`int`)
   - Individual Grade Values (`double[]`)
   - Pass Status (`boolean`)

#### 3.1.2 Data Reading Process
The `readGradeData()` method performs binary data retrieval:

1. Employs `DataInputStream` for sequential data reading
2. Reconstructs student records maintaining original data integrity
3. Performs grade calculations and academic status determination

### 3.2 Part 2: Object Serialization

#### 3.2.1 Serializable Student Class
The `Student` class demonstrates object serialization capabilities:

- Implements `java.io.Serializable` marker interface
- Provides complete state preservation across application sessions
- Maintains data encapsulation through proper accessor methods

#### 3.2.2 Serialization Operations
Object persistence is managed through:

- `saveStudent()`: Utilizes `ObjectOutputStream` for object serialization
- `loadStudent()`: Employs `ObjectInputStream` for object deserialization
- Comprehensive error handling and resource management

## 4. Project Structure

```
Lab3_Syarifah-Haninah1-main/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── grademanagement/
│                   ├── Student.java
│                   ├── GradeManager.java
│                   ├── GradeManagementApp.java
│                   └── TestDemo.java
├── target/
│   └── classes/
├── .gitignore
├── pom.xml
├── run-lab3.sh
├── README.md
├── student_grades.dat
└── student_object.dat
```

### 4.1 File Descriptions

- **Core Application Files:**
  - `Student.java` - Serializable student entity class
  - `GradeManager.java` - Binary I/O and serialization operations
  - `GradeManagementApp.java` - Main application entry point
  - `TestDemo.java` - Additional testing and demonstration class

- **Configuration Files:**
  - `pom.xml` - Maven project configuration
  - `.gitignore` - Git version control ignore patterns
  - `run-lab3.sh` - Shell script for easy execution

- **Generated Output Files:**
  - `student_grades.dat` - Binary data file (created during execution)
  - `student_object.dat` - Serialized object file (created during execution)

- **Documentation:**
  - `README.md` - This comprehensive project documentation

## 5. Compilation and Execution

### 6.1 Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Maven 3.6.0 or higher
- Command line interface access

### 5.2 Execution Methods

#### Method 1: Apache Maven (Recommended)
```bash
cd "Lab3_Syarifah-Haninah1-main"
mvn clean compile exec:java -Dexec.mainClass="com.grademanagement.GradeManagementApp"
```

#### Method 2: Using Provided Shell Script
```bash
cd "Lab3_Syarifah-Haninah1-main"
./run-lab3.sh
```

#### Method 3: Manual Compilation
```bash
cd "Lab3_Syarifah-Haninah1-main"
javac -d target/classes src/main/java/com/grademanagement/*.java
java -cp target/classes com.grademanagement.GradeManagementApp
```

#### Method 4: Running Test Demonstration (Optional)
```bash
cd "Lab3_Syarifah-Haninah1-main"
java -cp target/classes com.grademanagement.TestDemo
```

### 5.3 Expected Output
The application will display detailed console output showing:
- Binary data writing and reading operations
- Object serialization and deserialization processes
- Student information with calculated averages and pass/fail status
- Confirmation messages for successful file operations

## 6. Output Files

Upon successful execution, the application generates the following binary files in the project root directory:

- **`student_grades.dat`**: Contains primitive binary data demonstrating Parts 1a and 1b
  - Stores student ID, name, course code, grades array, and pass status
  - Uses `DataOutputStream` format for cross-platform compatibility
  
- **`student_object.dat`**: Contains serialized Student objects demonstrating Part 2b
  - Stores complete Student object state using Java serialization
  - Maintains object integrity across application sessions

These files serve as evidence of successful implementation and can be examined to verify data persistence functionality. The files are automatically created during program execution and will be overwritten on subsequent runs.

## 7. Conclusion

This implementation successfully demonstrates mastery of advanced Java I/O concepts, including binary data manipulation and object serialization. The project exhibits proper software engineering practices through modular design, comprehensive error handling, and clear documentation.

The application serves as a practical example of data persistence mechanisms commonly employed in enterprise Java applications, providing a solid foundation for understanding more complex data management scenarios.

