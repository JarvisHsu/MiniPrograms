package MiniPrograms;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Image2Txt {
    protected static void create(File srcImgFile, File destAsciiImgFile){
        //字符由复杂到简单
        final String base = "@#&$%*o!;.";
        String result = "";
        try{
            //读取源图文件，将图片加载到内存中
            BufferedImage bufferedImage = ImageIO.read(srcImgFile);
            for (int i = 0; i < bufferedImage.getHeight(); i += (bufferedImage.getHeight()/(bufferedImage.getHeight()/10))) {
                //宽度
                for (int j = 0; j < bufferedImage.getWidth(); j += (bufferedImage.getHeight()/(bufferedImage.getHeight()/10))) {
                    int pixel = bufferedImage.getRGB(j, i);
                    // 将一个数字转换为RGB数字
                    int red = (pixel & 0xff0000) >> 16;
                    int green = (pixel & 0xff00) >> 8;
                    int blue = (pixel & 0xff);
                    //得到灰度值，公式：Gray = R*0.299 + G*0.587 + B*0.114
                    float gray = 0.299f * red + 0.578f * green + 0.114f * blue;
                    int index = Math.round(gray * (base.length() + 1) / 255);
                    result += index >= base.length() ? " " : String.valueOf(base.charAt(index));
                }
                result += "\r\n";
                //result += "\r\n";
            }
            //输出
            FileWriter fileWriter = new FileWriter(destAsciiImgFile);
            fileWriter.write(result);
            fileWriter.flush();
            //冲刷并关闭输出流
            fileWriter.close();
        }catch (IOException e){
            e.getMessage();
        }catch (Exception e){
            e.getMessage();
        }
    }
    public static void create(String srcImgFile, String destAsciiImgFile) {
        create(new File(srcImgFile),new File(destAsciiImgFile));
    }

    public static void main(String[] args) {
        //create("C:\\Users\\Lenovo\\Desktop\\Test\\1.jpg","C:\\Users\\Lenovo\\Desktop\\Test\\1.txt");
        //create("C:\\Users\\Lenovo\\Desktop\\Test\\2.jpg","C:\\Users\\Lenovo\\Desktop\\Test\\2.txt");
    }
}
