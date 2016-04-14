import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 51203 on 13-Apr-16.
 */
public class ImageHandler {
    public static double[] getImageFromFile(String filePath) {
        BufferedImage in = null;
        try {
            InputStream inputStream = new FileInputStream(filePath);
            in = ImageIO.read(inputStream);

            BufferedImage newImage = new BufferedImage(
                    in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_RGB);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] image = new int[256];

        BufferedImage scaledImage = createResizedCopy(in, 16, 16);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                image[i * 16 + j] = scaledImage.getData().getSample(j, i, 0);
            }
        }

        double[] scaledouble = scaleValueImage(image);

        return scaledouble;
    }

    static BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
        int imageType = BufferedImage.TYPE_BYTE_GRAY;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();

        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    static double[] scaleValueImage(int[] image) {
        double[] scaledImage = new double[image.length];
        for (int i = 0; i < image.length; i++) {
            double value = image[i];
            scaledImage[i] = -(value - 127) / 128;
        }
        return scaledImage;
    }
}
