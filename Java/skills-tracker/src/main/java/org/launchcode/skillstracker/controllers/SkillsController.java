package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String programmingLanguages() {
        String languages =
                "<h1>Skills Tracker</h1>" +
                        "<h2>Here are some programming languages I would like to learn:</h2>" +
                        "<ol>" +
                        "<li>Java</li>" +
                        "<li>Python</li>" +
                        "<li>C#</li>" +
                        "</ol>";
        return languages;
    }

    @GetMapping("form")
    public String languageForm() {
        String form = "<form method = 'post'>" +
                "Name: " +
                "<input type = 'text' name = 'name'/>" +
                "<br>My first favorite language:" +
                    "<select name='favorite1'>" +
                       "<option value='Java'>Java</option>" +
                       "<option value='Python'>Python</option>" +
                       "<option value='C#'>C#</option>" +
                    "</select>" +
                "<br>My Second favorite language:" +
                    "<select name='favorite2'>" +
                        "<option value='Java'>Java</option>" +
                        "<option value='Python'>Python</option>" +
                        "<option value='C#'>C#</option>" +
                    "</select>" +
                "<br>My third favorite language:" +
                    "<select name='favorite3'>" +
                        "<option value='Java'>Java</option>" +
                        "<option value='Python'>Python</option>" +
                        "<option value='C#'>C#</option>" +
                    "</select>" +
                "<br>" +
                "<input type = 'submit' value = 'Submit'>";
        return form;

    }

    @PostMapping("form")
    public String skillTracker(@RequestParam String name, @RequestParam String favorite1, @RequestParam String favorite2, @RequestParam String favorite3) {
        String choices = "<h1>" +
                name +
                "</h1>" +
                    "<ol>" +
                    "<li>" + favorite1 + "</li>" +
                    "<li>" + favorite2 + "</li>" +
                    "<li>" + favorite3 + "</li>" +
                    "</ol";

        return choices;


    }

}
