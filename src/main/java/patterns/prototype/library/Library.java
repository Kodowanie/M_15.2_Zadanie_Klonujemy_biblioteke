package patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library>{

    private  String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String s = "        Library {" + name + "}\n";
        for (Book bookList : books){
            s = s + bookList.toString() + "\n";
        }
        return s;
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library cloneLibrary = super.clone();
        cloneLibrary.books = new HashSet<>();
        for (Book booksList : books){
            Book cloneBooks =  new Book(booksList.getTitle(),booksList.getAuthor(),booksList.getPublicationDate());
            cloneLibrary.getBooks().add(cloneBooks);
        }
        return cloneLibrary;
    }
}

