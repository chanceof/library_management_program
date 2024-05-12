package com.ohgiraffers.repository;

import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;

import java.util.ArrayList;

public class MainRepository {
    private final ArrayList<MemberDTO> memberDTO = new ArrayList<>();
    private final ArrayList<BookDTO> bookDTO = new ArrayList<>();
    private String result;

    // 도서 대출 메서드
    public boolean memberNameValid(String memberName) {
        for (MemberDTO member : this.memberDTO)
            if (member.getMemberName().equals(memberName)) {
                return true;
            }
        return false;
    }

    public String rentABook(int memberNum) {
        if (memberNum >= bookDTO.size()) {
            return "해당하는 도서가 없습니다.";
        }
        BookDTO books = bookDTO.get(memberNum);

        if (books.getBookRent() != null) {
            return books.getBookRent() + " 님이 대여중입니다.";
        }
        MemberDTO members = memberDTO.get(memberNum);
        books.setBookRent(members.getMemberName());
        if (members.getMemberRentalList() == null) {
            members.setMemberRentalList(books.getBookName());
        } else {
            members.setMemberRentalList(members.getMemberRentalList() + " " + books.getBookName());
        }
        return members.getMemberName() + " 님에게 " + books.getBookName() + " 이 대여 되었습니다.";
    }

    // 도서 관리 메서드
    public boolean bookNameValid(String bookName) {
        for (BookDTO books : this.bookDTO)
            if (books.getBookName().equals(bookName)) {
                return true;
            }
        return false;
    }

    public String bookRegistration(BookDTO books) {
        int bookListSize = bookDTO.size();
        bookDTO.add(books);
        if (bookListSize < bookDTO.size()) {
            System.out.println("등록에 실패하였습니다.");
        }
        books = bookDTO.get(bookListSize);
        books.setBookNum(bookListSize);
        return "등록에 성공하였습니다.";
    }

    public String bookNameSearch(String bookName) {
        if (bookDTO.isEmpty()) {
            return "현재 등록된 도서가 없습니다.";
        }
        // 책의 이름과 같이 list에 저장되어있는 책의 번호를 찾아야함
        int bookNum = -1;
        for (int i = 0; i < bookDTO.size(); i++) {
            BookDTO book = bookDTO.get(i);
            if (book.getBookName().equals(bookName)) {
                bookNum = i;
                break;
            }
        }
        if (bookNum == -1) {
            return "해당하는 책을 찾을 수 없습니다.";
        }
        BookDTO book = bookDTO.get(bookNum);
        return book.toString();
    }

    public String bookModify(String bookName) {
        int bookNum = -1;
        for (int i = 0; i < bookDTO.size(); i++) {
            BookDTO book = bookDTO.get(i);
            if (book.getBookName().equals(bookName)) {
                bookNum = i;
                break;
            }


        }

        return result;
    }

    public String bookDelete(String bookName) {
        return result;
    }

    public String registeredBookList(){
        if (bookDTO.isEmpty()){
            System.out.println("등록된 도서가 없습니다.");
        }
        for (BookDTO books : bookDTO) {
            result += bookDTO.toString();
        }
        return result;
    }

    // 회원 관리 메서드
    public String memberRegistration(MemberDTO members) {
        int memberListSize = bookDTO.size();
        memberDTO.add(members);
        if (memberListSize < bookDTO.size()) {
            System.out.println("등록에 실패하였습니다.");
        }
        members = memberDTO.get(memberListSize);
        members.setMemberNum(memberListSize);
        return "등록에 성공하였습니다.";
    }

    public String memberNameSearch(String memberName) {
        if (memberDTO.isEmpty()) {
            return "현재 등록된 회원이 없습니다.";
        }
        // 회원의 이름과 같이 list에 저장되어있는 회원의 번호를 찾아야함
        int memberNum = -1;
        for (int i = 0; i < memberDTO.size(); i++) {
            MemberDTO member = memberDTO.get(i);
            if (member.getMemberName().equals(memberName)) {
                memberNum = i;
                break;
            }
        }
        if (memberNum == -1) {
            return "해당하는 회원을 찾을 수 없습니다.";
        }
        MemberDTO member = memberDTO.get(memberNum);
        return member.toString();
    }

    public String memberModify(String memberName) {

        return result;
    }

    public String memberDelete(String memberName) {
        return result;
    }

    public String registeredMemberList(){
        if (memberDTO.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
        }
        for (MemberDTO members : memberDTO) {
            result += memberDTO.toString();
        }
        return result;
    }

    // 도서 반납 메서드
    public String returnABook(int bookNum) {
        if (bookNum >= bookDTO.size()) {
            return "해당하는 도서가 없습니다.";
        }
        BookDTO books = bookDTO.get(bookNum);

        if (books.getBookRent() == null) {
            return "해당 책은 대여되지 않았습니다.";
        }
        books.setBookRent(null);
        return books.getBookName() + " 이 반납되었습니다.";
    }
}
