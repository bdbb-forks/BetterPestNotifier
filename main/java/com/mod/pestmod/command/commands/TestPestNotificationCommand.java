package com.mod.pestmod.command.commands;

import com.mod.pestmod.command.Command;
import com.mod.pestmod.util.AudioUtil;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestPestNotificationCommand extends Command {
    public TestPestNotificationCommand() {
        super("Simulates what happens when a Pest appears.");
    }

    @Override
    public final String getCommandName() {
        return "pntestnotification";
    }

    @Override
    public final String getCommandUsage(ICommandSender sender) {
        return "/pntestnotification";
    }

    @Override
    public final void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String directory = "C:\\Users\\" +  System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier\\pestNotifier.wav";
        if(Files.exists(Paths.get(directory))) {
            ChatUtil.sendClientChatMessage("Testing...");
            AudioUtil.playSoundAsync(directory, 1);
        }
        else {
            ChatUtil.trySendClientChatMessage("Sound file for Pest notifications not found, aborting test.");
        }
    }

}
