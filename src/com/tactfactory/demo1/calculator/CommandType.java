package com.tactfactory.demo1.calculator;

public enum CommandType {
    Unknow(0, null),   // Unknow = 0 (.net)
    Quit(9, null),
    Addition(1, AddCommand.class),
    Subtraction(2, SubCommand.class),
    Multiplication(3, MultiCommand.class),
    Division(4, DivCommand.class),
    ListHistory(7, null),
    CleanHistory(8, null);

    private Integer value;
    private Class   type;

    private CommandType(Integer value, Class type) {
        this.value = value;
        this.type = type;
    }

    public Integer getValue() {
        return this.value;
    }

    public Class getType() {
        return this.type;
    }

    public static CommandType parse(Integer displayAndAsk) {
        CommandType ret = null;
        if (displayAndAsk != null) {
            for (final CommandType type : CommandType.values()) {
                if (displayAndAsk == type.value) {
                    ret = type;
                }
            }
        }

        return ret;
    }
}
