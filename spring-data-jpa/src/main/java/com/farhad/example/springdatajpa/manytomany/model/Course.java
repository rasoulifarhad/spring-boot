package com.farhad.example.springdatajpa.manytomany.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {
  
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "likedCourses")
    Set<Student> likes = new HashSet<>();
}
