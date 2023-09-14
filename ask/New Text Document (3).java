/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.panepistimio;


import java.util.Scanner;
import java.lang.Math;

public class ask3 
{
    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        int min = 1;
        int max = 10;
        int number = (int)(Math.random() * (max - min) + min);
        System.out.println("Random number between 1 and 10: " +number);
        if(number % 2 == 1)
        {
            System.out.println("Perittos Arithmos");
            
        }
        else if(number % 2 == 0)
        {
            System.out.println("Artios Arithmos");
        }
    }
}