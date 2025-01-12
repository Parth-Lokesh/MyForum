package com.myforum.controller;

import com.myforum.config.AstraConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfileController {

    private final RestTemplate restTemplate;
    private final AstraConfig astraConfig;
    private final String apiUrl;

    public ProfileController(RestTemplate restTemplate, AstraConfig astraConfig) {
        this.restTemplate = restTemplate;
        this.astraConfig = astraConfig;
        this.apiUrl = "https://" + astraConfig.getAstraId() + "-" + astraConfig.getAstraRegion()
                      + ".apps.astra.datastax.com/api/rest/v2/keyspaces/" + astraConfig.getAstraKeyspace() + "/user";
    }

    public String insertUser(String login, String nodeId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Cassandra-Token", astraConfig.getAstraToken());
            headers.set("Content-Type", "application/json");

            Map<String, Object> body = new HashMap<>();
            body.put("node_id", nodeId);
            body.put("login", login);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return "User inserted successfully: " + response.getBody();
            } else {
                return "Failed to insert user. HTTP Status: " + response.getStatusCode();
            }
        } catch (Exception e) {
            return "Error inserting user: " + e.getMessage();
        }
    }

    @GetMapping("/profile")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> userAttributes = principal.getAttributes();

        String login = (String) userAttributes.get("login");
        String nodeId = (String) userAttributes.get("node_id");

        if (login != null && nodeId != null) {
            insertUser(login, nodeId);
        }

        return userAttributes;
    }
}
