package com.springbootpostresql.SpringBootPostgreSQL.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1") //here since we have used a findStudentByEmail() method
        // we dont need to explicitly write this query, but no harm in wrinting it.
    Optional<Student> findStudentByEmail(String email);
}


//NOTES

/*
The method `Optional<Student> findStudentByEmail(String email)` is a declaration of a method that returns an `Optional` object wrapping a `Student` object.

In Java, `Optional` is a container class introduced in Java 8 to represent the presence or absence of a value. It is commonly used to handle scenarios where a method may or may not return a value.

In the context of the method `findStudentByEmail`, it suggests that the method is intended to search for a student with a specific email and return the result as an `Optional<Student>`.

Here's an example of how you could use this method:


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
}


In this example, the method `findStudentByEmail` is defined within a Spring Data JPA repository interface. The implementation of this method is automatically generated by Spring Data JPA based on the method name.

When you invoke this method, it will perform a database query to find a student entity with the given email. If a matching student is found, it will be wrapped in an `Optional` and returned. If no student is found with the given email, the returned `Optional` will be empty.

By returning an `Optional`, it provides a convenient way to handle scenarios where the student may or may not exist in the database without explicitly dealing with null values. The caller of this method can then use methods like `isPresent()`, `orElse()`, or `orElseThrow()` to retrieve the student or handle the absence of a student gracefully.

 */
