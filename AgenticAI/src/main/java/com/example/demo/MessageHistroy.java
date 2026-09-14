package com.example.demo;


import com.example.demo.ai_tools.CalculatorTool;
import com.example.demo.ai_tools.WeatherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageHistroy {


    private ChatClient chatClient;
    private CalculatorTool calculatertool;
    private WeatherTool weatherTool;


    private List<Message> history = new ArrayList<>();



    public MessageHistroy(ChatClient.Builder builder, CalculatorTool calculatertool,
                          WeatherTool weatherTool){
        this.chatClient = builder.build();
        this.calculatertool = calculatertool;
        this.weatherTool = weatherTool;
    }


    public String message(String message){

        String prompt = """ 
               Your are the External Chat bot Assistant where you help with the general activities
               like the calculation, weather updates, and currency Exchange.
               
               For this you would use the tools in the for the operations like calculation tool
               weather tool, and currency tool
               
               
               1. Use the specific tools for the specific queries.
               2. Give the answer in the simple and natural language
               3.Give me the 1-2 line answers
               4.Always use the tools for the Requirement
               5. Never give me the estimate answer, be natural and give the relevant answer
               """
                ;

        history.add(new UserMessage(message));

        String output = chatClient.prompt()
                .system(prompt)
                .messages(history)
                .tools(calculatertool, weatherTool)
                .call()
                .content();

        history.add(new AssistantMessage(output));

        return output;
    }

}



