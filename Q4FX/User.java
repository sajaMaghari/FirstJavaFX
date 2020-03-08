/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4fx;

import java.io.Serializable;

/**
 *
 * @author khatib
 */
public class User implements Serializable{
    private String name, pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return  "name = " + name + ", pass = " + pass + " \n " ;
    }
    
}
