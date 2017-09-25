package com.tactfactory.demo1.lang;

/**
 * Sample of Exceptions.
 */
public class DemoException {

    public static class MickaelException extends Exception {

        public MickaelException() { super(); }
        public MickaelException(String msg) {
            super(msg);
        }
    }


    /**
     * Receive propaged Exception
     */
    public void titi() {
        try {
            toto();
            // SI OK
        } catch (Exception e) {
            // SI KO
        }

        if (tutu()) {
            // SI OK
        } else {
            // SI KO
        }

    }

    public boolean tutu() {
        return true;
    }

    /**
     * Propaged Exception
     * @throws Exception
     */
    public void toto() throws MickaelException {
        if (true) { //....
            throw new MickaelException();
        }
    }

    /**
     * Sample of Simple Exception.
     */
    public static void run() {

        try {
            // Launch Exception
            throw new MickaelException("Msg perso...");

        } catch (MickaelException e) {
            // TODO: handle exception
        }

    }


}
