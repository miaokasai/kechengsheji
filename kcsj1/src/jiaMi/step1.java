package jiaMi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class step1 {
    public static void main(String[] args) throws IOException {
        int a = 0;
        int b = 0;
        byte[] bytes = new byte[1024 * 1024 * 10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要加密的文本文件所在的位置");
        String path = sc.next();
        System.out.println("请输入需要加密的文件名");
        String name = sc.next();
        String all = path + "\\" + name;
        FileInputStream fis1 = new FileInputStream(all);
        FileOutputStream fos1 = new FileOutputStream("src\\orginal.txt");
        //先将要加密的文件拷贝到orginal.txt中。
        while ((a = fis1.read(bytes)) != -1) {
            fos1.write(bytes, 0, a);
        }
        fos1.close();
        fis1.close();
        //再将orginal.txt中的文件进行加密并放入encrypted.txt中。
        FileInputStream fis2 = new FileInputStream("src\\orginal.txt");
        FileOutputStream fos2 = new FileOutputStream("src\\encrypted.txt");
        while ((b = fis2.read()) != -1) {
            fos2.write(b ^ 2);
        }
        fos2.close();
        fis2.close();
        System.out.println("已完成加密");
    }
}
