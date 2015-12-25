        package caculate;

        import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/24.
 */
public class MainInfo {
    public static void main(String[] args){
        double result;
        double No1;
        String mark;
        double No2=0;
        Scanner input=new Scanner(System.in);
        Function function=new Function();
        System.out.println("1.多个数的加减乘除运算、2.任意数的平方、3任意数的立方、4.任意数的幂次方值、5.计算任意数的二进制数");
        byte num=input.nextByte();
        switch (num) {
            case 1://多个数的加减乘除运算
            System.out.println("请输入你要计算的数：");
            No1 = input.nextDouble();
            mark = input.next();
            do {
                No2 = input.nextDouble();
                result = function.getResult(No1, mark, No2);
                No1 = result;
                mark = input.next();
            } while (!mark.equals("="));
            System.out.println("结果是：" + result);
                break;
            case 2://任意数的平方
                System.out.println("请输入你要计算的数：");
                No1 = input.nextDouble();
                result=function.getsquare(No1);
                System.out.println("结果是：" + result);
                break;
            case 3://任意数的立方
                System.out.println("请输入你要计算的数：");
                No1 = input.nextDouble();
                result=function.getCube(No1);
                System.out.println("结果是：" + result);
                break;
            case 4://任意数的幂次方值
                System.out.println("请输入你要计算的数：");
                No1 = input.nextDouble();
                No2 = input.nextDouble();
                result=function.getAnswer(No1,No2);
                System.out.println("结果是：" + result);
                break;
            case 5://计算任意数的二进制数
                int j=0;
                System.out.println("请输入你要计算的数：");
                No1 = input.nextDouble();
                if (No1==0){
                    System.out.print((int) No1 + "的二进制数为：0");
                }else {
                    int[] results = new int[function.getTow1((int) No1)];
                    results = function.getTow(function.getTow1((int) No1), (int) No1);
                    System.out.print((int) No1 + "的二进制数为：");
                    for (j = results.length - 1; j >= 0; j--) {
                        System.out.print(results[j]);
                    }
                }
                break;
            default:
                System.out.println("输入错误");
        }
    }
}

