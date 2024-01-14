package com.mod.pestmod.command.commands;

import com.mod.pestmod.command.Command;
import com.mod.pestmod.util.ChatUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;

public class DirectoryCommand extends Command {
    public DirectoryCommand() {
        super("Opens the PestNotifier directory.");
    }


    @Override
    public String getCommandName() {
        return "pndirectory";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/pndirectory";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
            if(System.getProperty("os.name").toLowerCase().contains("win")) {
                try {
                    Runtime.getRuntime().exec("explorer.exe /select," + Paths.get("C:\\Users\\" +  System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier\\"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                ChatUtil.trySendClientChatMessage("Directory command only supported for Windows operating systems.");
            }
    }
}
