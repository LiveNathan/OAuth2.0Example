package com.Nathan.OAuth2.Example.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheController {
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/protected")
    public String getProtectedPage(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/test")
    public String getTestPage() {
        return "test";
    }

    @GetMapping("/loginCustom")
    public String getLoginPage() {
        return "loginCustom";
    }
}
