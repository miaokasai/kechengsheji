package jieMi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class step2 {
    public static void main(String[] args) throws IOException {
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入解密文件的路径");
        String path = sc.next();
        System.out.println("请输入解密文件的名称");
        String name = sc.next();
        String all = path + "\\" + name;
        FileInputStream fis = new FileInputStream("src\\encrypted.txt");
        FileOutputStream fos = new FileOutputStream(all);
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 2);
        }
        fos.close();
        fis.close();
        System.out.println("文件已解密完成，请到指定路径查看");
    }
}
