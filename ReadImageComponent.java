package com.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ReadImageComponent extends Component {//[100]
    BufferedImage bufferedImage = null;//[101]
    ReadImageComponent() throws IOException {//[102]
        String imageFilename = "C:\\Users\\akuta\\OneDrive\\画像\\Screenshots\\tamago2.png";//[103]
            bufferedImage = ImageIO.read(new File(imageFilename));//[105]
    }
    public void paint(Graphics graphics) {//[110]
        graphics.drawImage(bufferedImage, 0, 0, null);//[111]
    }
    public Dimension getPreferredSize() {//[120]
        int width = 100;//[123]
        int height = 100;//[134]
        if (bufferedImage != null) {//[125]
            width = bufferedImage.getWidth(null);//[126]
            height = bufferedImage.getHeight(null);//[127]
        }
        return new Dimension(width, height);//[128]
    }
    void writeImage() {//[130]
    }
}