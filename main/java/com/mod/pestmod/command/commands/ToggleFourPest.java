package com.mod.pestmod.command.commands;

import com.mod.pestmod.GlobalVariables;
import com.mod.pestmod.command.Command;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ToggleFourPest extends Command {
    public ToggleFourPest() {
        super("Toggles 4 pest spawn notifications");
    }

    @Override
    public String getCommandName() {
        return "pntoggle4pest";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pntoggle4pest";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        GlobalVariables.fourPestNoti = !GlobalVariables.fourPestNoti;
        if (GlobalVariables.fourPestNoti) {ChatUtil.trySendClientChatMessage("4 Pest spawn notifications on.");}
        else {ChatUtil.trySendClientChatMessage("4 Pest spawn notifications off.");}
    }
}
