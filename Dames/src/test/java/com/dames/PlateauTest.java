/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dames;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anthony
 */
public class PlateauTest {
    
    public PlateauTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }


    /**
     * Test of sauvegarderPartie method, of class Plateau.
     */
    @org.junit.jupiter.api.Test
    public void testSauvegarderPartie() {
        System.out.println("sauvegarderPartie");
        String nomSauvegarde = "hey.txt";
        Plateau jeu = new Plateau();
        jeu.chargerPartie();
        jeu.SauvegardePartie();
        
    }
    
}
