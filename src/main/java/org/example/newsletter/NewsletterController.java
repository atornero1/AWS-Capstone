package org.example.newsletter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsletterController {

    private final DynamoService dynamoService;

    public NewsletterController(DynamoService dynamoService) {
        this.dynamoService = dynamoService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/newsletter")
    public String newsletter() {
        return "newsletter";
    }

    @PostMapping("/subscribe")
    public String signUp(@RequestParam String email) {
        try {
            dynamoService.saveUser(email);
            return "redirect:/newsletter?success";
        } catch (Exception e) {
            System.out.println("Failed to save newsletter signup: " + e.getMessage());
            return "redirect:/newsletter?error";
        }
    }
}