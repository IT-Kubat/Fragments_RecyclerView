package com.example.fragmentsrecyclerview2;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", "Timur Shambetov", "0500700430"));
        cars.add(new Car("Mercedes", "S-class", "Aybek Alymkulov", "0505250032"));
        cars.add(new Car("Honda", "Inspire", "Bakyt Abdiyev", "0702777632"));
        cars.add(new Car("Lexus", "RX350", "Kubat Abdullaev", "0778700430"));
    }
}
