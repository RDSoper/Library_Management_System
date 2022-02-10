package com.company;

public class Main {

    public static void main(String[] args) {
        Book book1 =  new Book("David Barnes, Michael Kolling", "Objects first with Java","1234567");
        Library londonLibrary = new Library("London library");
        londonLibrary.addBook(book1.getAuthor(), book1.getTitle(), book1.getId());
        System.out.println(londonLibrary.getMatchingBooks("Objects first with Java"));
    }
}
