package com.myforum.config;

import io.github.cdimascio.dotenv.Dotenv;

public class GithubConfig {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String clientId = dotenv.get("GITHUB_CLIENT_ID");
        String clientSecret = dotenv.get("GITHUB_CLIENT_SECRET");

        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
    }
}
