package com.tactfactory.demo1.lang;

import com.tactfactory.demo1.calculator.Command;
import com.tactfactory.demo1.calculator.command.AddCommand;
import com.tactfactory.demo1.manage.User;

public class DemoGeneric {

    public static class Dao<I, T> {

        public void create(T instance) {

        }

        public T read(I id) {
            return null;
        }

        public void update(T instance) {

        }

        public void delete(T instance) {

        }
    }

    public static class MickaelArrayList<T extends Command> {
        T[] internal;
        int currentIdx = 0;

        public int size() {
            return this.currentIdx;
        }
        public void add(T obj) {
            this.internal[this.currentIdx++] = obj;
        }

        public void remove(T obj) {
            for (int i = 0; i < internal.length; i++) {
                T object = internal[i];
                if (obj.equals(object)) {
                    internal[i] = internal[i+1];
                    this.currentIdx--;
                }
            }
        }
    }

    public static void run() {
        MickaelArrayList<AddCommand> listMG = new MickaelArrayList<>();

        listMG.add(new AddCommand());

        Dao<Integer, User> userDb = new Dao<>();
        userDb.create(new User("Mickael", "Gaillard"));

    }

}
