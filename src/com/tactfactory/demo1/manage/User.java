package com.tactfactory.demo1.manage;

import java.util.Date;

/** User class, for manage user. */
public class User {

    // Attributes section.

    /** Firstname of User. */
    protected String  firstName = "";

    /** Lastname of User. */
    protected String  lastName = "";

    /** Date of Birth of User. */
    protected Date    dob = null;

    /** Height of user in Centimeter. */
    protected Integer height = 50;

    // Methods section.

    /**
     * Constructor of User.
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
//        //FIXME(Theos) : Why null ?
//        this.dob       = null;
//        this.height    = 50;
    }

//    /** Destructor of User. */
//    public void dispose() {
//        //TODO(Theos) : Release all resources.
//        this.firstName = null;
//        this.lastName = null;
//        this.dob = null;
//        this.height = Integer.MIN_VALUE;
//    }

    /**
     * Display full name of User.
     * @return String with firstname and lastname.
     */
    public String displayName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    /**
     * My personal function.
     * @param param1 the Xxxx parameter.
     * @param param2 the Yyyy parameter.
     * @return the value of Zzzzz.
     */
    public String toto(String param1, Integer param2) {
        return null;
    }

    /**
     * @return the fisrtName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param fisrtName the fisrtName to set
     */
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * @param dob the dob to set
     */
    public User setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * @param height the height to set
     */
    public User setHeight(Integer height) {
        this.height = height;
        return this;
    }

}
