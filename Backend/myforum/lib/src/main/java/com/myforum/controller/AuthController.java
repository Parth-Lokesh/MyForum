//package com.myforum.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myforum.config.JwtProvider;
//import com.myforum.model.User;
//import com.myforum.repository.UserRepository;
//import com.myforum.request.LoginRequest;
//import com.myforum.response.AuthResponse;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtProvider jwtProvider;
//
//    @PostMapping("/signup")
//    public String signup(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return "User registered successfully";
//    }
//
//    @PostMapping("/login")
//    public AuthResponse login(@RequestBody LoginRequest request) {
//        User user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            String token = jwtProvider.generateToken(user.getUsername());
//            return new AuthResponse(token);
//        } else {
//            throw new RuntimeException("Invalid credentials");
//        }
//    }
//}
