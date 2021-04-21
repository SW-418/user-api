package userapi.app.controllers;

import com.sun.net.httpserver.Authenticator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/check")
    public ResponseEntity<Authenticator.Success> check(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<Authenticator.Success> validate(){
        //TODO: Check connection to Dynamo table here
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
