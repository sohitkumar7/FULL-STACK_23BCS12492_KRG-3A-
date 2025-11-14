package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

/**
 * ============================================
 * STUDENT REPOSITORY (Data Access Layer)
 * ============================================
 * 
 * ROLE OF THIS INTERFACE:
 * ------------------------
 * - This interface is part of the **Repository Layer** (also called DAO layer).
 * - It acts as a bridge between the SERVICE layer and the DATABASE.
 * - It handles all database-related operations such as:
 *      → Insert
 *      → Update
 *      → Delete
 *      → Fetch (Select)
 * 
 * - We do NOT need to write SQL queries manually here.
 *   Spring Data JPA provides built-in methods for common CRUD operations.
 * 
 * - Example methods available from JpaRepository:
 *      ➤ findAll()         → SELECT * FROM student;
 *      ➤ findById(id)      → SELECT * FROM student WHERE id = ?;
 *      ➤ save(entity)      → INSERT or UPDATE depending on ID;
 *      ➤ delete(entity)    → DELETE FROM student WHERE id = ?;
 */

@Repository
// @Repository is a STEREOTYPE ANNOTATION in Spring.
// It marks this interface as a Data Access Component.
// The Spring IoC container will automatically detect it 
// and create a Bean for it at runtime.
//
// It also provides EXCEPTION TRANSLATION —
// meaning if any database-related error occurs,
// Spring converts it into a consistent, data-access exception hierarchy
// (for example, SQLException → DataAccessException).

public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * ============================================
     * UNDERSTANDING JPA REPOSITORY
     * ============================================
     * 
     * - JpaRepository is a part of Spring Data JPA.
     * - It is a generic interface that takes two type parameters:
     * 
     *   JpaRepository<EntityClass, PrimaryKeyType>
     * 
     *   → Here:
     *        EntityClass     → Student
     *        PrimaryKeyType  → Long
     * 
     * - This gives us a ready-to-use set of CRUD methods 
     *   without writing even a single line of SQL.
     * 
     * - Example:
     *     repository.findAll();     → Fetch all students
     *     repository.save(student); → Insert or update student
     *     repository.delete(student); → Delete student
     *     repository.findById(1L);  → Fetch student with ID 1
     * 
     * - If we need custom queries (like findByEmail, findByCourse, etc.),
     *   we can define them here using Spring Data JPA naming conventions
     *   or @Query annotation.
     */

    // Example of a custom method (optional, for learning):
    // List<Student> findByCourse(String course);
    // → Spring automatically creates a query: SELECT * FROM student WHERE course = ?
}
