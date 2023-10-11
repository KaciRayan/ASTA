package efrei.lequipe.ASTA.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseObject {
    public static ResponseEntity<Object> build(String message, HttpStatus httpStatus, Object responseObject){
        var response = new HashMap<String, Object>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }
    public static ResponseEntity<Object> build(HttpStatus httpStatus, Object responseObject){

        return ResponseObject.build(null, httpStatus, responseObject);
    }
}
