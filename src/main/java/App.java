
import Controller.ClassRosterController;
import DAO.ClassRosterDAO;
import DAO.ClassRosterDAOFileImpl;
import UI.ClassRosterView;
import UI.UserIO;
import UI.UserIOConsoleImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class App {
    
    
    public static void main(String[] args)
    {
        //
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDAO myDao = new ClassRosterDAOFileImpl();
        ClassRosterController controller =
                                new ClassRosterController(myView, myDao);
        controller.run();

    }
    
    
    
    
}
