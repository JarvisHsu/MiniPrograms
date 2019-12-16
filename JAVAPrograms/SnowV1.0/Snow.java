import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Snow {
    // 定义图片的属性（存储雪花的图片）
    private BufferedImage bufferedImage;

    // x y 表示坐标
    private int x;
    private int y;
    // 添加移动的速度
    private int sx;
    private int sy;

    private Random random = new Random();
    public Snow(){
        try {
            // 读取雪花图片
            bufferedImage = ImageIO.read(new File(".//snow.png"));
            // x y值 坐标
            y = 0;
            // x的值随机产生  1300 - 1799
            x = random.nextInt(500)+1300;

            // 设置x和y的随机移动速度  1-5
            sx = random.nextInt(5)+1;
            sy = random.nextInt(5)+1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 移动的方法
     */
    public void move(){
        x -= sx;
        y += sy;
    }

    /**
     * 生成get和set方法
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage
		    bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }
}
