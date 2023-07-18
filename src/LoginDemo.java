import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginDemo {

    public static void main(String[] args) {

        System.out.println("************************");
        //登录
        //输入账号密码, 成功继续, 失败重试
        System.out.println("欢迎进入购物系统, 请登录: ");
        boolean isLoginSuccessful = false;
        String account = "123";
        String password = "321";
        while (!isLoginSuccessful) {
            System.out.println("输入账号:");
            Scanner scanner1 = new Scanner(System.in);
            String inputAccount = scanner1.next();

//            scanner1.close();

            System.out.println("输入密码:");
            Scanner scanner2 = new Scanner(System.in);
            String inputPassword = scanner2.next();

//            scanner2.close();

            if (inputAccount.equals(account) && inputPassword.equals(password)) {
                isLoginSuccessful=true;
                System.out.println("登录成功!");
            }else{
                System.out.println("账号或密码输入错误, 请重新输入!");
            }
        }
        System.out.println("************************");


        //商品信息循环输入(选择商品, 输入数量, 计算总价)
        //1 T恤 单价250
        //2 网球拍 单价200
        //3 球鞋 单价300
        double totalPrice;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        boolean isEnterSuccessful = false;
        Scanner scanner4 = new Scanner(System.in);
        while (!isEnterSuccessful){
            System.out.println("请选择商品: \n" +
                    "1 T恤 单价250\n" +
                    "2 网球拍 单价200\n" +
                    "3 球鞋 单价300");
            Scanner scanner3 = new Scanner(System.in);
            int input = scanner3.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("请输入T恤的数量:");
                    count1 += scanner4.nextInt();
                    System.out.println("当前T恤总数量: "+count1);

                    System.out.println("是否继续录入? y/n");
                    Scanner scanner5 = new Scanner(System.in);
                    if(scanner5.next().equals("n")){
                        isEnterSuccessful = true;
                    }

//                  scanner5.close();
                    break;
                }
                case 2: {
                    System.out.println("请输入网球拍的数量:");
                    count2 += scanner4.nextInt();
                    System.out.println("当前网球拍总数量: "+count2);

                    System.out.println("是否继续录入? y/n");
                    Scanner scanner5 = new Scanner(System.in);
                    if(scanner5.next().equals("n")){
                        isEnterSuccessful = true;
                    }
//                  scanner5.close();
                    break;
                }
                case 3: {
                    System.out.println("请输入球鞋的数量:");
                    count3 += scanner4.nextInt();
                    System.out.println("当前球鞋总数量: "+count3);

                    System.out.println("是否继续录入? y/n");
                    Scanner scanner5 = new Scanner(System.in);
                    if(scanner5.next().equals("n")){
                        isEnterSuccessful = true;
                    }
//                    scanner5.close();
                    break;
                }
                default:{
                    System.out.println("ERROR");
                }
            }
//            scanner3.close();
        }
        System.out.println("************************");


        //会员信息输入, 是会员打八折
        double multiple = 1;
        System.out.println("您是会员吗? y/n");
        Scanner scanner6 = new Scanner(System.in);
        String isVIP = scanner6.next();
        if (isVIP.equals("y")){
            multiple = 0.9;
            System.out.println("好的, 会员九折");
        }
        double payment;
        System.out.println("请输入付款金额: ");
        Scanner scanner7 = new Scanner(System.in);
        payment = scanner7.nextDouble();

        System.out.println("************************");


        //商品结算(小票打印)
        //1 T恤 单价250
        //2 网球拍 单价200
        //3 球鞋 单价300
        System.out.println("T恤单价: 250  数量: "+count1+ "  总价: "+count1*250);
        System.out.println("网球拍单价: 200  数量: "+count2+ "  总价: "+count2*200);
        System.out.println("球鞋单价: 300  数量: "+count3+ "  总价: "+count3*300);
        totalPrice = (count1*250 + count2*200 + count3*300)*multiple;
        System.out.println("总价合计为: "+ totalPrice);
        System.out.println("付款金额为: " + payment);
        System.out.println("找零金额为: " + (payment-totalPrice));
        System.out.println("************************");


        //保存小票
        FileWriter writer = null;
        try {
            writer = new FileWriter("D:\\Code\\java\\7.17_Shopping\\resource\\ticket.txt", true);
            writer.write("T恤数量: " + count1 +"  总价: "+count1*250+ "\n");
            writer.write("网球拍数量: " + count2 +"  总价: "+count2*200+ "\n");
            writer.write("球鞋数量: " + count3 +"  总价: "+count3*300+ "\n");
            writer.write("折后价: " + totalPrice+"\n\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("保存失败");
            e.printStackTrace();
        }
    }


}
