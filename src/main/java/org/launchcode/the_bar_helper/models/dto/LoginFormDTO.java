package org.launchcode.the_bar_helper.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull(message = "Username required.")
    @NotBlank(message = "Username required.")
    @Size(min = 3, max = 30, message = "Username must be 3-30 characters long")
    private String username;

    @NotNull(message = "Password required.")
    @NotBlank(message = "Password required.")
    @Size(min = 7, max = 30, message = "Password must be 7-50 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
