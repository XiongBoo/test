package caculate;

/**
 * Created by Administrator on 2015/12/24.
 */
public class Function {

    /**
     * 加减乘除的用算
     * @param No1 第一个传进来的值
     * @param Mark 运算符号
     * @param No2 第二个及以后传进来的值
     * @return 返回计算之后的值
     */
    public double getResult(double No1,String Mark,double No2){
        if(Mark.equals("+")){
            return   No1+No2;
        }else if(Mark.equals("-")){
            return   No1-No2;
        }else if(Mark.equals("*")){
            return   No1*No2;
        }else if (Mark.equals("/")){
            return   No1/No2;
        }
        return 0;
    }

    /**
     * 求平方
     * @param No1 需要求平方的数
     * @return   返回的平方值
     */
    public double getsquare(double No1){
        return No1*No1;
    }

    /**
     * 求立方
     * @param No1 需要求立方的数
     * @return 返回立方值
     */
    public double getCube(double No1){
        return No1*No1*No1;
    }

    /**
     * 求一个数的n次幂
     * @param No1 需要求的数
     * @param No2 需要求的n次幂
     * @return 返回为No1的No2次幂的值
     */
    public double getAnswer(double No1,double No2){
        double anser=1;
        for(int i=0;i<No2;i++){
            anser*=No1;
        }
        return anser;
    }

    /**
     * 和下面的方法getTow共同构成了求一个数的二进制方法
     * @param No1 需要求二进制的数
     * @return 返回的是数组的长度。是通过对No1除2 的到的长度
     */
    public int getTow1(int No1){
        int i=0;
        while (!(No1==0)){
            No1=No1/2;
            i++;
        }
        return i;
    }

    /**
     * 和上面的方法getTow1共同构成了求一个数的二进制方法
     * @param i     上面的方法getTow1的返回值
     * @param No1    需要被求为二进制的数
     * @return    返回的是一个数组，数组的值反向输出就是No1所对应的二进制值
     */
    public int[] getTow(int i,int No1){
        int[] a = new int[i];
        for (int j = 0; j < i; j++) {
            a[j] = No1 % 2;
            No1 = No1 / 2;
            i++;
            if (No1 == 0) {
                break;
            }
        }
        return a;
    }
}
