//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//
//@Service
//public class StudentService {
//    public StudentService(){
//
//    }
//    @Autowired
//    StudentRepository studentRepository;
//   public void addStudent(Student student){
//       studentRepository.addStudent(student);
//   }
//   public void addTeacher(Teacher teacher){
//       studentRepository.addTeacher(teacher);
//   }
//
//  public void addStudentTeacherPair(String studentName,String teacherName){
//       studentRepository.addStudentTeacherPair(studentName, teacherName);
//  }
//  public Student getStudentByName(String name){
//       return studentRepository.getStudentByName(name);
//  }
//    public Teacher getTeacherByName(String name){
//        return studentRepository.getTeacherByName(name);
//    }
//    public List<String> getStudentsByTeacherName(String name){
//        return studentRepository.getStudentsByTeacherName(name);
//    }
//   public List<String> getAllStudents(){
//       return studentRepository.getAllStudents();
//   }
//
//   public void deleteTeacherStudent(String teacherName){
//       studentRepository.deleteTeacherStudent(teacherName);
//   }
//   public void deleteAllTeachers(){
//       studentRepository.deleteAllTeachers();
//   }
//}









package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void studentTeacherPair(String student, String teacher){
        studentRepository.studentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}