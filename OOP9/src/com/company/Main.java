package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Courses one = new Courses();
        one.name = "one";
        Courses two = new Courses();
        two.name = "two";
        Courses three = new Courses();
        three.name = "three";
        Students Igor = new Students();
        Igor.addCource(one);
        Igor.addCource(three);

        Students Vova = new Students();
        Vova.addCource(one);
        Vova.addCource(two);
        Vova.addCource(two);

        List<Student> tempList = new ArrayList<Student>();
        tempList.add(Igor);
        tempList.add(Vova);

        List res1 = firstFunc(tempList);
        List res2 = secondFunc(tempList);
        List res3 = fourthFunc(tempList, two);


    }

    public static List firstFunc(List<Student> students){
        Set<Course> set=new LinkedHashSet<Course>();
        students.stream().forEach( s -> s.getAllCourses().stream().distinct().forEach(x -> set.add(x)));
        return set.stream().collect(Collectors.toList());
    }
    public static List secondFunc(List<Student> students){
        return students.stream().sorted((o1, o2)-> -1 * (o1.getAllCourses().size() - o2.getAllCourses().size())).limit(3).collect(Collectors.toList());
    }
    public static List fourthFunc(List<Student> students, Course cource){
        return students.stream().filter(item -> item.getAllCourses().indexOf(cource) != -1).collect(Collectors.toList());
    }
}
