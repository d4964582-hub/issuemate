package ru.daremor.issuemate.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import ru.daremor.issuemate.ai.AiService;

@RestController
public class AskController {

    private final AiService ai;

    public AskController(AiService ai) {
        this.ai = ai;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String q, HttpSession session) {
        return ai.ask(q, session.getId());
    }
}
