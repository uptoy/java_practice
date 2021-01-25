import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoApp {
    static List<Todo> list = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        File file = new File("todo.csv");
        System.out.println("****TodoApp****");
        if (file.exists()) {
            readFile(file);
        }
        while (true) {
            showTodo();
            System.out.println("------操作を入力してください------");
            System.out.print("1/登録 2/重要度変更 3/削除 4/終了>");
            int select = scan.nextInt();
            scan.nextLine();
            switch (select) {
                case 1:
                    createTodo();
                    break;
                case 2:
                    alterTodo();
                    break;
                case 3:
                    deleteTodo();
                    break;
                default:
                    System.out.println("アプリケーションを終了します。");
                    saveFile(file);
                    scan.close();
                    return;
            }
        }
    }

    private static void deleteTodo() {
        if (list.size() == 0) {
            System.out.println("まだTodoはありません。");
            return;
        }
        System.out.printf("Todoを削除します。番号を入力してください。%d~%d>", 0, list.size() - 1);
        int index = scan.nextInt();
        list.remove(index);
        System.out.println("1件削除しました。");
    }

    private static void alterTodo() {

        if (list.size() == 0) {

            System.out.println("まだTodoはありません。");
            return;
        }
        System.out.printf("重要度を変更します。番号を入力してください。%d~%d>", 0, list.size() - 1);
        int index = scan.nextInt();
        System.out.print("重要度を再設定してください。>");
        int importance = scan.nextInt();
        list.get(index).setImportance(importance);
        System.out.println("重要度を変更しました。");

    }

    private static void createTodo() {
        System.out.println("新規Todoを作成します。");
        System.out.print("Todo内容を入力してください>");
        String todo = scan.nextLine();
        System.out.print("重要度を1~10(最大)で入力してください>");
        int importance = scan.nextInt();
        Todo t = new Todo(todo, importance);
        list.add(t);
        System.out.println("1件追加しました。");
    }

    public static void showTodo() {
        if (list.size() == 0) {
            System.out.println("Todoは1件もありません。");
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getImportance() < list.get(j).getImportance()) {
                    Todo temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "・・・" + list.get(i).toString());
        }
    }

    public static void readFile(File file) {
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Todo todo = new Todo(data[0], Integer.parseInt(data[1]));
                list.add(todo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveFile(File file) {
        BufferedWriter bw = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);

            for (Todo todo : list) {
                bw.append(todo.toCSV());
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
