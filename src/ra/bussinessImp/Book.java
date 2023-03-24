package ra.bussinessImp;

import ra.bussiness.ISHOP;

import java.util.List;
import java.util.Scanner;

public class Book implements ISHOP,Comparable<Book> {
    private  int bookId;
    private  String bookName;
    private  String title;
    private  int numberOfPages;
    private  Author author;
    private  float importPrice;
    private float exportPrice;
    private  int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData(Scanner sc, List<Author> listAuthor) {
        System.out.println("nhạp tên sách");
        this.bookName= sc.nextLine();
        System.out.println("nhập tiêu đê");
        this.title= sc.nextLine();
        System.out.println("nhaapk số trag ");
        this.numberOfPages = Integer.parseInt(sc.nextLine());
        System.out.println("Nhâp giá nhập sách");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("nhập số lượng sách");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("nhập trạng thái sách");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
        this.exportPrice = this.importPrice*RATE;
        System.out.println("Hãu chọn tác giả cho sách");
        for (Author author:listAuthor) {
            author.displayData();
        }
        int authorId = Integer.parseInt(sc.nextLine());
        for (Author author : listAuthor) {
            if(author.getAuthorId()==authorId){
                this.author = author;
                break;
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("-------------------------------------------------------");
        System.out.printf("Mã sách: %d\n",bookId);
        System.out.printf("Tên sách: %s\n",bookName);
        System.out.printf("Tên tác giả : %s\n",author.getAuthorName());
        System.out.printf("Giá bán sách: %.1f\n",exportPrice);
        System.out.printf("Số lượng: %d\n",quantity);
        System.out.printf("Trạng thái: %s\n",(bookStatus?"bán":"không bán"));
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.exportPrice-o.getExportPrice());
    }
}
