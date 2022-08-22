package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.pdf.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BrowserController {

    @Autowired
    private BrowserService service;

    @PostMapping(value = "/consume-url")
    public void initConsumer() {
        service.getFromUrl("https://stackoverflow.com/questions/25418958/unable-to-open-chrome-using-selenium");
    }

}