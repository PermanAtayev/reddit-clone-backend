package main.reddit.controller;

import lombok.AllArgsConstructor;
import main.reddit.dto.AuthenticationResponse;
import main.reddit.dto.LoginRequest;
import main.reddit.dto.RegisterRequest;
import main.reddit.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User registration Successful", HttpStatus.CREATED);
    }

    @GetMapping(value = "/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable("token") String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Your account is verified.",HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping(value = "/refresh/token")
    

    @GetMapping
    public String home(){
        return "Hello there 1000";
    }
}
