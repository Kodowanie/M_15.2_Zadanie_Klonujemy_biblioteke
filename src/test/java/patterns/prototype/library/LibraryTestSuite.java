package patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //given
        //creating Library
        Library library =  new Library("Central Library");
        IntStream.iterate(1,n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author" + n, LocalDate.now())));

        //shallow copy
        Library shallowLibrary = null;
        try{
            shallowLibrary = library.shallowCopy();
            shallowLibrary.setName("Shallow Copy Central Library");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //deep copy
        Library deepLibrary = null;
        try{
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Deep copy Central Library");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //when
        Book bookAdd = new Book("Title 6", "Author6", LocalDate.now());
        deepLibrary.getBooks().add(bookAdd);

        //then
        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);
        assertEquals(5, library.getBooks().size());
        assertEquals(5, shallowLibrary.getBooks().size());
        assertEquals(6, deepLibrary.getBooks().size());
    }
}
