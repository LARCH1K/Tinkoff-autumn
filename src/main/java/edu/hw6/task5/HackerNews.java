package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String NEWS_URL_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private static final int SUCCESS_STATUS = 200;

    public long[] hackerNewsTopStories() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == SUCCESS_STATUS) {
                String[] idStrings = response.body().replaceAll("[\\[\\]\"]", "").split(",");
                long[] ids = new long[idStrings.length];
                for (int i = 0; i < idStrings.length; i++) {
                    ids[i] = Long.parseLong(idStrings[i].trim());
                }
                return ids;
            }
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }

        return new long[0];
    }

    public String news(long id) {
        try (HttpClient client = HttpClient.newHttpClient();) {
            String url = String.format(NEWS_URL_TEMPLATE, id);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == SUCCESS_STATUS) {
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(response.body());
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (IOException | InterruptedException e) {
            return "";
        }

        return "";
    }
}
