package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Author> listAuthor = new ArrayList<>();
        List<Book> listBooks= new ArrayList<>();
        while(true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                    "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("hãy nhập lựa chon");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số tác giả cần thêm mới");
                    int total = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < total; i++){
                        System.out.println("Nhập tác giả thứ "+(i+1));
                        Author newAuthor = new Author();
                        newAuthor.inputData(listAuthor);
                        if(listAuthor.size()==0){
                            newAuthor.setAuthorId(1);
                        }else {
                            newAuthor.setAuthorId(listAuthor.get(listAuthor.size() - 1).getAuthorId()+1);
                        }
                        listAuthor.add(newAuthor);
                    }
                    for (Author author : listAuthor){
                        author.displayData(listAuthor);
                    }

                    break;
                case 2:
                    System.out.println("Nhập số sách cần thêm mới");
                    int number = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < number; i++){
                        System.out.println("Nhập thông ti sách thứ "+(i+1));
                        Book newBook = new Book();
                        newBook.inputData(listAuthor);
                        if (listBooks.size()==0){
                            newBook.setBookId(1);
                        }else {
                            newBook.setBookId(listBooks.get(listBooks.size() - 1).getBookId()+1);
                        }
                        listBooks.add(newBook);
                    }
                    for (Book book : listBooks) {
                        book.displayData(listAuthor);
                    }
                    break;
                case 3:
                    System.out.println("Sắp xê sách theo giá xuất tăng dần");
                    Collections.sort(listBooks);
                    for (Book book : listBooks) {
                        book.displayData(listAuthor);
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào tên tác giả sách");
                    String authorName = input.nextLine();
                    int authorId =0;
                    for (Author author:listAuthor){
                        if(author.getAuthorName().equals(authorName)){
                            authorId = author.getAuthorId();
                        }
                    }
                    for (Book book : listBooks) {
                        if(book.getAuthorId()==authorId){
                            book.displayData(listAuthor);
                        }
                    }
                    break;
                case 5:
                    System.out.println("thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn khong hợp lệ");
                    break;
            }

        }
    }
}
