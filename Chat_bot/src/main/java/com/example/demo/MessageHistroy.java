package com.example.demo;


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

    private List<Message> history = new ArrayList<>();



    public MessageHistroy(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }


    public String message(String message){

        String prompt = """ 
                Your are the college Assistant Your work is tho solve the 
                student Queries, about the Admissions, Courses Available (like B Tech, M tech,
                Diploma, Pharmacy) and then the like in the B tech cse, ECE, technical, data science, eee
                
                
                only give the this details, do not give another answers that are not related to the
                college.
                Always give a welcome message that our welcome to Siddhartha institute of technology.
                If they ask any unrelated to the college then say that is beyond my limits.
                or I cannot get that information sorry for incovience
                Always answer short and in bullet points """
                ;

        history.add(new UserMessage(message));

        String output = chatClient.prompt()
                .system(prompt)
                .messages(history)
                .call()
                .content();

        history.add(new AssistantMessage(output));

        return output;
    }

}



