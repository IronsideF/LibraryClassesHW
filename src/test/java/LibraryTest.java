import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library myLibrary;
    private Borrower myBorrower;
    private Book myBook;

    @Before
    public void before(){
        ArrayList<Book> testBooks = new ArrayList<>();
        Book treasureIsland = new Book("Treasure Island", "Robert Louis Stevenson", "Adventure");
        Book lotr = new Book("Fellowship of the Ring", "J R R Tolkien", "Fantasy");
        Book got = new Book("A Game of Thrones", "George R R Martin", "Fantasy");
        testBooks.add(treasureIsland);
        testBooks.add(lotr);
        testBooks.add(got);
        myLibrary = new Library(4, testBooks);
        myBorrower = new Borrower("Jeremy");
        myBook = new Book("Pride and Prejudice", "Jane Austen", "Romance");
    }
    @Test
    public void hasProperties(){
        assertEquals("Pride and Prejudice", myBook.getTitle());
        assertEquals("Jane Austen", myBook.getAuthor());
        assertEquals("Romance", myBook.getGenre());
        assertEquals("Jeremy", myBorrower.getName());
        assertEquals(3, myLibrary.getStockCount());
        assertEquals(0, myBorrower.getCollectionSize());
    }
    @Test
    public void canAddBooksToLibrary(){
        myLibrary.addBook(myBook);
        assertEquals(4, myLibrary.getStockCount());
    }
    @Test
    public void willNotExceedCapacity(){
        myLibrary.addBook(myBook);
        myLibrary.addBook(myBook);
        assertEquals(4, myLibrary.getStockCount());
    }
    @Test
    public void canBorrowBook(){
        myLibrary.addBook(myBook);
        myBorrower.borrowBookFromLibrary(myLibrary, myBook);
        assertEquals(3, myLibrary.getStockCount());
        assertEquals(1, myBorrower.getCollectionSize());
    }
    @Test
    public void willNotBorrowAbsentBook(){
        myBorrower.borrowBookFromLibrary(myLibrary, myBook);
        assertEquals(0, myBorrower.getCollectionSize());
        assertEquals(3, myLibrary.getStockCount());
    }
    @Test
    public void canFindGenreCount(){
        assertEquals(2, myLibrary.getGenreCount("Fantasy"));
    }
    @Test
    public void genreUpdates(){
        myLibrary.addBook(myBook);
        assertEquals(1, myLibrary.getGenreCount("Romance"));
    }
}
