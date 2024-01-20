/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainFramework;

/**
 *
 * @author marve
 */
public class Student {
    private String name;
    private String id;
    private String password;

    // Constructor
    public Student(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

