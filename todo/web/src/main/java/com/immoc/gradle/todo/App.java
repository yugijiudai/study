package com.immoc.gradle.todo;

import java.util.Scanner;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-03
 */
public class App {

    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (++i > 0) {
            System.out.println(i + ". please input todo item name:");
            TodoItem todoItem = new TodoItem(scanner.nextLine());
            System.out.println(todoItem);
        }
    }
}
