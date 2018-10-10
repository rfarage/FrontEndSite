/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Now;
import java.io.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.event.ActionEvent;
import javax.swing.JPasswordField;
/**
 *
 * @author Rania
 */
@ManagedBean(name = "registerManager")
@SessionScoped
public class RegisterManager implements Serializable {
    private User user = null;
    private LinkedList<User> all = new LinkedList<User>();
    /**
     * Creates a new instance of RegisterManager
     */
    public RegisterManager() {
        user = new User();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getPassword() {
         return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public String getConfirmPassword() {
         return user.getConfirmPassword();
    }

    public void setConfirmPassword(String confirmPassword) {
        user.setConfirmPassword(confirmPassword);
    }
    public void registerUser(ActionEvent ae) {
        all.add(user);
        user = new User();
        String file="C:\\Users\\Rania\\Documents\\School Notes\\IT 410\\TestNow\\users.txt";
        try {
            FileOutputStream fos=new FileOutputStream(file);
            PrintWriter pw= new PrintWriter (fos);
            for(User user: all) {
                pw.println(user.getUsername() + ";" + user.getEmail() + ";" + user.getPassword() + ";" + user.getConfirmPassword());
            }
            pw.close();
            System.out.println("Regsitration Complete!");
        }
        catch(FileNotFoundException e) {
            System.out.println(e);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
