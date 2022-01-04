package com.company;
import java.util.ArrayList;
/**
 * Write a description of class Library here.
 *
 * @author (Russell Soper)
 * @version (10th Nov 2021)
 *
 * Creates a library that holds a collection of books
 * lent to users. Also tracks fines payable, paid and books in the
 * collection.
 */
public class Library
{

    private ArrayList<Book> books;
    private String name;


    /**
     * Constructor for objects of class Library
     */
    public Library(String aName)
    {
        name = aName;
        books = new ArrayList<>();
    }
    /**
     *  Creates anonymous object and adds it to the collection books.
     */
    public void addBook(String theAuthor, String theTitle, String theId)
    {
        books.add(new Book(theAuthor, theTitle, theId));
    }
    /**
     * Multiplies bookPrice by 0.02 to find 2% of the books price
     * and multiplies that by daysLate to get the fine payable.
     */
    public double calculateFine(double bookPrice, int daysLate)
    {
        return ((bookPrice*0.02)*daysLate);
    }
    /**
     *  Initialises an arraylist that holds the books that match
     *  and a counter that corresponds to the index of the list
     *  being searched. If the book title of the searched title
     *  matches that of a book in the list that book is added to
     *  the list initilised in this method. If it doesn't it isn't.
     *  Either way index is incremented and the next book is
     *  compared. Once the list has been searched, the list local
     *  to this method is returned.
     */
    public ArrayList<Book> getMatchingBooks(String searchTitle)
    {
        ArrayList<Book> matches = new ArrayList<>();
        int index = 0;
        while(index<books.size())
        {
            String bookTitle = books.get(index).getTitle();
            if(bookTitle.equals(searchTitle)){
                matches.add(books.get(index));
            }
            index++;
        }
        return matches;
    }
    /**
     * An index number and local book object is initialised. The
     * index will correspond to the index of the list being searched
     * and the new book object enables the passed book to be
     * manipulated by methods in the Book class. The index allows a
     * while loop to loop through the library list. The new book
     * object enables the method to check if the titles match and if
     * the book in the library is on loan or not. Only if both
     * arguments are true and false respectively the book is
     * available and true is returned. If not then the index is
     * incremented and the loop continues. If the loop finishes and
     * true is not returned, it  will return false.
     */

    public boolean isAvailable(Book aBook)
    {
        int index = 0;
        while(index<books.size())
        {
            if((books.get(index).getTitle().equals(aBook.getTitle())) && (!books.get(index).isOnLoan()))
            {
                return true;
            }
            index++;
        }
        return false;
    }
    /**
     *  Creates a for each loop, looking at the element entry of
     *  type Books in list books, and printing that entry out.
     */
    public void listAllBooks()
    {
        for(Book entry : books)
        {
            System.out.println(entry);
        }
    }
    /**
     *  new variables index and bookToCheck allows a while loop
     *  with nested for loop to be set up. The book variable in the
     *  method allows the passed book to be manipulated by methods
     *  in the Book class. It checks the Id of the passed book with
     *  all books in the library list and if they match sets the
     *  loan status of that book to true. Otherwise it increments
     *  the index and starts again.
     */
    public void loanBook(Book aBook)
    {
        int index = 0;
        while(index<books.size())
        {
            if(books.get(index).getId().equals(aBook.getId())){
                books.get(index).setOnLoan(true);
            }
            index++;
        }
    }
    /**
     *  Again the index and local book object allow the method to
     *  loop through and access the passed books Strings. The
     *  method loops through the library list and compares the id
     *  of the current book to the id of the passed book. if they
     *  are the same the book is removed. If they aren't the index
     *  is incremented. If the index is is equal to result of the
     *  .size() method, this means the list has finished and the
     *  book is not there. In that case, book not found is printed.
     */
    public void removeBook(Book aBook)
    {
        int index = 0;
        Book bookToCheck = aBook;
        while(index<books.size())
        {
            if((books.get(index).getId().equals(bookToCheck.getId()))){
                books.remove(index);
            }
            index++;
            if(index == books.size()){
                System.out.println("Book not found.");
            }
        }
    }
}


