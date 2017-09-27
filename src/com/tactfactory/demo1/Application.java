package com.tactfactory.demo1;

import com.tactfactory.demo1.calculator.Calculator;
import com.tactfactory.demo1.lang.DemoFile;
import com.tactfactory.demo1.lang.DemoReflexion;
import com.tactfactory.demo1.persistant.DemoJdbc;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //DemoException.run();
        //DemoList.run();
        //DemoReflexion.run();
        //DemoFile.run();
        //DemoJdbc.run();

        new Calculator().run();
    }
}







