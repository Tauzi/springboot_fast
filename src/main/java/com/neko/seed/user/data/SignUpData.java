package com.neko.seed.user.data;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class SignUpData {

    private String name;

    private String password;

    private String email;
}
