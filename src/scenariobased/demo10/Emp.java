package scenariobased.demo10;

import java.util.List;

public class Emp {

//    private String empId;
    private List<Book> bookList;
//    private Integer empSalary;


    public Emp(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "bookList=" + bookList +
                '}';
    }
}
