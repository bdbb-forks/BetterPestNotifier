package com.mod.pestmod.util;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public final class AudioUtil {
    private AudioUtil() {

    }

    public static void playSoundAsync(final String FILE_PATH, final int ITERATE) {
        Thread soundThread = new Thread(() -> playSound(FILE_PATH, ITERATE));
        soundThread.start();
    }

    public static void playSound(final String FILE_PATH, final int ITERATE) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(FILE_PATH));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            for (int i = 0; i < ITERATE; i++) {
                clip.start();

                while (!clip.isRunning()) {
                    Thread.sleep(10);
                }

                while (clip.isRunning()) {
                    Thread.sleep(10);
                }

                clip.setFramePosition(0);
            }

            clip.close();
            audioInputStream.close();
            //Closing the stream to prevent a memory leak unlike Skyhanni

        } catch (UnsupportedAudioFileException | IOException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }

        //This was painful to make.
    }

}
