package com.poseiden;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getTrueValue() {
        return "this is true value";
    }
}
