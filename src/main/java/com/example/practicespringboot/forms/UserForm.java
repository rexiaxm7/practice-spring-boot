package com.example.practicespringboot.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

public class UserForm {
    public interface Update {}

    @NotBlank(groups = {Default.class ,Update.class})
    @Email(groups = {Default.class ,Update.class})
    private String email;

    @NotBlank(groups = {Default.class ,Update.class})
    private String name;

    @NotBlank
    private String loginId;

    @NotNull(groups = {Default.class ,Update.class})
    private Integer gender;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
