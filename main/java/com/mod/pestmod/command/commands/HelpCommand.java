package com.mod.pestmod.command.commands;

import com.mod.pestmod.command.Command;
import com.mod.pestmod.command.CommandRepository;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("Lists all the mod commands and their usages.");
    }

    @Override
    public String getCommandName() {
        return "pnhelp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pnhelp";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        for (Command c : CommandRepository.getInstance().getCommands()) {
            ChatUtil.trySendClientChatMessage(c.getCommandUsage(null) + " - " + c.getDescription()); //Get the description from the superclass method, pass null because I won't use sender.
        }
    }
}
