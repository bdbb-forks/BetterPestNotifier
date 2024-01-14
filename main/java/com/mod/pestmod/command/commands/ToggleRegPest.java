package com.mod.pestmod.command.commands;

import com.mod.pestmod.GlobalVariables;
import com.mod.pestmod.command.Command;
import com.mod.pestmod.command.CommandRepository;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ToggleRegPest extends Command {
    public ToggleRegPest() {
        super("Toggles pest spawn notifications");
    }

    @Override
    public String getCommandName() {
        return "pntogglepest";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pntogglepest";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        GlobalVariables.regPestNoti = !GlobalVariables.regPestNoti;
        if (GlobalVariables.regPestNoti) {ChatUtil.trySendClientChatMessage("Pest spawn notifications on.");}
        else {ChatUtil.trySendClientChatMessage("Pest spawn notifications off.");}
    }
}
