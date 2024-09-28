package com.noni.noni;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

class test
{
    public String noni = "hello";
}
@SpringBootApplication
@RestController
public class hello {
    @GetMapping("/time")
    public String time (String  a)
    {
        LocalDate now = LocalDate.now();
        test bab = new test();
        return now.toString();
    }
}
