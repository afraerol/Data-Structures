package MatrixGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the dimension of the matrix : ");

        int D = scanner.nextInt();
        
        Matrix matrix = new Matrix(D);       
     
        matrix.voyage();
        
        System.out.println("");
        System.out.println("Voyage was completed implementing AVL...");
        System.out.println("");
        
        matrix.AVLImplementation();

    }
    
}
