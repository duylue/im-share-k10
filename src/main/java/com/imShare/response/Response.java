package com.imShare.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Response {
    private Object data;
    private String message;
    private int status;

}
