package com.mod.pestmod.util;

import com.mod.pestmod.PestMod;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class FileUtil {
    private FileUtil() {

    }

    public static void downloadFileToLocation(final String fileUrl, final String destinationPath) {
        try {
            URLConnection connection = new URL(fileUrl).openConnection();

            try (InputStream in = connection.getInputStream()) {
                final Path DESTINATION = Paths.get(destinationPath);
                Files.copy(in, DESTINATION, StandardCopyOption.REPLACE_EXISTING);
                PestMod.logger.info("Successfully downloaded file from url: " + fileUrl + " to: " + destinationPath);
            }
        } catch (IOException e) {
            PestMod.logger.info("Failed to download file: " + fileUrl + " to" + destinationPath);
            e.printStackTrace();
        }
    }

    //Isn't being used for RATS, yay!
}
