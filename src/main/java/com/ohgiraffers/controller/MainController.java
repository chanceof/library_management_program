package com.ohgiraffers.controller;

import com.ohgiraffers.dao.MainService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    MainService mainService = new MainService();
    private boolean valid;
    private String result;
    private int bookNum;
    private int menuChoice;

    // 대출관련 메서드 작성 ------------------------------------------------------------------------------------------------
    public String rentABook() {
        valid = true;
        System.out.println("================================= 도서 대출 메뉴 =================================");
        while (valid) {
            // 대출받을 회원을 번저 검증한다.
            System.out.print("회원의 이름을 입력해 주세요: ");
            String memberName = scanner.nextLine();
            int value = Integer.parseInt(mainService.memberNameValid(memberName));

            // 검증받은 값을 반환 받아 등록된 회원인지 출력.
            if (value == -1) {
                System.out.println("등록된 회원이 없습니다.");
            } else {
                try {
                    System.out.print("대출할 책의 번호를 입력해 주세요: ");
                    bookNum = scanner.nextInt();
                    scanner.nextLine();
                    valid = false; // 반복문 종료.
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다.");
                    scanner.nextLine();
                }
            }
            result = mainService.rentABook(bookNum);
        }
        return result;
    }

    // 도서관리 메서드 작성 ------------------------------------------------------------------------------------------------
    /*
     *   1. 도서 등록, 2. 도서명 검색, 3. 도서 수정, 4. 도서 삭제, 5. 전체 도서 검색, 9. 이전메뉴
     */
    public String bookManagement() {
        // 6개의 메뉴를 만들어야함
        valid = true;
        while (valid) {
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서명 검색");
            System.out.println("3. 도서 수정");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 전체 도서 검색");
            System.out.println("9. 이전 메뉴");
            System.out.print("메뉴를 선택해 주세요: ");
            try {
                menuChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다 숫자를 입력해주세요.");
            }
            switch (menuChoice) {
                case 1 -> {
                    System.out.println("================================= 도서 등록 메뉴 =================================");
                    result = mainService.bookRegistration();
                    valid = false;
                }
                case 2 -> {
                    System.out.println("================================= 도서명 검색 메뉴 =================================");
                    result = mainService.bookNameSearch();
                    valid = false;
                }
                case 3 -> {
                    System.out.println("================================= 도서 수정 메뉴 =================================");
                    result = mainService.bookModify();
                    valid = false;
                }
                case 4 -> {
                    System.out.println("================================= 도서 삭제 메뉴 =================================");
                    result = mainService.bookDelete();
                    valid = false;
                }
                case 5 -> {
                    System.out.println("================================= 전체 도서 검색 메뉴 =================================");
                    mainService.registeredBookList();
                    valid = false;
                }
                case 9 -> {
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    valid = false;
                }
                default -> {
                    return "잘못된 입력입니다.";
                }
            }
        }
        return result;
    }

    // 회원관리 메서드 작성 ------------------------------------------------------------------------------------------------
    /*
     *   1. 회원 등록, 2. 회원명 검색, 3. 회원 수정, 4. 회원 삭제, 5. 전체 회원 검색, 9. 이전메뉴
     */
    public String memberManagement() {
        // 6개의 메뉴를 만들어야함
        valid = true;
        while (valid) {
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원명 검색");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 검색");
            System.out.println("9. 이전 메뉴");
            System.out.print("메뉴를 선택해 주세요: ");
            try {
                menuChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다 숫자를 입력해주세요.");
            }
            switch (menuChoice) {
                case 1 -> {
                    System.out.println("================================= 회원 등록 메뉴 =================================");
                    result = mainService.memberRegistration();
                    valid = false;
                }
                case 2 -> {
                    System.out.println("================================= 회원명 검색 메뉴 =================================");
                    result = mainService.memberNameSearch();
                    valid = false;
                }
                case 3 -> {
                    System.out.println("================================= 회원 수정 메뉴 =================================");
                    result = mainService.memberModify();
                    valid = false;
                }
                case 4 -> {
                    System.out.println("================================= 회원 삭제 메뉴 =================================");
                    result = mainService.memberDelete();
                    valid = false;
                }
                case 5 -> {
                    System.out.println("================================= 전체 회원 검색 메뉴 =================================");
                    mainService.registeredMemberList();
                    valid = false;
                }
                case 9 -> {
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    valid = false;
                }
                default -> {
                    return "잘못된 입력입니다.";
                }
            }
        }
        return result;
    }

    // 반납관련 메서드 작성 ------------------------------------------------------------------------------------------------
    public void returnABook() {
        valid = true;
        System.out.println("================================= 도서 반납 메뉴 =================================");
        while (valid) {
            try {
                System.out.print("반납할 책의 번호를 입력해 주세요: ");
                bookNum = scanner.nextInt();
                scanner.nextLine();
                valid = false; // 반복문 종료.
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
            }
        }
        mainService.returnABook(bookNum);
    }
}
