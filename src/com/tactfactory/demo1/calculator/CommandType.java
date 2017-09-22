package com.tactfactory.demo1.calculator;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.demo1.calculator.command.AddCommand;
import com.tactfactory.demo1.calculator.command.CleanHistoryCommand;
import com.tactfactory.demo1.calculator.command.DivCommand;
import com.tactfactory.demo1.calculator.command.ListHistoryCommand;
import com.tactfactory.demo1.calculator.command.MultiCommand;
import com.tactfactory.demo1.calculator.command.QuitCommand;
import com.tactfactory.demo1.calculator.command.SubCommand;
import com.tactfactory.demo1.calculator.command.UnknowCommand;

/**
 * Enumerator of commands available.
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public enum CommandType {
    Unknow          (0, null, UnknowCommand.class),   // Unknow = 0 (.net)
    Addition        (1, "Addition", AddCommand.class),
    Subtraction     (2, "Subtraction", SubCommand.class),
    Multiplication  (3, "Multiplication", MultiCommand.class),
    Division        (4, "Division", DivCommand.class),
    ListHistory     (7, "Display History", ListHistoryCommand.class),
    CleanHistory    (8, "Clear History", CleanHistoryCommand.class),
    Quit            (9, "Quit", QuitCommand.class);

    private final Integer value;
    private final String title;
    private final Class<?> type;

    private CommandType(final Integer value, final String title, final Class<?> type) {
        this.value = value;
        this.title = title;
        this.type = type;
    }

    public Command makeCommand() {
        Command result = null;

        if (this.type != null) {
            try {
                result = (Command) this.type.newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

    public static List<CommandType> getAvailableUserCommand() {
        List<CommandType> result = new ArrayList<CommandType>();

        for (final CommandType type : CommandType.values()) {
            if (type.value > 0) { //FIXME() : Add check if internal
                result.add(type);
            }
        }

        return result;
    }

    public static CommandType parse(final Integer displayAndAsk) {
        CommandType ret = null;

        if (displayAndAsk != null) {
            for (final CommandType type : CommandType.values()) {
                if (displayAndAsk == type.value) {
                    ret = type;
                    break; // Optimization
                }
            }
        }

        if (ret == null) {
            ret = CommandType.Unknow;
        }

        return ret;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getTitle() {
        return this.title;
    }

    public Class<?> getType() {
        return this.type;
    }
}
