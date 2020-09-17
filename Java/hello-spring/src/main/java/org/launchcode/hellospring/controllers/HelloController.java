package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
@ResponseBody
public class HelloController {

    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" +
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("helloform")
    @ResponseBody()
    public String helloform() {
        return "<form method = 'POST' action = 'hello'>" +
                "<input type = 'text name = 'name'" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'spanish'>Spanish</option>" +
                "<option value = 'dutch'>Dutch</option>" +
                "<option value = 'ukrainian'>Ukrainian</option>" +
                "<option value = 'latin'>Latin</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me'>" +
                "</form>";
    }

    @PostMapping("hello")
    @ResponseBody
    public String sayHello(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String result = "";
        if (language.equals("english")) {
            result = "Hello, " + name;
        } else if (language.equals("spanish")) {
            result = "Hola, " + name;
        } else if (language.equals("dutch")) {
            result = "Hallo, " + name;
        } else if (language.equals("ukrainian")) {
            result = "Pryvit, " + name;
        } else if (language.equals("latin")) {
            result = "Salve, " + name;
        }
        return result;
    }
}
