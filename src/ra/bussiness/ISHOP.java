package ra.bussiness;

import ra.bussinessImp.Author;

import java.util.List;
import java.util.Scanner;

public interface ISHOP {
    public static final  float RATE = 1.3F;
     public void inputData(Scanner sc, List<Author> list);
     public void displayData();
}
