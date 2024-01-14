package com.mod.pestmod.command;

import com.mod.pestmod.command.commands.DirectoryCommand;
import com.mod.pestmod.command.commands.HelpCommand;
import com.mod.pestmod.command.commands.TestFourPestNotificationCommand;
import com.mod.pestmod.command.commands.TestPestNotificationCommand;

public final class CommandRepository {
    private static CommandRepository commandRepository;
    private final Command[] COMMANDS = {new TestPestNotificationCommand(), new TestFourPestNotificationCommand(), new HelpCommand(), new DirectoryCommand()};


    private CommandRepository() {
    }

    public static CommandRepository getInstance() {
        if(commandRepository == null) {
            commandRepository = new CommandRepository();
        }
        return commandRepository;
    }

    public Command[] getCommands() {
        return COMMANDS;
    }

    //Two java design patterns in one! Strike!
}
