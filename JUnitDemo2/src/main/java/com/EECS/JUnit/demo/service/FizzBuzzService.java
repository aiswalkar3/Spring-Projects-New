package com.EECS.JUnit.demo.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {
        if(number <= 0)
        {
            throw new IllegalArgumentException("Incorrect input. Please send numbers > 0");
        }
        if(number%3 == 0 && number%5 == 0)
        {
            return "FizzBuzz";
        }
        else if(number%3 == 0){
            return "Fizz";
        }
        else if(number%5 == 0){
            return "Buzz";
        }
        else{
            return number + "";
        }
    }
}
