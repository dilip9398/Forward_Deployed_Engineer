package com.example.demo.ai_tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherTool {

    private final RestClient restClient;
    private final String apikey;

    public WeatherTool(RestClient.Builder builder, @Value("3002dc2751514867a94152735261409") String apikey){
        this.restClient = builder.baseUrl("https://api.weatherapi.com/v1").build();
        this.apikey = apikey;
    }

    @Tool(description = "Get current city weather Condition")
    public String currentWeather(
            @ToolParam(description = "Name of the City: ")
            String city){

        System.out.println("The weather api is used: ");

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key" , apikey)
                        .queryParam("q", city)
                        .build())
                .retrieve()
                .body(String.class);

    }


}
