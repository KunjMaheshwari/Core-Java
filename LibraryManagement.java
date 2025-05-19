import java.util.*;

class BookUtility implements Runnable{
    private List<Book> bookList;
    private String searchbookName;
    private int counter;

    public BookUtility(List<Book> bookList, String searchbookName){
        this.bookList = bookList;
        this.searchbookName = searchbookName;
        this.counter = 0;
    }

    public List<Book> getBookList(){
        return bookList;
    }

    public void setBookList(List<Book> bookList){
        this.bookList = bookList;
    }

    public String getSearchbookName(){
        return searchbookName;
    }

    public void setSearchbookName(String searchbookName){
        this.searchbookName = searchbookName;
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public void toValidateBookType(Book obj) throws InvalidBookException{
        if(obj.getBookType().equalsIgnoreCase("Engineering")){
            bookList.add(obj);
        }else{
            throw new InvalidBookException("Book type invalid");
        }
    }

    @Override
    public void run(){
        for(Book b : bookList){
            if(b.getBookName().equalsIgnoreCase(searchbookName)){
                counter++;
            }
        }
    }

}

class InvalidBookException extends Exception{
    public InvalidBookException(String message){
        super(message);
    }
}

class Book{
    private String bookId;
    private String bookName;
    private String bookType;
    private String bookCategory;
    private String bookEdition;

    public Book(String bookId, String bookName, String bookType, String bookCategory, String bookEdition){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookType = bookType;
        this.bookCategory = bookCategory;
        this.bookEdition = bookEdition;
    }

    public String getBookId(){
        return bookId;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getBookType(){
        return bookType;
    }

    public void setBookType(String bookType){
        this.bookType = bookType;
    }

    public String getBookCategory(){
        return bookCategory;
    }

    public void setBookCategory(String bookCategory){
        this.bookCategory = bookCategory;
    }

    public String getBookEdition(){
        return bookEdition;
    }

    public void setBookEdition(String bookEdition){
        this.bookEdition = bookEdition;
    }

}

public class LibraryManagement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();

        System.out.println("Enter the number of entries");
        int noOfEntries = Integer.parseInt(sc.nextLine());

        for(int i=0;i<noOfEntries; i++){
            String input = sc.nextLine();
            String parts[] = input.split("/");

            String id = parts[0];
            String bookName = parts[1];
            String bookType = parts[2];
            String bookCategory = parts[3];
            String bookEdition = parts[4];

            
            Book b = new Book(id, bookName, bookType, bookCategory, bookEdition);
            BookUtility bu = new BookUtility(bookList, "");

            try{
                bu.toValidateBookType(b);
                bookList.add(b);
            }catch(InvalidBookException e){
                System.out.println(e.getMessage());
            }
        }
    }
}