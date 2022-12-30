package wanNianli;

import java.util.Scanner;

public class calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的年份");
        int year = sc.nextInt();
        System.out.println("请输入要查找的月份");
        int month = sc.nextInt();
        System.out.println("请输入要查找的日期");
        int day = sc.nextInt();
        int allYearDays = 0;
        int allMonthDays = 0;
        int monthDays = 0;
        int nowYear = year;
        int nowMonth = month;
        int remainder = 0;
        int remain = 0;
        String[] arr = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        //判断年份是闰年还是平年，并计算由1900年至去年年末共有多少天.
        for (int i = 1900; i < nowYear; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                allYearDays += 366;
            } else {
                allYearDays += 365;
            }
        }
        //计算去年年末至今年所在月月初共有多少天。
        for (int i = 1; i < nowMonth; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                allMonthDays += 30;
            } else if (i == 2) {
                if ((nowYear % 4 == 0 && nowYear % 100 != 0) || nowYear % 400 == 0) {
                    allMonthDays += 29;
                } else {
                    allMonthDays += 28;
                }
            } else {
                allMonthDays += 31;
            }
        }
        //计算总天数对7的余数由此判断所在月份第一天是星期几。
        remainder = (allMonthDays + allYearDays) % 7;
        //通过月份判断所在月有多少天。
        if (nowMonth == 4 || nowMonth == 6 || nowMonth == 9 || nowMonth == 11) {
            monthDays = 30;
        } else if (nowMonth == 2) {
            if ((nowYear % 4 == 0 && nowYear % 100 != 0) || nowYear % 400 == 0) {
                monthDays = 29;
            } else {
                monthDays = 28;
            }
        } else {
            monthDays = 31;
        }
        //计算总天数，并根据天数判断星期数。
        remain = (remainder + day) % 7;
        System.out.println(year + "年" + month + "月" + day + "日对应" + arr[remain - 1]);
        //依次将星期输出到控制台上。
        System.out.println("该月对应的日历为：");
        System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日");
        //通过打印空格控制所在月第一天对应正确的星期天数。
        for (int i = 0; i < remainder; i++) {
            System.out.print("    " + "\t");
        }
        //将对应的日期打印出来。
        for (int i = 1; i <= monthDays; i++) {
            if ((i + remainder) % 7 == 0) {
                System.out.println("   " + i + "\t");
            } else {
                System.out.print("   " + i + "\t");
            }
        }
    }
}

