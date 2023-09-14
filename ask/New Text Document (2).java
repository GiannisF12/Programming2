/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.panepistimio;

/**
 *
 * @author giann
 */
public class ask2 
{
    public static void main(String[] args)
    {
        double arithmos = 9876.5431;
        long akeraios = (long)arithmos;
        double temp = (arithmos - akeraios)*10000;
        short dekadikos = (short)temp;
        System.out.println("Akeraio Meros: "+akeraios+" kai Dekadiko Meros: " +dekadikos);
    }
}
