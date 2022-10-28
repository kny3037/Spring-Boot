package com.springboot.hello.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto {
    private String id;
    private String name;
    private String password;

}
