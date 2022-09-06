import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> stock;
    private int capacity;
    private HashMap<String, Integer> genreCount;

    public Library(int capacity, ArrayList<Book> stock) {
        this.capacity = capacity;
        this.stock = stock;
        buildGenreCount();
    }

    public int getStockCount(){
        return stock.size();
    }
    public void addBook(Book book){
        if (capacity>getStockCount()){
            stock.add(book);
            buildGenreCount();
        }
    }
    public Boolean removeBook(Book book){
        Boolean hasBook = stock.remove(book);
        buildGenreCount();
        return hasBook;
    }
    private void buildGenreCount(){
        this.genreCount = new HashMap<>();
        for (Book book : stock){
            genreCount.putIfAbsent(book.getGenre(), 0);
            genreCount.put(book.getGenre(), genreCount.get(book.getGenre())+1);

        }
    }
    public int getGenreCount(String genre){
        return genreCount.get(genre);
    }

}
