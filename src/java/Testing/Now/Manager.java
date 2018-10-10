/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Now;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Scanner;
import javax.faces.event.ActionEvent;
/**
 *
 * @author Rania
 */
@ManagedBean(name = "manager")
@SessionScoped
public class Manager implements Serializable {
    private String email;
    private String password;
   
    /**
     * Creates a new instance of Manager
     */
    public Manager() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void loginUser(ActionEvent ae) {
        String path = "C:\\Users\\Rania\\Documents\\School Notes\\IT 410\\TestNow\\users.txt";
        boolean pass = false;
        try {
		String line = null;
		Scanner scan = new Scanner ( new FileInputStream(new File(path)));
		Scanner scan2 = null;
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				scan2 = new Scanner (line);
				scan2.useDelimiter(";");
                                String name = scan2.next();
				String oEmail = scan2.next();
                                String oPass = scan2.next();
                                if(email.equalsIgnoreCase(oEmail)) {
                                    pass=true;
                                    if(password.equalsIgnoreCase(oPass)) {
                                        System.out.println("Logged In!");
                                    }
                                    else {
                                        System.out.println("Error, password does not match");
                                    }
                                }
			}
			scan.close();
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
        if(!pass) {
            System.out.println("Error, email not found");
        }
    }
}
