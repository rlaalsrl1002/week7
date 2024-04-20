package pstudio.j063;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoCRUD {
    private final ArrayList<Todo> todoList;

    public TodoCRUD() {
        todoList = new ArrayList<>();
    }

    // 일정 추가
    public void addTodo(String title, String content, String deadline, String category) {
        Todo todo = new Todo(title, content, deadline, category);
        todoList.add(todo);
        System.out.println("일정이 추가되었습니다.");
    }

    // 일정 정보 수정
    public void editTodo(String title, String newContent, String newDeadline, String newCategory) {
        for (Todo todo : todoList) {
            if (todo.getTitle().equals(title)) {
                todo.setContent(newContent);
                todo.setDeadline(newDeadline);
                todo.setCategory(newCategory);
                System.out.println("일정 정보가 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당하는 일정이 존재하지 않습니다.");
    }

    // 일정 목록 출력
    public void listTodos() {
        if (todoList.isEmpty()) {
            System.out.println("일정이 없습니다.");
        } else {
            System.out.println("일정 목록:");
            for (Todo todo : todoList) {
                System.out.println(todo);
            }
        }
    }
    // 일정 삭제
    public void deleteTodo(String title) {
        for (Todo todo : todoList) {
            if (todo.getTitle().equals(title)) {
                todoList.remove(todo);
                System.out.println("일정이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당하는 일정이 존재하지 않습니다.");
    }
    public static void main(String[] args) {
        TodoCRUD todoCRUD = new TodoCRUD();
        Scanner scanner = new Scanner(System.in);
        int menu;

        while (true) {
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    System.out.print("제목 입력: ");
                    String title = scanner.nextLine();
                    System.out.print("내용 입력: ");
                    String content = scanner.nextLine();
                    System.out.print("마감일 입력: ");
                    String deadline = scanner.nextLine();
                    System.out.print("카테고리 입력: ");
                    String category = scanner.nextLine();
                    todoCRUD.addTodo(title, content, deadline, category);
                    break;
                case 2:
                    System.out.print("수정할 일정의 제목 입력: ");
                    String todoToEdit = scanner.nextLine();
                    System.out.print("새로운 내용 입력: ");
                    String newContent = scanner.nextLine();
                    System.out.print("새로운 마감일 입력: ");
                    String newDeadline = scanner.nextLine();
                    System.out.print("새로운 카테고리 입력: ");
                    String newCategory = scanner.nextLine();
                    todoCRUD.editTodo(todoToEdit, newContent, newDeadline, newCategory);
                    break;
                case 3:
                    todoCRUD.listTodos();
                    break;
                case 4:
                    System.out.print("삭제할 일정의 제목 입력: ");
                    String todoToDelete = scanner.nextLine();
                    todoCRUD.deleteTodo(todoToDelete);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
