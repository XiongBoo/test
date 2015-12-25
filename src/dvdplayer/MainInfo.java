package dvdplayer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/23.
 */
public class MainInfo {
    Scanner input=new Scanner(System.in);
    ArrayList<Customer> customers=new ArrayList<Customer>();//存储多个custoers的对象
    String[][] movies={{"宠物小精灵","5"},{"钢之炼金术师","4"},{"名侦探柯南","3"},{"千与千寻","3"},{"","5"}};//见一个二位数组装电影，前面是电影名字，后面是价格

    /**
     * 登录注册界面
     */
    public void login(){
        System.out.println("----------------------");
        System.out.println("|欢迎使用电影点播系统|");
        System.out.println("----------------------");
        System.out.println("①登录\t②注册\t\t当前注册人数为："+customers.size());
        System.out.println("请选择：");
        String choice=input.next();
        if(choice.equals("1")){
            System.out.println("-------------------------");
            System.out.println("|请输入账号密和码进行登录|");
            System.out.println("-------------------------");
            System.out.println("账号：");
            String userName=input.next();
            System.out.println("密码：");
            String password=input.next();
            Customer customer=null;//创建一个空的类型
            for(int i=0;i<customers.size();i++){
                if(customers.get(i).getUserNames().equals(userName)
                        &&customers.get(i).getPasswords().equals(password)){
                    // 账号密码正确跳出循环 获取这个类的对象并且赋值给customer；
                    customer=customers.get(i);
                    break;//退出循环
                }
            }
            //-------------------------------
            //正在登录（打印登录动画）
            System.out.println("正在登陆");
            Function.loading();
            //-------------------------------
            if(customer==null){
                System.out.println("登录失败，用户名或者密码不正确，即将返回登陆界面");
                Function.loading();//加载动画
                login();//调用自身返回主界面 ，递归算法

            }else {
                System.out.println("登录成功");
                mainInterface(customer);
            }

        }else if(choice.equals("2")){
            System.out.println("请输入账号：");
            String userName=input.next();
            System.out.println("请输入密码：");
            String password=input.next();
            Customer customer=Function.register(userName,password);//建立一个customer的对象来接受注册方法的返回值
            boolean isHas=false;//判断登录名字是否存在false是不存在。。。true是存在；
            for(int i=0;i<customers.size();i++){
                if(customers.get(i).getUserNames().equals(userName)){
                    isHas=true;
                    break;
                }
            }
            if(isHas){
                System.out.println("注册失败，该用户名已存在");
            }else {
                System.out.println("注册成功，系统赠送你"+Function.money+"金币");
                customers.add(customer);
            }
            login();
        }else {
            System.out.println("请输入正确数字");
            login();
        }
    }


    /**
     * 系统主界面
     * @param customer 当前客户
     */
    public void mainInterface(Customer customer){
        System.out.println();
        System.out
                .println("**************************************************************************************");
        System.out.println(" \t\t\t* * * * * * 欢迎登陆影视娱乐点播系统！* * * * * *");
        System.out
                .println("**************************************************************************************");
        System.out
                .println("【1】.查询余额\t【2】.修改密码\t【3】.账户充值\t【4】.随机点播\t【5】.查看点播记录\t【6】.返回登录界面");

        System.out.println("请选择：");
        if(input.hasNextInt()){
            int choice=input.nextInt();
            switch (choice){
                case 1://查询余额
                    System.out.println("你的余额为"+customer.getMoney());
                    break;
                case 2://修改密码
                    System.out.println("请输入原密码：");
                    String oldpassword=input.next();
                    if(customer.getPasswords().equals(oldpassword)){//判断输入的密码是否是当前customer的密码
                        System.out.println("请输入新密码：");
                        String newpassword=input.next();
                        if(Function.changepass(customer,oldpassword,newpassword)){//调用改密码传值。Function的改密码功能的返回值控制输出
                            System.out.println("修改成功");
                        }else {
                            System.out.println("修改失败");
                        }
                    }else {
                        System.out.println("原密码不正确，无权修改");

                    }
                    break;
                case 3://账户充值
                    System.out.print("请输入充值金额：");
                    int money;
                    try {
                        money = Integer.parseInt(input.next());
                        if (Function.recharge(customer, money)) {
                            System.out.print("充值成功！您当前的金额为：" + customer.getMoney());
                        } else {
                            System.out.print("输入的金额格式不正确！");
                        }
                    } catch (Exception e) {
                        System.out.print("输入的金额格式不正确！");
                    }
                    break;
                case 4://随机点播
                    System.out.println("当前随机播放的电影有：");
                    for (int i=0;i<movies.length;i++){
                        System.out.print(movies[i][0]+"价格为："+movies[i][1]+"\t");
                    }
                    System.out.println();
                    String[] randMovies=Function.randommovies(movies);
                    System.out.println("你当前点播的是:"+randMovies[0]+"+播放的金额是："+randMovies[1]);
                    Function.loading();
                    if(Function.paly(customer,randMovies)){
                        System.out.println("点播成功，当前余额为"+customer.getMoney());
                    }else {
                        System.out.println("点播失败，余额不足");
                    }
                    break;
                case 5://查看记录
                    break;
                case 6:
                    System.out.println("谢谢使用本系统，欢迎你下次使用");
                    Function.loading();
                    login();
                    break;
                default:
                    System.out.println("输入错误，请输入正确选项");

            }
            mainInterface(customer);
        }
    }

    public static void main(String[] args){
        MainInfo mainInfo=new MainInfo();
        mainInfo.login();
    }
}
