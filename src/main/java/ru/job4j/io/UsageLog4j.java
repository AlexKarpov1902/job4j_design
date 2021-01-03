package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Алексей Карпов";
        int varInt = 33;
        float varFloat = 3.14546f;
        char varChar = 'd';
        byte varByte = 10;
        short varShort = 325;
        boolean varBool = true;
        long varLong = 345L;
        LOG.debug("User info name : {}, age : {}", name, varInt);
        LOG.debug("Info byte: {}, short: {}, long: {}, float: {}", varByte, varShort, varLong, varFloat);
        LOG.debug("Info Char: {}, boolean: {}", varChar, varBool);
    }
}