package com.beyond.languagedetectorservice.controller;

import com.beyond.languagedetectorservice.service.LanguageDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(method = RequestMethod.POST, value = "/v1")
public class LanguageDetectorController {

    private LanguageDetectorService service;

    @PostMapping("/detect")
    public String detectLanguageByText(@RequestBody String text) {
        return service.detectLanguageOf(text);
    }

    @Autowired
    public void setService(LanguageDetectorService service) {
        this.service = service;
    }
}
