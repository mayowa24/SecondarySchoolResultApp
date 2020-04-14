/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omc.com;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author HP-PC
 */
public class imageUtil {
    public static byte[] imageToByteArray(BufferedImage bufferedImage) {
        byte[] imageInByte = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return imageInByte;
    }

    public static BufferedImage byteArrayToBufferedImage(byte[] imageInByte) {
        InputStream is = new ByteArrayInputStream(imageInByte);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(is);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return bufferedImage;
    }
     public static Image scaleimage(BufferedImage bufferedImage, int width, int height) {
        Image scaledInstance = bufferedImage.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
        return scaledInstance;
  }

  public static Image getScaledImage(byte[] imageArray, JLabel label) {
    BufferedImage bufferedImage = byteArrayToBufferedImage(imageArray);
    Image scaleimage = scaleimage(bufferedImage, label.getWidth(), label.getHeight());
    return scaleimage;
  }
}
