package cft.test.task;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rewriter {

    private String userText;
    private List<String> userDataArr = new ArrayList<>();

    public void dataForRewrite() {

        while (true) {

            System.out.println("Введите данные для перезаписи файлов для сортировки, и нажмите enter.");
            String enteredText;
            Scanner scanner = new Scanner(System.in);
            enteredText = scanner.nextLine();

            if ("end".equals(enteredText))
                break;

            if (enteredText.isEmpty()) {
                System.out.println("Вы ничего не ввели. Повторите попытку");

            } else {
                userText = enteredText;
                userDataArr.add(userText);
                System.out.println();
                System.out.println("Желаете добавить данные?");
                System.out.println("Если нет, то введите `end`");
            }
        }
    }
    public List<String> getUserTextArr() {
        return userDataArr;
    }
}
