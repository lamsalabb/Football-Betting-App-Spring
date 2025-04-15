package com.project.springboot.footballapp.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIReturn {

    private static final String token = "4f7be6b2457d4583917f4dc7d77154bd";

    public static JsonNode getTable(){
        String apiUrl = "https://api.football-data.org/v4/competitions/PL/standings";

        try{
            URL url = new URL(apiUrl);


        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Auth-Token", token);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        conn.disconnect();

        String jsonString = response.toString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonString);


        JsonNode table = root.path("standings").get(0).path("table");
            System.out.println(table);
        return table;
        }
        catch (Exception e){
            throw new RuntimeException("Error!");
        }
    }

    public static JsonNode getUpcomingFixtures() {
        String apiUrl = "https://api.football-data.org/v4/competitions/PL/matches";

        try {
            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Auth-Token", token);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            conn.disconnect();

            String jsonString = response.toString();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonString);

            JsonNode matches = root.path("matches");

            return matches;

        } catch (Exception e) {
            throw new RuntimeException("Error retrieving upcoming fixtures!", e);
        }
    }
}
