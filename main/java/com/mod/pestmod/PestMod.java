package com.mod.pestmod;

import com.mod.pestmod.command.Command;
import com.mod.pestmod.command.CommandRepository;
import com.mod.pestmod.util.AudioUtil;
import com.mod.pestmod.util.FileUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.mod.pestmod.util.ChatUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Mod(modid = PestMod.MODID, version = PestMod.VERSION, name = "Pest Notifier", acceptedMinecraftVersions = "1.8.9", modLanguage = "java", clientSideOnly = true)
public final class PestMod
{
    public static final String MODID = "pestnotifier";
    public static final String VERSION = "1.0";
    public static  Logger logger;

static {
    logger = Logger.getLogger(PestMod.MODID);
}


    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        MinecraftForge.EVENT_BUS.register(this);

        for(Command c : CommandRepository.getInstance().getCommands()) {
            ClientCommandHandler.instance.registerCommand(c);
        }

        logger.info("Initializing...");
        ChatUtil.trySendClientChatMessage("PestNotifier locked and loaded!");
        {
            final Path DIRECTORY = Paths.get("C:\\Users\\" +  System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier");
            if (Files.exists(DIRECTORY) && Files.isDirectory(DIRECTORY)) {
                logger.info("PestNotifier path found!");
            }

             else {
                logger.info("PestNotifier directory not found, attempting to create and download files.");
                Files.createDirectories(DIRECTORY);
                FileUtil.downloadFileToLocation("https://www.dl.dropboxusercontent.com/scl/fi/7cjffxjni5q1ofhb77vxs/pestNotification.wav?rlkey=p0xrob472e5bd78tmbpt4fv5k&dl=0", DIRECTORY + "\\pestNotifier.wav");
                FileUtil.downloadFileToLocation("https://www.dl.dropboxusercontent.com/scl/fi/rfyxiyryzqvbpuh6dhfvi/fourPestsNotification.wav?rlkey=fcx95e7nxtwp1005ule0qzrwj&dl=0", DIRECTORY + "\\fourPestsNotification.wav");
            }
        }

    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
       if(Minecraft.getMinecraft().thePlayer != null) {
           for(String s : GlobalVariables.messageQueue) {
               ChatUtil.sendClientChatMessage(s);
           }
           GlobalVariables.messageQueue.clear();
       }
    }

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event) {
    //I DON'T KNOW WHAT MESSAGE THE SERVER SENDS SO IF THIS IS BAD CODE I REALLLY DON'T CARE
        String strippedMessage = event.message.getUnformattedText().replaceAll("§[0-9A-FK-ORa-fk-or]", "");
        strippedMessage = strippedMessage.replaceAll("(?i)§[0-9A-FK-OR]", ""); //paranoid double checking in case uOOA7 doesn't work
        strippedMessage = strippedMessage.replaceAll("[^a-z A-Z:0-9/'.]", "");
        if(!strippedMessage.contains(":")) {
            if(strippedMessage.contains("Pest")) {
                ChatUtil.trySendClientChatMessage("Pest detected!");
                if (GlobalVariables.regPestNoti) {playPestNotification();}
            }
            else if(strippedMessage.contains("reduced by")) {
                ChatUtil.trySendClientChatMessage("4+ Pests detected!");
                if (GlobalVariables.fourPestNoti) {playFourPestsNotification();}
            }
        }

    }

    public static void playPestNotification() {
        String directory = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier\\pestNotifier.wav";
        if (Files.exists(Paths.get(directory))) {
            AudioUtil.playSoundAsync(directory, 1);
        }


    }

    public static void playFourPestsNotification() {
        String directory = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\PestNotifier\\fourPestsNotification.wav";
        if (Files.exists(Paths.get(directory))) {
            AudioUtil.playSoundAsync(directory, 1);
        }
    }

}
