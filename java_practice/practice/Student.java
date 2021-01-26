package java_practice.practice;

public class Student {
    String name;// フィール名

    public double calculateAvg(double[] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        double avg = sum / data.length;
        return avg;
    }

    public String judge(double avg) {
        String result;
        if (avg >= 60) {
            result = "psssed";
        } else {
            result = "failed";
        }
        return result;
    }
}
