package dvdplayer;

/**
 * Created by Administrator on 2015/12/23.
 */
public class Function {
    public static final int money=10;

    /**
     * 用户注册
     * @param userName 由用户输入传到Customer里面
     * @param password 由用户输入传到Customer里面
     * @return 返回当前对象
     */

    public static Customer register(String userName,String password) {
        Customer customer = new Customer();
        customer.setUserNames(userName);
        customer.setPasswords(password);
        customer.setMoney(Function.money);
        return customer;
    }

    /**
     * 修改密码
     * @param customer 修改密码需要当前用户
     * @param oldpassword 旧密码
     * @param newpassword 新密码
     * @return 返回是否修改密码成功
     */
    public static boolean changepass(Customer customer,String oldpassword,String newpassword){
        if (oldpassword.equals(newpassword)){
            return false;               //新密码与就密码相同时修改密码失败，返回false
        }else {
            customer.setPasswords(newpassword);
            return  true;               //新旧密码不同修改成功，返回true
        }
    }

    /**
     * 充值
     * @param customer  充值需要当前用户
     * @param money 需要充值的金额
     * @return  返回一个是否充值成功
     */
    public static boolean recharge(Customer customer,int money){
       if(money>0){
           customer.setMoney(money+customer.getMoney());
           return true;
       }else {
           return  false;
       }
    }

    /**
     * 生成随机数
     * @param movies
     * @return 返回的是随机获得的二位数组的第某一个数对象（电影的名字）
     */
    public static String[] randommovies(String[][] movies){
        int number=(int)(Math.random()*movies.length);//获得随机的电影
        return movies[number]; //
    }

    /**
     * 点播电影
     * @param customers   用户
     * @param movie    点播的电影
     * @return      返回的是是否点播成功 成功为true  不成功为false
     */
    public static boolean paly(Customer customers,String[] movie){
        int coin= Integer.parseInt(movie[1]);//获得电影的价格 需要强制将String类型转化为int类型
       if(customers.getMoney()>=coin){
           customers.setMoney(customers.getMoney()-coin);//消费修改客户后的账户余额
           return true;
       }else {
           return false;
       }
    }

    /**
     * 加载登陆中
     */
    public static void loading(){
        for(int i=0;i<10;i++){
            System.out.print("●");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
