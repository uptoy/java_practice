package java_practice.practice;

class Book {
    String title;
    String author;
    String price;

}

// 関数
public class Practice1 {
    public static void countdown() {
        for (int i = 10; i <= 0; i--) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        countdown();
    }
}
