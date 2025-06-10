package com.hd.basic_spring_boot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberRegDto {
    private String email;
    private String pwd;
    private String name;
}
