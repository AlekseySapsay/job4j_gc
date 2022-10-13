package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Menu {
    private static final String MENUTEXT = """
            Введите 1, для указания директории для кэширования,
            Введите 2, для загрузки файла в кэш,
            Введите 3, для извлечения файла из кэша,
            Введите любое число, отличное от вариантов выше, для выхода
            """;

    private static final int CACHE_DIRERCTORY = 1;
    private static final int CACHE_FILE_NAME_SAVE = 2;
    private static final int CACHE_FILE_NAME_LOAD = 3;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache fileCache = null;
        String fileName = null;
        boolean run = true;

        while (run) {
            System.out.println(MENUTEXT);
            System.out.println("Выберите действие: ");
            int userChice = Integer.parseInt(scanner.nextLine());
            if (userChice == CACHE_DIRERCTORY) {
                System.out.println("Выберите директорию для сохранения: ");
                String dir = scanner.nextLine();
                fileCache = new DirFileCache(dir);
            } else if (userChice == CACHE_FILE_NAME_SAVE) {
                System.out.println("Выберите имя файла для сохранения в кэш: ");
                fileName = scanner.nextLine();
                fileCache.put(fileName, fileName);
            } else if (userChice == CACHE_FILE_NAME_LOAD) {
                System.out.println("Выберите имя файла для извлечения из кэша: ");
                String key = scanner.nextLine();
                System.out.println(fileCache.get(key));
            } else {
                System.out.println("выход из программы...");
                run = false;
            }
        }
    }
}
