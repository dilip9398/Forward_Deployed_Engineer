package com.example.demo.ai_tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {

    @Tool(description = "These is the operation that can perform the Calculation on the " +
            "operations like Add, subtract, multiply, divide, Square, mod")
    public  double calculate(
            @ToolParam( description = "This is the opeartion like add, subtract, divide, multiply, square, mod")
            String operation,
            @ToolParam(description = "First Element")
            double a,
            @ToolParam(description = "Second Element")
            double b){

        System.out.println("Calculator Tool called " );
        if(operation.equals("add")){
            return a + b;
        } else if (operation.equals("subtract")) {
            return a - b;
        } else if (operation.equals("divide")) {
            if (b == 0){
                throw new IllegalArgumentException("Cannot divide with the Zero");
            }
            return  a / b ;
        } else if (operation.equals("Multiply")) {
            return a * b;
        } else if (operation.equals("Mod")) {
            if (b == 0) throw new  IllegalArgumentException("Cannot divide with the zero");
            
            return  a % b;
        } else if (operation.equals("power")) {
            return  Math.pow(a, b);
        }else {
            throw new IllegalArgumentException("The Remaining Expression are not possible currently");
        }


    }



}
