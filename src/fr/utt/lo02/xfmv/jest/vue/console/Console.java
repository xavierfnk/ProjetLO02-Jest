package fr.utt.lo02.xfmv.jest.vue.console;

import java.awt.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import fr.utt.lo02.xfmv.jest.controller.Partie;
import fr.utt.lo02.xfmv.jest.model.cartes.Carte;
import fr.utt.lo02.xfmv.jest.model.joueurs.Joueur;
import fr.utt.lo02.xfmv.jest.model.joueurs.JoueurReel;

public abstract class Console {

    public static void welcomeMessage() {
        System.out.println("--- Jeu de Jest inventé par Brett J. Gilbert ---");
    }

    public static void showMenu() {
        System.out.println("(1) --- Jouer\n(2) --- Lire les règles\n(3) --- Quitter");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice !=1 && choice != 2 && choice !=3);
        switch (choice) {
            case 1 :
                Partie.getInstance().initialiserPartie();
                break;
            case 2 :
                try {
                    URI uri = new URI("https://puu.sh/EKl29/655216593a.png");
                    Desktop.getDesktop().browse(uri);
                }
                catch(Exception ex) {}
                Console.showMenu();
                break;
            case 3 :
                System.exit(0);
                break;
        }

    }

    public static String playerUsernameChoice(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le pseudo du joueur n° " + id);
        String username = sc.nextLine();
        return username;
    }
    
    // permet de récupérer le choix du joueur pour la variante
    
    public static int demanderVariante() {

        Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	System.out.println("Choisissez une variante pour la partie");
    	System.out.println("(1) -- Variante de base : les trophées sont assignés selon les règles classiques" );
    	System.out.println("(2) -- Variante 1 : les trophées sont assignés aléatoirement" );
    	System.out.println("(3) -- Variante 2 : les trophées sont assignés selon les règles classiques mais sont inconnus" );
    	System.out.println("");
    	
    	do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice !=1 && choice != 2 && choice !=3);
        
        
        return choice;
    }
    
    public static int demanderNombreJoueurs() {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	System.out.println("Voulez-vous jouer à 3 ou 4 joueurs ?");
    	System.out.println("");
    	
    	do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice !=3 && choice != 4);
        
        
        return choice;
    }
    
    public static int demanderJoueursReels(int nombreJoueurs) {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	System.out.println("Combien y a-t-il de joueurs réels ?");
    	System.out.println("");
    	
    	do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice > nombreJoueurs); // vérifier qu'on ne choisit pas plus de joueurs réels que de joueurs
        
        
        return choice;
    }
    
    public static int demanderStrategie(int id) {

        Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	System.out.println("Choisissez la stratégie utilisée par le bot n°" + (id + 1));
    	System.out.println("(1) -- Stratégie de base : le bot choisis aléatoirement une carte à chaque tour de jeu" );
    	System.out.println("(2) -- Stratégie avancée : le bot choisis la carte avec la valeur la plus haute" );
    	System.out.println("");
    	
    	do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice !=1 && choice != 2);
        
        
        return choice;
    }

    public static void cardChoice(Joueur joueur) {

        System.out.println("");
        System.out.println(joueur + " choisis la carte à cacher :");

        System.out.println("(1) --- " + joueur.getMain().get(0));
        System.out.println("(2) --- " + joueur.getMain().get(1));

        return;
    }


    public static void displayPlayerCards(ArrayList<Joueur> joueurs) {

        for (Joueur joueur : joueurs) {
            System.out.print(joueur.toString() + " --- ");
            for (Carte carte : joueur.getMain()) {
                System.out.print(carte.toString() + " ");
            }
            System.out.println("");
        }

    }

    public static void displaySelectCards(ArrayList<Carte> selectCards, Joueur joueur) {

        System.out.println(joueur + " choisis la carte à mettre dans ton Jest :");
        for (int i = 0; i < selectCards.size(); i++ ) {
            System.out.println("(" + (i + 1) + ") --- " + selectCards.get(i).toString());
        }


    }

    public static void showTurn(int tour) {
        System.out.println("");
        System.out.println("*********");
        System.out.println(" TOUR " + tour);
        System.out.println("*********");
        System.out.println("");
    }

    public static void showJests() {
        System.out.println("Révélez vos Jests !");
        for (Joueur joueur : Partie.getInstance().getJoueurs()) {
            System.out.print(joueur.toString() + ": ");
            for (Carte carte : joueur.getJest()) {
                carte.setVisible(true);
                System.out.print(carte.toString() + " ");
            }
            System.out.println("");
        }
    }

    public static void showScores() {
        System.out.println("");
        System.out.println("Voilà les scores !");
        for (Joueur joueur : Partie.getInstance().getJoueurs()) {
            System.out.println(joueur.toString() + " : " + joueur.getScore());
        }
    }

    public static void endOfGame() {
        System.out.println("(1) --- Retourner au menu\n(2) --- Quitter");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("Votre choix : ");
            choice = sc.nextInt();
            System.out.println("");
        } while (choice !=1 && choice != 2);
        switch (choice) {
            case 1 :
                Console.showMenu();
                break;
            case 2 :
                System.exit(0);
                break;
        }
    }
    
}
