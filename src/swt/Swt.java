/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swt;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Swt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập hai số từ bàn phím
        System.out.print("Nhập số thứ nhất: ");
        int num_1 = scanner.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();
        System.out.println("Các ước chung của " + num_1 + " và " + num2 + " là:");
        for (int i = 1; i <= Math.min(num_1, num2); i++) {
            if (num_1 % i == 0 && num2 % i == 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }


}
