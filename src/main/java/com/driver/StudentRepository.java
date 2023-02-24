//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//@Repository
//public class StudentRepository {
//
//    HashMap<String,Student> studentHashMap;
//    HashMap<String,Teacher> teacherHashMap;
//    HashMap<String, List<String>> teacherStudentList;
//
//
//    public StudentRepository() {
//        studentHashMap = new HashMap<>();
//        teacherHashMap = new HashMap<>();
//        teacherStudentList = new HashMap<>();
//    }
//    public void addStudent(Student student){
//        studentHashMap.put(student.getName(), student);
//    }
//    public void addTeacher(Teacher teacher){
//        teacherHashMap.put(teacher.getName(), teacher);
//    }
//    public void addStudentTeacherPair(String studentName,String teacherName){
//        List<String> studentList = new ArrayList<>();
//        if(teacherStudentList.containsKey(teacherName)){
//            studentList = teacherStudentList.get(teacherName);
//            studentList.add(studentName);
//            teacherStudentList.put(teacherName, studentList);
//        }else{
//            studentList.add(studentName);
//            teacherStudentList.put(teacherName, studentList);
//        }
//    }
//    public Student getStudentByName(String studentName){
//      for(String sname:studentHashMap.keySet()){
//          if(sname.equals(studentName)){
//              return studentHashMap.get(studentName);
//          }
//      }
//      return null;
//    }
//    public Teacher getTeacherByName(String teacherName){
//        for(String tname:teacherHashMap.keySet()){
//            if(tname.equals(teacherName)){
//                return teacherHashMap.get(teacherName);
//            }
//        }
//        return null;
//    }
//    public List<String> getStudentsByTeacherName(String teacherName){
//        List<String> list = new ArrayList<>();
//        for(String tname:teacherStudentList.keySet()){
//            if(tname.equals(teacherName)){
//                list = teacherStudentList.get(teacherName);
//                break;
//            }
//        }
//        return list;
//    }
//    public List<String> getAllStudents(){
//        List<String> students = new ArrayList<>();
//        for(String name:studentHashMap.keySet()){
//            students.add(name);
//        }
//        return students;
//    }
//    public void deleteTeacherStudent(String teacherName){
//        for(String tname:teacherStudentList.keySet()){
//            if(tname.equals(teacherName)){
//                teacherStudentList.remove(teacherName);
//                return;
//            }
//        }
//    }
//    public void deleteAllTeachers(){
//        teacherStudentList.clear();
//    }
//}










package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<String>> teacherStudentHashMap;

    public StudentRepository() {
        studentHashMap = new HashMap<>();
        teacherHashMap = new HashMap<>();
        teacherStudentHashMap = new HashMap<>();
    }

    public void addStudent(Student student){
        String name = student.getName();
        studentHashMap.put(name,student);
    }

    public void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherHashMap.put(name,teacher);
    }

    public void studentTeacherPair(String student, String teacher){
        List<String> studentList = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(teacher)){
            studentList = teacherStudentHashMap.get(teacher);
        }
        studentList.add(student);
        teacherStudentHashMap.put(teacher,studentList);
    }

    public Student getStudentByName(String name){
        return studentHashMap.getOrDefault(name,null);
    }

    public Teacher getTeacherByName(String name){
        return teacherHashMap.getOrDefault(name,null);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return teacherStudentHashMap.getOrDefault(teacher,null);
    }

    public List<String> getAllStudents(){
        List<String> studentsList = new ArrayList<>();
        for (Map.Entry<String,Student> map: studentHashMap.entrySet()){
            Student student = map.getValue();
            studentsList.add(student.getName());
        }
        return studentsList;
    }

    public void deleteTeacherByName(String teacher){
        if(teacherStudentHashMap.containsKey(teacher)){
            List<String> students = teacherStudentHashMap.get(teacher);

            for (String student: students){
                if (studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
            teacherStudentHashMap.remove(teacher);
        }
        if (teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        for(Map.Entry<String,List<String>> map: teacherStudentHashMap.entrySet()){
            String teacher = map.getKey();
            List<String> students = teacherStudentHashMap.get(teacher);
            for (String student: students){
                if (studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
            teacherStudentHashMap.remove(teacher);
        }
        teacherHashMap.clear();
    }
}