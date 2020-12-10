/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dames;

/**
 *
 * @author Anthony
 */
public class Main {
    public static void main(String[] args) {
        Plateau jeu = new Plateau();
        jeu.chargerPartie();
        System.out.println(jeu.plateau[0][0].tki);
        jeu.SauvegardePartie();
    }
}
