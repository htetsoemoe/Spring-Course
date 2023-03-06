package com.demo.beans;

import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
@Priority(3)
public class SingYoYeYo implements Quest{
    @Override
    public String goQuest() {
        return "Knight is singing 'Yo Ye Yo' song.";
    }
}
