package com.example.practicespringboot.forms;

import com.example.practicespringboot.validations.EmailUnused;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EmailUnused
public class UserEditForm {
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotNull
    private Integer gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
