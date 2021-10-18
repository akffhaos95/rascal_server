package com.example.rascalserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hit {
    private int hitInn;
    private String hitRes;
    private int hitDir;
}
