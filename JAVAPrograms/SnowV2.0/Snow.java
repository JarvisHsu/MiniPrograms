//package Snow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Snow {
    // 定义图片的属性（存储雪花的图片）
    private BufferedImage bufferedImage;

    // x y 表示坐标
    private double x;
    private double y;
    // 添加移动的速度
    private double sx;
    private double sy;
    private  int width,height;

    private Random random = new Random();
    public Snow(){
        try {
            // 读取雪花图片
            bufferedImage = ImageIO.read(new File(".//snow2.png"));
            //雪花大小
            width = height =(int)(Math.random()*10+10);
            // x y值 坐标
            y = 0;
            // x的值随机产生
            x = random.nextInt(2000)+300;
            // 设置x和y的随机移动速度  1-5
            sx = random.nextDouble()*1+0.3;
            sy = random.nextDouble()*1+0.3;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 移动的方法
     */
    public void move(){
        if(x+width<0||y>Game.Height){
            Game.getList().remove(this);
        }
        x -= sx;
        y += sy;
    }

    /**
     * 生成get和set方法
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public double getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
