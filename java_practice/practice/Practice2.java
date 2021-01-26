package java_practice.practice;

public class Practice2 {

    public static void methodA() {
        System.out.println("methodAが実行されました");
    }

    public static void methodB(int a) {
        System.out.println("methodBに値" + a + "がわたされました");
    }

    public static double getCircleAreas(double r) {
        return r * r * Math.PI;
    }

    public static void main(String[] args) {
        methodA();
        methodB(9);
        System.out.println("半径3.5の面積は" + getCircleAreas(3.5));
        System.out.println(Math.PI);
    }

}

// staticはクラスメソッド