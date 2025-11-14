package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ============================================
 * STUDENT ENTITY CLASS  (Model Layer)
 * ============================================
 * 
 * ROLE OF THIS CLASS:
 * -------------------
 * - This class represents a table in the DATABASE.
 * - Each object (instance) of this class represents
 *   a single row/record in that table.
 * 
 * - The process of mapping Java objects to database tables
 *   is called **ORM (Object Relational Mapping)**.
 * 
 * Example:
 * --------
 * Java Object: Student(id=1, name="Amit", email="amit@gmail.com")
 * Database Row:  ID | NAME | EMAIL
 *                1  | Amit | amit@gmail.com
 */

@Entity
// @Entity tells JPA (Java Persistence API) that this class should be treated as a database entity.
// When Spring Boot starts, Hibernate (JPA implementation) will create a table for this class if it doesn’t already exist.

@Table(name = "students1B")
// @Table annotation allows us to specify the name of the database table.
// If we don’t use it, JPA will by default name the table same as the class name ("student").
// Here, we are explicitly naming it "students1B".

@Data
// @Data is a Lombok annotation that automatically generates:
//     - Getters and Setters for all fields
//     - toString() method
//     - equals() and hashCode() methods
// So we don’t have to write boilerplate code manually.

@AllArgsConstructor
// @AllArgsConstructor generates a constructor with parameters for all fields.
// Example: new Student(id, name, email, section, course)

@NoArgsConstructor
// @NoArgsConstructor generates a default constructor (no arguments).
// Required by JPA for entity initialization during data retrieval (reflection).

public class Student {

    /**
     * ============================================
     * PRIMARY KEY FIELD
     * ============================================
     */
    @Id
    // @Id marks this field as the PRIMARY KEY of the table.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue tells JPA how to generate values for the ID column.
    // GenerationType.IDENTITY → Auto-increment strategy (handled by the database).
    // The ID is automatically generated when a new record is inserted.
    private Long id;

    /**
     * ============================================
     * NORMAL COLUMNS
     * ============================================
     * By default, each field becomes a column in the database table.
     * JPA automatically maps variable names to column names.
     */
    private String name;     // maps to column NAME
    private String email;    // maps to column EMAIL
    private String Section;  // maps to column SECTION
    private String Course;   // maps to column COURSE

    // Note: Java naming convention prefers lowercase field names (section, course)
    // but JPA will still work fine with capitalized field names.
}
