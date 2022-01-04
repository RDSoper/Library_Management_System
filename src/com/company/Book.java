package com.company;

/**
 *
 * @author      Russell Soper
 * @version     05 Nov 2021
 *
 * This class is the blueprint for book objects in the program.
 * Gives each book the fields title of the book, author, id number
 * and if it is onLoan as starting fields.
 */
public class Book{
    // Q1b create fields for the book objects.
    private String author;
    private String title;
    private String id;
    private boolean onLoan;

    /**
     *  Constructs a book object with Title, Author and ID set by
     *  user, with onLoan status set to false by default.
     */
    public Book(String anAuthor, String aTitle, String anId){
        author = anAuthor;
        title = aTitle;
        id = anId;
        onLoan = false;
    }


    /**
     *  Gets the author of the book.
     */
    public String getAuthor(){
        return author;
    }

    /**
     *  Gets the title of the book.
     */
    public String getTitle(){
        return title;
    }

    /**
     *  Gets the id of the book.
     */
    public String getId(){
        return id;
    }

    /**
     *  Gets the loan status of the book.
     */
    public boolean isOnLoan(){
        return onLoan;
    }

    /**
     *  Sets the loan status to either true or false.
     */
    public void setOnLoan(boolean isOnLoan){
        onLoan = isOnLoan;
    }

    /**
     * Uses if statement to check the onLoan field, if true will
     * return "Title: " + title + " Author: " + author +
     * " (On Loan)"; if it is false will return
     * "Title: " + title + " Author: " + author + " (Available)";
     */
    public String toString(){
        if (onLoan){
            return "Title: " + title + ", Author: " + author + " (on loan)";
        }else{
            return "Title: " + title + ", Author: " + author + " (available)";
        }
    }

    /**
     * If the length of the id is not 7 digits long, it will not verify the id
     * and return false.
     * If the id is 7 digits long, it will then iterate over those digits,
     * adding the result of digit modulus 10 to total. Then once it has iterated
     * over all the digits, it will take the result of total modulus 7. If that
     * number is 0 it will verify it and return true. If not it will return
     * false.
     */
    public boolean verifyId(){
        int total = 0;
        int count = 0;
        int length = id.length();
        if (length != 7){
            return false;
        }else{
            while(count < length){
                int character = id.charAt(count);
                int ch = character % 10;
                total += ch;
                count += 1;
            }
        }
        return total % 7 == 0;
    }
}

