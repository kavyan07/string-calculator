# String Calculator TDD Kata

## Overview

This project implements a **String Calculator** using **Test-Driven Development (TDD)** principles. The calculator processes strings containing numbers with various delimiters and returns their sum while handling edge cases and validation rules.

## Problem Statement

Create a simple String calculator with method signature:

```java
int Add(String numbers)
```

## Requirements Implemented

### **Step 1: Basic Functionality**

-  Empty string returns `0`
-  Single number returns that number: `"1"` → `1`
-  Two numbers return sum: `"1,2"` → `3`


### **Step 2: Unknown Amount of Numbers**

-  Handle any amount of numbers: `"1,2,3,4,5"` → `15`


### **Step 3: Newline Delimiters**

-  Support newlines as delimiters: `"1\n2,3"` → `6`
-  Mix commas and newlines seamlessly


### **Step 4: Custom Delimiters**

-  Support custom delimiters: `"//;\n1;2"` → `3`
-  Format: `"//[delimiter]\n[numbers...]"`
-  All existing scenarios still supported


### **Step 5: Negative Number Validation**

-  Throw exception for negatives: `"-1,2"` → Exception: `"negatives not allowed -1"`
-  Show all negatives: `"-1,2,-3"` → Exception: `"negatives not allowed -1,-3"`


### **Step 6: Numbers > 1000 Ignored**

-  Ignore numbers bigger than 1000: `"2,1001"` → `2`
-  Include 1000: `"1000,5"` → `1005`


### **Step 7: Long Delimiters**

-  Support delimiters of any length: `"//[***]\n1***2***3"` → `6`
-  Format: `"//[delimiter]\n[numbers...]"`


## ️ Project Structure

```plaintext
project-1/
├── src/
│   ├── main/java/org/example/
│   │   └── StringCalculator.java
│   └── test/java/
│       └── StringCalculatorTest.java
├── pom.xml
└── README.md
```

## How to Run

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher


![image](https://github.com/user-attachments/assets/14e801e2-2904-447b-b800-36b7874e1ce6)

## Test Results

### All Tests Passing 





**IDE Test Runner Results - IntelliJ IDEA:**

This screenshot demonstrates the successful execution of our comprehensive test suite in IntelliJ IDEA's integrated test runner, showcasing:

 **Perfect Test Execution**

- **16 out of 16 tests passed** with 100% success rate
- **Total execution time: 61ms** - demonstrating efficient implementation
- **Process finished with exit code 0** - clean, error-free execution


 **Individual Test Performance**

- Most tests execute in **1-4ms** each, showing optimized code
- Fastest test: **1ms** (basic functionality tests)
- Slowest test: **39ms** (empty string test - likely includes setup overhead)


 **Comprehensive Test Coverage**
The test suite validates all 7 TDD requirements:

-  **Basic Operations** - Empty, single, and multiple numbers
-  **Delimiter Support** - Commas, newlines, and custom delimiters
-  **Advanced Features** - Long delimiters and number filtering (>1000)
-  **Error Handling** - Negative number validation with detailed messages
-  **Edge Cases** - Complex combinations and boundary conditions
