import java.util.ArrayList;

public class Borrower {
    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name){
        this.name= name;
        this.collection= new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getCollectionSize(){
        return collection.size();
    }
    public void borrowBookFromLibrary(Library library, Book book){
        if (library.removeBook(book)){
            collection.add(book);
        }
    }
}
