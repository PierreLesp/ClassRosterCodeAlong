package Controller;

import DAO.ClassRosterDAO;
import DAO.ClassRosterDAOException;
import DAO.ClassRosterDAOFileImpl;
import DTO.Student;
import UI.ClassRosterView;
import UI.UserIO;
import UI.UserIOConsoleImpl;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class ClassRosterController {

    private ClassRosterView view;
    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterDAO dao;
    
    public ClassRosterController(ClassRosterView view, ClassRosterDAO dao)
    {
        this.view = view;
        this.dao = dao;
    }
    

public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (ClassRosterDAOException e) {
        view.displayErrorMessage(e.getMessage());
    }
}

private int getMenuSelection() {
    return view.printMenuAndGetSelection();
}

private void createStudent() throws ClassRosterDAOException {
    view.displayCreateStudentBanner();
    Student newStudent = view.getNewStudentInfo();
    dao.addStudent(newStudent.getStudentId(), newStudent);
    view.displayCreateSuccessBanner();
}

private void listStudents() throws ClassRosterDAOException {
    view.displayDisplayAllBanner();
    List<Student> studentList = dao.getAllStudents();
    view.displayStudentList(studentList);
}

private void viewStudent() throws ClassRosterDAOException {
    view.displayDisplayStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student student = dao.getStudent(studentId);
    view.displayStudent(student);
}

private void removeStudent() throws ClassRosterDAOException {
    view.displayRemoveStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student removedStudent = dao.removeStudent(studentId);
    view.displayRemoveResult(removedStudent);
}

private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}

}