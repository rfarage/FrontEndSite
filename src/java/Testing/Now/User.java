/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Now;

import java.io.*;
import java.util.Scanner;
import javax.swing.JPasswordField;

/**
 *
 * @author Rania
 */
public class User {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    
    
    public User() {
        
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        String path = "C:\\Users\\Rania\\Documents\\School Notes\\IT 410\\TestNow\\users.txt";
        try {
		String line = null;
		Scanner scan = new Scanner ( new FileInputStream(new File(path)));
		Scanner scan2 = null;
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				scan2 = new Scanner (line);
				scan2.useDelimiter(";");
				String name = scan2.next();
                                if(username.equalsIgnoreCase(name)) {
                                    throw new IllegalArgumentException("Error, username already used");
                                }
			}
			scan.close();
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String path = "C:\\Users\\Rania\\Documents\\School Notes\\IT 410\\TestNow\\users.txt";
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
                                if(email.equalsIgnoreCase(oEmail)) {
                                    throw new IllegalArgumentException("Error, email already used");
                                }
			}
			scan.close();
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if(!confirmPassword.equalsIgnoreCase(this.password)) {
            throw new IllegalArgumentException("Error, passwords must match");
        }
        this.confirmPassword = confirmPassword;
    }
    
    
}
