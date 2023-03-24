package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        List<Book> listBook = new ArrayList<>();
        List<Author> listAuthor = new ArrayList<>();
        File file1 = new File("book.txt");
        File file2 = new File("author.txt");
        if (file1.exists()) {
            try {
                ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(file1));
                ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));
                listBook = (List<Book>) ois1.readObject();
                listAuthor = (List<Author>) ois2.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            file1.createNewFile();
            file2.createNewFile();
        }

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                    "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("nhập vào lựa chọn");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    // nhập tacs giả
                    createAuthors(listAuthor,input);
                    break;
                case 2:
                    // nhập sách
                    createBooks(listBook,input,listAuthor);
                    break;
                case 3:
                    // sắp xếp theo giá xuất tăng
                    sortByExortPrice(listBook);
                    break;
                case 4:
                    // tìm kếm
                    searchByAuthorName(listBook,input);

                    break;
                case 5:
                    System.out.println("thoát");
                    try {
                        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file1));
                        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
                        oos1.writeObject(listBook);
                        oos2.writeObject(listAuthor);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.err.println("nhập sai cmnr");
                    break;

            }
        }
    }

    public static void createAuthors(List<Author> list , Scanner sc){
        // nhập số lượng tác giả cần thêm mới

        System.out.println("Nhập số luowngj tác giả cần thêm");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <count ; i++) {
            System.out.println("nhập tác giả thứ "+ (i+1));
            Author newAuthor = new Author();
            newAuthor.inputData(sc,list);
            if(list.size()==0){
                newAuthor.setAuthorId(1);
            }else {
                int newAuthorId = list.get(list.size()-1).getAuthorId()+1;
                newAuthor.setAuthorId(newAuthorId);
            }
            list.add(newAuthor);
        }
        System.out.println("thêm thành công");
        displayAuthor(list);
    }
    public  static  void  createBooks(List<Book> listBook, Scanner sc, List<Author> listAuthor){
        System.out.println("Nhập số luowngj sách cần thêm");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <count ; i++) {
            System.out.println("nhập sách thứ "+ (i+1));
            Book newBook = new Book();
            newBook.inputData(sc,listAuthor);
            if(listBook.size()==0){
                newBook.setBookId(1);
            }
            else {
                newBook.setBookId(listBook.get(listBook.size()-1).getBookId()+1);
            }
            listBook.add(newBook);
        }
        System.out.println("thêm thành công");
        displayListBook(listBook);
    }
    public  static  void  sortByExortPrice(List<Book> list){
        Collections.sort(list);
        displayListBook(list);
    }
    public  static void searchByAuthorName(List<Book> list,Scanner scanner){
        System.out.println("nhập tên tác giả cần tìm kiếm");
        String searchName = scanner.nextLine();
        List<Book> listSearch = new ArrayList<>();
        for (Book book : list) {
            if(book.getAuthor().getAuthorName().contains(searchName)){
                listSearch.add(book);
            }
        }
        System.out.println("danh sách tìm kiếm là");
        displayListBook(listSearch);
    }
    public  static void displayListBook(List<Book> list){
        for (Book book : list) {
            book.displayData();
        }
    }
    public  static void displayAuthor(List<Author> list){
        for (Author author:list
             ) {
            author.displayData();
        }
    }
}
