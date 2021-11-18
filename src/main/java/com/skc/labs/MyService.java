package com.skc.labs;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyService {


    public void sayHello(String name){
        System.out.println("Hello ! "+ name);
    }

}
