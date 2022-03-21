package com.advanced.advanced_class_06;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/20 17:17
 **/
public class HuaweiTest1 {
    public int res = 0;
//    public HuaweiTest1 obj = new HuaweiTest1();


    public int huawei1(int n) {
        huawei2(n, 1, 0);
        return res;
    }

    public void huawei2(int n, int index, int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            res++;
            return;
        }
        for (int i = index; i < 1 + n; i++) {
            huawei2(n, i, sum + i);
        }
//        return res;
    }

    public static void main(String[] args) {
        HuaweiTest1 huaweiTest1 = new HuaweiTest1();
        System.out.println(huaweiTest1.huawei1(5));
        System.out.println("Hello world");
    }
}