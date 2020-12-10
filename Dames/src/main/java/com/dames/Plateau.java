/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Anthony
 */
public class Plateau {
    piece[][] plateau;

    public Plateau() {
        this.plateau = new piece[8][8];
    }

    

        
    public void chargerPartie(){
        try{
            plateau = new piece[8][8];
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader("save.txt"));
            ligne = fichier.readLine();
            String delimiteurs = " ;,";
            int compteur =0;
      
        for(int i=0;i<8;i++){
        
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
            while (tokenizer.hasMoreTokens()){
                String valeur = tokenizer.nextToken();
                
                switch(valeur){
                    case ".":
                        break;
                    case "b":
                        this.plateau[i][compteur] = new pion(i,compteur,0);
                        break;
                    case "B":
                        this.plateau[i][compteur] = new dame(i,compteur,0);
                        break;
                    case "n":
                        pion tempon =  new pion(i,compteur,1);
                        this.plateau[i][compteur] = tempon;
                        break;
                    case "N":
                        this.plateau[i][compteur] = new dame(i,compteur,1);
                        break;
                }
                
                
            compteur +=1;    
            }
            compteur = 0;
            ligne = fichier.readLine();
        }
        fichier.close();
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SauvegardePartie(){
        System.out.println("Entrez le nom du fichier de sauvegarde");
        Scanner sc = new Scanner(System.in);
        String nomfichier = sc.nextLine();
        File f = new File(nomfichier);
        if(f.exists()){
            f.delete();
            this.sauvegarderPartie(nomfichier);
        }
        else{
            this.sauvegarderPartie(nomfichier);
        }
    }
    
    public void sauvegarderPartie(String nomSauvegarde) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomSauvegarde));
            
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(this.plateau[i][j] == null){
                        bufferedWriter.write(". ");
                    }
                    else{
                        if((this.plateau[i][j] instanceof dame)&& (this.plateau[i][j].couleur == 0)){
                            bufferedWriter.write("B ");
                        }
                        if((this.plateau[i][j] instanceof pion)&& (this.plateau[i][j].couleur == 0)){
                            bufferedWriter.write("b ");
                        }
                        if((this.plateau[i][j] instanceof dame)&& (this.plateau[i][j].couleur == 1)){
                            bufferedWriter.write("N ");
                        }
                        if((this.plateau[i][j] instanceof pion)&& (this.plateau[i][j].couleur == 1)){
                            bufferedWriter.write("n ");
                        }
                    }
                }
                bufferedWriter.write("\n");
                
            }
            
            
           
          
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(bufferedWriter != null){
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

