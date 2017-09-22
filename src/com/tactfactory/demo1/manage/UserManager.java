package com.tactfactory.demo1.manage;

public class UserManager {

    public static void test() {
//      User tmpUser;           // Declaration
//      tmpUser = new User();   // Initialize

      // Standard mode.
//      User user = new User("Mickael", "Gaillard");
//      user.setFirstName("Mickael"); // Use in constructor !!
//      user.setLastName("Gaillard");
//      user.setHeight(183);

      // Fluent mode.
      User user = new User("Mickael", "Gaillard")
          .setHeight(183);

      System.out.println(user.displayName());
    }
}
