package com.noni.noni;


    import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlOutController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", SearchAPI.search(name));
        return "greeting"; // templates 디렉토리 내의 greeting.html을 가리킵니다.
    }
}

