package pstudio.j061;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD {
    private ArrayList<Word> wordList;

    public WordCRUD() {
        wordList = new ArrayList<>();
    }

    // 단어 추가
    public void addWord(String englishWord, String koreanMeaning, int difficultyLevel) {
        Word word = new Word(englishWord, koreanMeaning, difficultyLevel);
        wordList.add(word);
        System.out.println("단어가 추가되었습니다.");
    }

    // 단어 뜻 수정
    public void editWordMeaning(String englishWord, String newKoreanMeaning) {
        boolean found = false;
        for (Word word : wordList) {
            if (word.getEnglishWord().equals(englishWord)) {
                word.setKoreanMeaning(newKoreanMeaning);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("해당하는 단어가 존재하지 않습니다.");
        } else {
            System.out.println("단어 뜻이 수정되었습니다.");
        }
    }

    // 단어 목록 출력
    public void listWords() {
        if (wordList.isEmpty()) {
            System.out.println("단어가 없습니다.");
        } else {
            System.out.println("단어 목록:");
            for (Word word : wordList) {
                System.out.println(word);
            }
        }
    }

    // 단어 삭제
    public void deleteWord(String englishWord) {
        boolean removed = wordList.removeIf(word -> word.getEnglishWord().equals(englishWord));
        if (removed) {
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("해당하는 단어가 존재하지 않습니다.");
        }
    }

    public static void main(String[] args) {
        WordCRUD wordCRUD = new WordCRUD();
        Scanner scanner = new Scanner(System.in);
        int menu;

        while (true) {
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    System.out.print("영어 단어 입력: ");
                    String englishWord = scanner.nextLine();
                    System.out.print("한글 뜻 입력: ");
                    String koreanMeaning = scanner.nextLine();
                    System.out.print("난이도 입력(1~3): ");
                    int difficultyLevel = scanner.nextInt();
                    wordCRUD.addWord(englishWord, koreanMeaning, difficultyLevel);
                    break;
                case 2:
                    System.out.print("수정할 영어 단어 입력: ");
                    String wordToEdit = scanner.nextLine();
                    System.out.print("새로운 한글 뜻 입력: ");
                    String newMeaning = scanner.nextLine();
                    wordCRUD.editWordMeaning(wordToEdit, newMeaning);
                    break;
                case 3:
                    wordCRUD.listWords();
                    break;
                case 4:
                    System.out.print("삭제할 영어 단어 입력: ");
                    String wordToDelete = scanner.nextLine();
                    wordCRUD.deleteWord(wordToDelete);
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
