package com.mod.pestmod.util;

import com.mod.pestmod.GlobalVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public final class ChatUtil {
    private ChatUtil() {}

    public static void sendClientChatMessage(final String MESSAGE) {
        if(Minecraft.getMinecraft().thePlayer == null ) return;
        final EntityPlayer P = Minecraft.getMinecraft().thePlayer;
        P.addChatMessage(new ChatComponentText("[" + EnumChatFormatting.YELLOW
        + "Pest Notifier" + EnumChatFormatting.RESET + "] " + MESSAGE));
    }

    public static void trySendClientChatMessage(final String MESSAGE) {
        final EntityPlayer P = Minecraft.getMinecraft().thePlayer;
        if(P != null && P.worldObj != null) {
            sendClientChatMessage(MESSAGE);
        }
        else {
            GlobalVariables.messageQueue.add(MESSAGE);
        }
    }

    //This was the least painful to make




}
