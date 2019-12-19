//package MiniPrograms.TrainTickets;

public class Client {
    private String User;    //用户名
    private String UID;     //编号
    private int Balance;    //余额
    
    //初始化用户信息，用户编号与携带金额系统随机分配。
    public Client(String user){
        this.User = user;
        this.UID = String.valueOf((int)(Math.random()*199999+100000));
        this.Balance = (int)(Math.random()*1000+1);
    }

    //用户买票方法
    public void buyTraTicket(TrainTicket trainTicket){
        System.out.println("行车区间为:"+trainTicket.getTraSpecies()+"的车，当前的车票数为"+trainTicket.getTraNum());
        if(this.Balance < trainTicket.getTraPrice()){
            System.out.println("您的余额不足");
            return;
        }
        if(trainTicket.getTraNum()<1){
            System.out.println("车票数不足");
            return;
        }
        this.Balance -= trainTicket.getTraPrice();
        trainTicket.setTraNum(trainTicket.getTraNum()-1);
        System.out.println("购买成功 "+"当前余票:"+trainTicket.getTraNum()+"张");
        System.out.println("购票信息:"+this.User+"的"+trainTicket.getTraSpecies()+"车票已经成功购买!祝您旅途愉快");
    }
    //用户基本信息toString重写
    @Override
    public String toString() {
        return "编号:"+this.UID+" 用户名:"+this.User+" 账户金额:"+this.Balance+"元";
    }

    //自动生成的get和set方法
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
