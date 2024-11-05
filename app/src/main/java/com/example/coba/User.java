package com.example.coba;

import android.util.Patterns;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    // Constructor
    public User() {
    }

    // Getter dan Setter untuk ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username tidak boleh kosong");
        }
    }

    // Getter dan Setter untuk Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email tidak valid");
        }
    }

    // Getter dan Setter untuk Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Metode untuk validasi email
    private boolean isValidEmail(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
