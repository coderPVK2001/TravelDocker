package com.travelapi3.payload;

import lombok.Data;

@Data
public class JwtDto {

    private String type;

    private String token;
}
