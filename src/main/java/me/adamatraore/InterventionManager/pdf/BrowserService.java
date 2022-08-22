package me.adamatraore.InterventionManager.pdf;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class BrowserService {

    @Autowired
    private ChromeDriver webDriver;

    private Logger logger = LoggerFactory.getLogger(BrowserService.class);

    public String getFromUrl(String url) {
        Pdf pdf = null;
        try {
            url = URLDecoder.decode(url, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        try {
            URL parsedURL = new URL(url);
            String basePath = parsedURL.getProtocol() + "://" + parsedURL.getHost() + ":" + parsedURL.getPort();
            webDriver.manage().window().maximize();
            webDriver.get("https://gif-dev-adherent-int.k8s-lyon.ouidou.fr/login");
            webDriver.getLocalStorage().setItem("wsp-gif-adherent", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb2RlQWRoZXJlbnQiOiIwMjAiLCJjb21wb3NhbnQiOiJBREhFUkVOVCIsImlkQWRoZXJlbnQiOjMsImlzcyI6ImF1dGgwIiwiaWRDb250YWN0QWRoZXJlbnQiOjYzLCJub20iOiJGUkFUQU5JIiwiaWRVc2VyIjo1MzksInRlbEZpeGUiOiIwNDk1MzAwMzcwIiwidGVsTW9iaWxlIjoiMDYxMjMwNTUwOSIsInNpdGVXc3BBZGhlcmVudEVuYWJsZWQiOnRydWUsImRyb2l0cyI6WyJnZXN0aW9uLWNsaWVudC1kZXRhaWwiLCJnZXN0aW9uLWNhdGFsb2d1ZS1wcm9kdWl0IiwiZ2VzdGlvbi1tYXJrZXRpbmctYWN0dS1hZGgiLCJnZXN0aW9uLWNvbmNlcHRpb24tcmVhbGlzYXRpb24iLCJnZXN0aW9uLW1hcmtldGluZy1wYXJhbS1tYWlsIiwiZ2VzdGlvbi1jbGllbnQtaW50ZXJ2LW1hdGVyaWVscyIsImdlc3Rpb24tbWFya2V0aW5nLW5ld3MtZ2lmIiwiaW5mby1zb2NpZXRlIiwiZ2VzdGlvbi1jb25mLWhvbWVwYWdlIiwiZ2VzdGlvbi1jbGllbnQiLCJiYXNlLWRvY3VtZW50YWlyZS1naWYiLCJnZXN0aW9uLWNsaWVudC1kZXZpcyIsImdlc3Rpb24tY2xpZW50LWN2cCIsImdlc3Rpb24tY21zIiwiZ2VzdGlvbi1jbGllbnQtYWNjZXMtZWNvbW1lcmNlIiwiZ2VzdGlvbi1tYXJrZXRpbmctYWN0dS1naWYiLCJ2aXN1LWZvdXJuaXNzZXVyLWN1cmUtZm9sZGVyIiwiZ2VzdGlvbi1kb2N1bWVudGF0aW9uLWFkaGVyZW50IiwiZ2VzdGlvbi1jbGllbnQtaGlzdG9yaXF1ZS1lbWFpbCIsImdlc3Rpb24tZG9jdW1lbnRhdGlvbi1mb3Vybmlzc2V1ciIsImdlc3Rpb24tY29uZi1hdHRyLWNsaWVudHMiLCJnZXN0aW9uLWNsaWVudC1wYXJjLW1hdGVyaWVscyIsImdlc3Rpb24tY29uZi1ib3V0aXF1ZSIsImdlc3Rpb24tY29uZi1jdnAiLCJnZXN0aW9uLW1hcmtldGluZy1uZXdzLWFkaCIsImhvbWUtcGFnZS1tYWdlbnRvIiwiZ2VzdGlvbi1tYXJrZXRpbmciLCJ0YWJsZXR0ZS1saXN0ZS1jbGllbnQtYWxsIl0sInNpdGVXc3BBZGhlcmVudCI6ImdpZi1yZWMtc2hvcC1wcm9tYXQiLCJleHAiOjE2NjEyMDk5MzUsInByZW5vbSI6IkFsYWluIiwiZW1haWwiOiJmcmF0YW5pd3NwQHlvcG1haWwuY29tIiwiY2l2aWxpdGUiOiJNb25zaWV1ciJ9.xtnEJMx6Gd8wZitSY5SbVg-KQqilgthZn0fVsml2ufI");
            webDriver.get("https://gif-dev-adherent-int.k8s-lyon.ouidou.fr/dashboard");
            pdf = webDriver.print(new PrintOptions());
            Files.write(Paths.get("./devis.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
            webDriver.quit();
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return pdf.getContent();
    }
}