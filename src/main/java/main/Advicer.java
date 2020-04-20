package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Advicer {

    public void showAdvice(String message) {
        try {
            if (SystemTray.isSupported()) {
                SystemTray tray = SystemTray.getSystemTray();
                BufferedImage bi = ImageIO.read(getClass().getClassLoader().getResource("icon.png"));
                TrayIcon trayIcon = new TrayIcon(bi);
                tray.add(trayIcon);
                trayIcon.displayMessage("Advice:", message, TrayIcon.MessageType.INFO);
            }
            Thread.sleep(10000);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}