package com.tactfactory.demo1.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DemoList {

    public static void run() {
        Object obj1 = new Object();
        Object obj2 = new Object();

        HashMap<String, Object> dico = new HashMap<String, Object>();
        System.out.println("Dico size : " + dico.size());

        dico.put("toto", obj1);
        System.out.println("Dico size : " + dico.size());

        dico.put("tutu", obj2);
        System.out.println("Dico size : " + dico.size());

        dico.get("tutu");

        // Key iteration
        for (String key : dico.keySet()) {
            Object obj = dico.get(key);
        }

        // Value iteration
        for (Object obj : dico.values()) {

        }

        // Key/value iteration
        for (Entry<String, Object> item : dico.entrySet()) {
            String key = item.getKey();
            Object value = item.getValue();
        }

        dico.remove("toto");
        System.out.println("Dico size : " + dico.size());

        testArrayList();
    }

    private static void testArrayList() {
        List<Object> list = new ArrayList<Object>();

        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("List size : " + list.size());

        if (!list.contains(obj1)) {
            list.add(obj1);
        }
        System.out.println("List size : " + list.size());

        list.get(0);

        for (Object object : list) {
//            if (object.getClass() == ????) {
//                return object;
//            }
        }

        list.add(obj2);
        System.out.println("List size : " + list.size());

        list.remove(obj1);
        System.out.println("List size : " + list.size());
    }

}
