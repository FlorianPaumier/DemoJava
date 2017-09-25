package com.tactfactory.demo1;

import com.tactfactory.demo1.calculator.Calculator;
import com.tactfactory.demo1.lang.DemoReflexion;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //DemoException.run();
        //DemoList.run();
        DemoReflexion.run();

        new Calculator().run();
    }
}







