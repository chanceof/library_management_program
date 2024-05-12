package com.ohgiraffers.dao;

import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;
import com.ohgiraffers.repository.MainRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainService {
    MainRepository mainRepository = new MainRepository();
    Scanner scanner = new Scanner(System.in);
    private String result;
    private boolean booleanResult;
    private String bookName;
    private String memberName;

    // 도서 대출 메서드
    public String memberNameValid(String memberName) {
        return String.valueOf(mainRepository.memberNameValid(memberName));
    }

    public String rentABook(int memberNum) {
        return mainRepository.rentABook(memberNum);
    }

    // 도서 관리 메서드
    public String bookRegistration() {
        int bookQuantity = 0;
        // 도서명을 레파지토리 클래스로 넘기기
        BookDTO books = new BookDTO();
        try {
            System.out.print("등록할 도서의 수량을 입력하세요: ");
            bookQuantity = scanner.nextInt();
            scanner.nextInt();
            for (int i = 0; i < bookQuantity; i++) {
                System.out.print("등록할 도서명을 입력해주세요: ");
                bookName = scanner.nextLine();
                books.setBookName(bookName);
            }
            result = mainRepository.bookRegistration(books);
            System.out.println("등록이 완료 되었습니다.");
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        } finally {
            scanner.close();
        }
        return result;
    }

    public String bookNameSearch() {
        // 도서가 등록되어 있는지 검증
        System.out.print("검색할 도서명을 입력해주세요: ");
        bookName = scanner.nextLine();
        booleanResult = mainRepository.bookNameValid(bookName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        // 검색할 도서명을 레파지토리 클래스로 넘기기
        return mainRepository.bookNameSearch(bookName);
    }

    public String bookModify() {
        // 도서가 등록되어 있는지 검증
        System.out.print("수정할 도서명을 입력해주세요: ");
        bookName = scanner.nextLine();
        booleanResult = mainRepository.bookNameValid(bookName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        // 수정할 도서명을 레파지토리 클래스로 넘기기
        return mainRepository.bookModify(bookName);
    }

    public String bookDelete() {
        // 도서가 등록되어 있는지 검증
        System.out.print("삭제할 도서명을 입력해주세요: ");
        bookName = scanner.nextLine();
        booleanResult = mainRepository.bookNameValid(bookName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        // 삭제할 도서명을 레파지토리 클래스로 넘기기
        return mainRepository.bookDelete(bookName);
    }

    public String registeredBookList() {
        // 전체 도서 리스트 조회
        return mainRepository.registeredBookList();
    }

    // 회원 관리 메서드
    public String memberRegistration() {
        MemberDTO members = new MemberDTO();
        try {
            System.out.print("등록할 회원의 인원수를 입력하세요: ");
            int memberQuantity = scanner.nextInt();
            scanner.nextInt();
            for (int i = 0; i < memberQuantity; i++) {
                System.out.print("등록할 회원명을 입력해주세요: ");
                memberName = scanner.nextLine();
                members.setMemberName(memberName);
            }
            result = mainRepository.memberRegistration(members);
            System.out.println("등록이 완료 되었습니다.");
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        } finally {
            scanner.close();
        }
        return result;
    }

    public String memberNameSearch() {
        // 회원이 등록되어 있는지 검증
        System.out.print("검색할 회원명을 입력해주세요: ");
        memberName = scanner.nextLine();
        booleanResult = mainRepository.memberNameValid(memberName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        // 검색할 회원명을 레포지토리 클래스로 넘기기
        return mainRepository.memberNameSearch(memberName);
    }

    public String memberModify() {
        // 회원이 등록되어 있는지 검증
        System.out.print("수정할 회원명을 입력해주세요: ");
        memberName = scanner.nextLine();
        booleanResult = mainRepository.memberNameValid(memberName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        return mainRepository.memberModify(memberName);
        // 수정할 회원명을 레포지토리 클래스로 넘기기
    }

    public String memberDelete() {
        // 회원이 등록되어 있는지 검증
        System.out.print("삭제할 회원명을 입력해주세요: ");
        memberName = scanner.nextLine();
        booleanResult = mainRepository.memberNameValid(memberName);
        if (!booleanResult) {
            System.out.println("등록되지 않은 도서입니다.");
        }
        return mainRepository.memberDelete(memberName);
        // 삭제할 회원명을 레포지토리 클래스로 넘기기
    }

    public String registeredMemberList() {
        return mainRepository.registeredMemberList();
    }
    // 도서 반납 메서드
    public void returnABook(int bookNum) {
        mainRepository.returnABook(bookNum);
    }
}
