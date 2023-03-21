package ra.bussinessImp;

import ra.bussiness.ISHOP;

import java.util.List;
import java.util.Scanner;

public class Book implements ISHOP,Comparable<Book> {
    private  int bookId;
    private  String bookName;
    private String title;
    private int numberOfPages;
    private  int authorId;
    private float importPrice;
    private float exportPrice;
    private  int quantity;
    private  boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, int authorId, float importPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authorId = authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
    public void inputData(List<Author> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sách");
        this.bookName = input.nextLine();
        System.out.println("Nhập tiêu đê");
        this.title =input.nextLine();
        System.out.println("Nhập số trang sách");
        this.numberOfPages= Integer.parseInt(input.nextLine());
        // Nhâ tác giả
        System.out.println("Giá nhập");
        this.importPrice= Float.parseFloat(input.nextLine());
        System.out.println("Nhập số lợng sách");
        this.quantity =Integer.parseInt(input.nextLine());
        this.bookStatus =true;
         // thực hiện tính exportPrice
        this.exportPrice =this.importPrice*RATE;
        System.out.println("Hãy nhập tác giả:");
        for (Author author: list
             ) {
            author.displayData(list);

        }
        System.out.println("nhập id tác giả");
        this.authorId = Integer.parseInt(input.nextLine());

    }

    @Override
    public void displayData(List<Author> list) {
        // mã
        //sách, tên sách, tên tác giả(authorName), giá bán sách,
        // số lượng sách, trạng thái
        String authorName="";
        for (Author author : list) {
            if(author.getAuthorId()==this.authorId){
                authorName = author.getAuthorName();
            }
        }
        System.out.printf("\nMã sách: %-10d - Tên sách: %-30s - Tên tác giả: %-30s \n" +
                "Giá bán : %.1f - số lượng : %-10d - trạng thái : %-10s \n",
                this.bookId,this.bookName,authorName,this.exportPrice,this.quantity,
                this.isBookStatus()?"Còn hàng":"Hết hàng");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.exportPrice-o.getExportPrice());
    }
}
