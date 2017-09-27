package com.tactfactory.demo1.lang;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tactfactory.demo1.calculator.command.AddCommand;
import com.tactfactory.demo1.manage.User;

public class DemoReflexion {

    public static void run() {

        String toto = "Hello W!";
        AddCommand com = new AddCommand();

        System.out.println(toto);

        // Introspection sur les types.
        Class<?> type = com.getClass().getSuperclass().getInterfaces()[0];
        System.out.println(type.getSimpleName());

        // Introspection des Methodes.
        Method[] methods = com.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(
                    String.format("[%s] %s : %s",
                            method.getModifiers(),
                            method.getName(),
                            method.getReturnType()
                            ));
        }

        // Introspection des propriété de classe.
        Field[] fields = com.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }


        // Appel d'une methodes
        User user = new User("Mickael", "Gaillard");

        // Mode normal
        String t = user.displayName();

        try {
            Method m = User.class.getMethod("displayName", null);

            // Mode Reflexion
            String toStringContent = (String)m.invoke(user, null);


            System.out.println(toStringContent);

        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
