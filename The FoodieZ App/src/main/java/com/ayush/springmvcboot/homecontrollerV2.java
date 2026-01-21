package com.ayush.springmvcboot;


import com.ayush.springmvcboot.model.LoginInfo;
import com.ayush.springmvcboot.model.LoginResponse;
import com.ayush.springmvcboot.model.User;
import com.ayush.springmvcboot.repository.UserRepository;
import com.ayush.springmvcboot.service.LoginService;
import com.ayush.springmvcboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController()
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v2")
public class homecontrollerV2
{
    private final UserRepository userRepository;
    UserService userService;
    LoginService loginService;

    homecontrollerV2(UserService userService,
                     UserRepository userRepository,
                     LoginService loginService)
    {
        this.userService=userService;
        this.userRepository = userRepository;
        this.loginService= loginService;
    }

    @GetMapping()
    public ResponseEntity<User> getUser(@RequestBody String userId)
    {
        User user = userService.getUser(userId);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(user,HttpStatus.OK);



    }

    @PostMapping()
    public void saveUser(@RequestBody User user)
    {
        userService.saveUser(User
                .builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginInfo user)
    {
        log.info("login is working");
        return loginService.checkUser(user.getUsername());
    }

}
	
	


