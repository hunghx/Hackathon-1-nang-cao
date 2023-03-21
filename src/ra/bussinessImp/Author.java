package ra.bussinessImp;

import ra.bussiness.ISHOP;

import java.util.List;
import java.util.Scanner;

public class Author implements ISHOP {
    private int authorId;
    private String authorName;
    private  boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData(List<Author> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên tác giả");
        this.authorName= scanner.nextLine();
        System.out.println("Nhập vào giới tính");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào năm sinh");
        this.year = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData(List<Author> list) {
        System.out.printf(" \nID : %-10d   NAME: %-30s \n",this.authorId,this.authorName);
    }
}
