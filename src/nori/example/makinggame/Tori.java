package nori.example.makinggame;

import java.io.IOException;

public class Tori extends Character {

    public Tori(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    public Tori(){
        this(0, 0);
        this.setImage("/img/tori.png");
    }

    protected void setImage(String imagePath) {
        try {
            this.setImageFile(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setX(int x){
        if(x < 0){
            this.x = 0;
        }else if(x > Game.width){
            this.x = 980;
        }else{
            this.x = x;
        }
    }
    public void setY(int y){
        if(y < 0){
            this.y = 0;
        }else if(y > Game.height){
            this.y = 720;
        }else{
            this.y = y;
        }
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

}