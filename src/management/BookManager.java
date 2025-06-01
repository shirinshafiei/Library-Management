package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String, Book> bookMap;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book != null) {
            bookMap.put(book.getIsbn(), book);
        }
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = bookMap.get(isbn);
        return book != null && book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = bookMap.get(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = bookMap.get(isbn);
        if (book != null && memberId != null) {
            Member member = memberManager.getMember(memberId);
            if (member != null) {
                book.addToWaitlist(member);
            }
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = bookMap.get(isbn);
        return book != null ? book.getNextInWaitlist() : null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = bookMap.get(isbn);
        return book != null && book.hasWaitlist();
    }
}