package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
private final Map<String,String> users=new HashMap<>(); 

public LoginService(){
    users.put("admin","admin123");
}

public Boolean authenticate(String username,String password){
     return users.containsKey(username) && users.get(username).equals(password);
}
}
