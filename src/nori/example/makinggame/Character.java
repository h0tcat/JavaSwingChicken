package nori.example.makinggame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public abstract class Character {

    protected int x, y;
    private static Image imageFile;

    public abstract void setX(int x);
    public abstract void setY(int y);

    public abstract int getX();
    public abstract int getY();

    protected void setImageFile(String imageFilePath) throws IOException{
        imageFile = ImageIO.read(getClass().getResource(imageFilePath));
    }
    public Image getImageFile(){
        return imageFile;
    }
    protected abstract void setImage(String imagePath);
}
