package com.imShare.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public class BaseResponse {
    protected Logger logger = LoggerFactory.getLogger(BaseResponse.class);
    protected ResponseEntity<?> getResponseEntity(Object data){
        return ResponseEntity.status(200).body(getResponse(data));
    };
    private Response getResponse(Object data){
        Response response = new Response();
        response.setData(data);
        response.setMessage("success");
        response.setStatus(200);
        return response;
    };
}
