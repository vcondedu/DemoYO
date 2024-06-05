package com.example.demoyo.clases;

public class ClsUsuarioRequest {
    private String email;
    private String password;

    public ClsUsuarioRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters si son necesarios
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
}
