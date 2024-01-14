package com.mod.pestmod.command.commands;

import com.mod.pestmod.command.Command;
import com.mod.pestmod.util.AudioUtil;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFourPestNotificationCommand extends Command {
    public TestFourPestNotificationCommand() {
        super("Stimulates what happens when 4+ pests invade your Garden.");
    }
    @Override
    public String getCommandName() {
        return "pntest4notification";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pntest4notification";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String directory = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier\\fourPestsNotification.wav";
        if (Files.exists(Paths.get(directory))) {
            ChatUtil.sendClientChatMessage("Testing...");
            AudioUtil.playSoundAsync(directory, 1);
        } else {
            ChatUtil.trySendClientChatMessage("Sound file for 4+ pests not found, aborting test.");
        }

        }
    }

