//package MiniPrograms.TrainTickets;

//车票类
public class TrainTicket {
	//车票种类库，可添加其它种类
    public static final String[] TraTic={"宝鸡南-西安北","上海虹桥-西安北","上海虹桥-广州南","上海-广州东","北京西-广东南","天津-北京南"};
    private String TraSpecies;  //种类 格式"XX-XX"
    private int TraNum;         //张数 格式"xx"
    private int TraPrice;       //票价
	
	//无参，随机分配种类（可重载）
    public TrainTicket(){
        this.TraSpecies = TraTic[(int) (Math.random() * TraTic.length)];
        this.TraNum = (int)(Math.random()*10+1);
        this.TraPrice = (int)(Math.random()*50+20);
    }
	//显示车票的基本信息
    @Override
    public String toString() {
        return "种类:"+this.TraSpecies+" 票数:"+this.TraNum+"张"+" 票价:"+ this.TraPrice+"元";
    }
    //查票数
    public int searchTickets(){
        return getTraNum();
    }
	
	//自动生成get和set方法
    public String getTraSpecies() {
        return TraSpecies;
    }

    public void setTraSpecies(String traSpecies) {
        TraSpecies = traSpecies;
    }

    public int getTraNum() {
        return TraNum;
    }

    public void setTraNum(int traNum) {
        TraNum = traNum;
    }

    public int getTraPrice() {
        return TraPrice;
    }

    public void setTraPrice(int traPrice) {
        TraPrice = traPrice;
    }
}
