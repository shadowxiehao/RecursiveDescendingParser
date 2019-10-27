import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String arg[]){
        System.out.println("Please enter an arithmetic expression to analyse!");
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String expression;
        try {
            expression = in.readLine()+"#";//结尾加个#结束符
            Analysis test=new Analysis(expression);
            test.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("输入出错！");
        }
    }
}
