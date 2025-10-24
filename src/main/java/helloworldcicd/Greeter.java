package helloworldcicd;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*
Задание по CI/CD + сборочные сервера:

- Развернуть локально Jenkins
- Сделать hello-world проект на мавене с тестами
и плагинами на code coverage и code quality
- Сделать джобу, срабатывающую при пуше в какую-то ветку.
Дженкинс должен выкачивать проект, прогонять CI пайплайн и собирать JAR файл
- * Сделать ручную джобу по созданию релизного тега в GIT.
При ее  запуске дженкинс должен вытягивать последний тег из мастер ветки,
инкрементировать его и создавать тег на последнем коммите мастера
 */
public final class Greeter {

    private Greeter() {
        throw new UnsupportedOperationException("Utility class");
    }
    /**
     * Main entry point.
     * @param args command-line arguments
     */
    public static void main(final String[] args)
            throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out,
                true,
                "UTF-8"));
        System.out.println("Пожалуйста, введите Ваше имя ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        greet(name);
    }
    /**
     * Returns greeting message.
     * @param name user name
     * @return greeting text
     */
    public static void greet(final String name) {
        System.out.println("Приветствуем Вас, " + name
                + ", на нашем сервере! Добро пожаловать!");
    }
}
