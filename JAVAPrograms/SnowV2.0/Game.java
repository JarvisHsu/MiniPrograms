//package Snow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame {
    // 存放雪花对象
    private static List<Snow> list = new ArrayList<>();
    public final static int Width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public final static int Height = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args) {
        // 创建窗口
        Game game = new Game();
        //设置窗口大小
        //game.setSize(500,300);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        game.setSize(screenSize);
        //隐藏标题栏
        game.setUndecorated(true);
        //设置窗口背景色为透明
        game.setBackground(new Color(0,0,0,0));
        //创建出雪花
        game.createSnow();
        //重写父类paint方法，将snow画在窗口上
        // 每隔100毫秒重绘一次
        game.action();
        // 显示窗口
        game.setVisible(true);
    }
    /**
     * 每隔100毫秒重绘一次
     */
    private void action(){
        // 启动任务
        Timer timer = new Timer();
        //创建任务类
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 调用父类的方法，重绘
                repaint();
                }
            };
        // 启动  立即启动任务，每隔1秒回执行一次run方法
        timer.schedule(timerTask,0,10);
    }
    /**
     * 每隔1秒钟创建一个,创建出1000个雪花对象,把雪花对象存入到list集合中
     */
    private void createSnow() {
        // 启动任务
        Timer timer = new Timer();
        //创建任务类
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 创建雪花对象
                Snow snow = new Snow();
                //存入list集合
                list.add(snow);
//                if(list.size() == 10000){
//                    // 取消定时任务
//                    timer.cancel();
//                }
            }
        };
        // 启动  立即启动任务，每隔1秒回执行一次run方法
        timer.schedule(timerTask,0,200);
    }
    //重写父类paint方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //从list中获取snow对象，把snow画在窗口上
        for (int i = 0; i < list.size(); i++) {
            //获取snow对象
            Snow snow = list.get(i);
            //画
            g.drawImage(snow.getBufferedImage(),(int)snow.getX(),(int)snow.getY(),snow.getWidth(),snow.getHeight(),null);
            //调用移动方法
            snow.move();
        }
    }

    public static List<Snow> getList() {
        return list;
    }
}
