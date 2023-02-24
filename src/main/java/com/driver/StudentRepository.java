package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    public StudentRepository(){

    }
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentList = new HashMap<>();
    public void addStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }
    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }
    public void addStudentTeacherPair(String teacherName,String studentName){
        List<String> studentList = new ArrayList<>();
        if(teacherStudentList.containsKey(teacherName)){
            studentList = teacherStudentList.get(teacherName);
            studentList.add(studentName);
            teacherStudentList.put(teacherName, studentList);
        }else{
            studentList.add(studentName);
            teacherStudentList.put(teacherName, studentList);
        }
    }
    public Student getStudentByName(String studentName){
      for(String sname:studentHashMap.keySet()){
          if(sname.equals(studentName)){
              return studentHashMap.get(studentName);
          }
      }
      return null;
    }
    public Teacher getTeacherByName(String teacherName){
        for(String tname:teacherHashMap.keySet()){
            if(tname.equals(teacherName)){
                return teacherHashMap.get(teacherName);
            }
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> list = new ArrayList<>();
        for(String tname:teacherStudentList.keySet()){
            if(tname.equals(teacherName)){
                list = teacherStudentList.get(teacherName);
                break;
            }
        }
        return list;
    }
    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(String name:studentHashMap.keySet()){
            students.add(name);
        }
        return students;
    }
    public void deleteTeacherStudent(String teacherName){
        for(String tname:teacherStudentList.keySet()){
            if(tname.equals(teacherName)){
                teacherStudentList.remove(teacherName);
                return;
            }
        }
    }
    public void deleteAllTeachers(){
        teacherStudentList.clear();
    }
}
