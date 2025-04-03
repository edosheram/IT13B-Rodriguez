/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIDTERM;
/**
 *
 * @author PC
 */
public class Fibonacci_recursive_method {
    public static int f(int n) {
        if (n<=1) {
            return n;
          
        }
        return f(n - 1) + f(n-2);
    }
    public static void main(String[] args ) {
        int n = 10;
        
        for (int i  = 0; i <n; i++){
            System.out.print(f(i) + ", ");
        }
    }
}