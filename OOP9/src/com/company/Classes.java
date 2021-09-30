package com.company;

import java.util.ArrayList;
import java.util.List;

class Courses implements Course{
    public String name;
}

class Students implements Student{
    private String name;
    private List<Course> courses = new ArrayList();
    public String getName(){
        return name;
    }
    public List<Course> getAllCourses(){
        return courses;
    }
    public void addCource(Courses course){
        courses.add(course);
    }
    public void setName(String name){
        this.name = name;
    }
}
