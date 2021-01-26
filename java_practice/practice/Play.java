package java_practice.practice;

public class Play {
    public static void main(String[] args) {
        Student a001 = new Student();
        a001.name = "sato";
        double[] data = { 70, 65, 50, 90, 30 };

        double avg = a001.calculateAvg(data);
        String result = a001.judge(avg);

        System.out.println(avg);
        System.out.println(a001.name + " " + result);
    }
}