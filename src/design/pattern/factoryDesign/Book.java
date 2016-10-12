package design.pattern.factoryDesign;

/**
 * Created by aditya.joshee on 04/12/14.
 */
public abstract class Book {

    private String name;
    private String author;
    private long noOfPages;

    public static final Type type=null;

    public Book(){}

    public Book(String name){
        this.name=name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(long noOfPages) {
        this.noOfPages = noOfPages;
    }

    public abstract void read();

    public abstract  String toString();
}
