package DAO;

import DTO.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class ClassRosterDAOFileImpl implements ClassRosterDAO 
{
    
    private Map<String, Student> students = new HashMap<>();
    
    
    @Override
    public Student addStudent(String studentId, Student student) 
    {
        Student tempStudent = students.put(studentId, student);
        return tempStudent;
    }

    @Override
    public List<Student> getAllStudents() 
    {
        List<Student> temp = new ArrayList<>(students.values());
        return temp;
        
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) 
    {
    Student removedStudent = students.remove(studentId);
    return removedStudent;
    }
    
    
    
    
    
}
