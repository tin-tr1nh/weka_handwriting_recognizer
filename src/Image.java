import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 51203 on 13-Apr-16.
 */
public class Image {
    public static BufferedImage getImageFromFile(String filePath) {
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

        return in;
    }
}
