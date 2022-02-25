
/**
 * TP9
 *
 * @author (FERNANDEZ M.)
 */
import java.util.Scanner;

public class AlgosTableaux
{
    /**
     * Demande à l'utilisateur de saisir un entier, jusqu'à ce que
     * l'entier saisi soit entre les deux bornes en paramètres.
     *
     * @param pfBorneInf IN : borne inférieure
     * @param pfBorneSup IN : borne supérieure
     *
     * @return un entier entre pfBorneInf et pfBorneSup, compris
     */
    public static int saisieIntC (int pfBorneInf, int pfBorneSup){
        int valeur;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
        valeur = clavier.nextInt();
        while (valeur<pfBorneInf || valeur>pfBorneSup){
            System.out.println("Erreur ! Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
            valeur = clavier.nextInt();
        }
        return valeur;
    }

    /**
     * Demande à l'utilisateur :
     *   1. de saisir le nombre de cases qu'il souhaite remplir, et
     *      répète l'opération, jusqu'à ce que ce nombre soit
     *      acceptable
     *   2. de remplir les cases une à une.
     *
     * @param pfTab OUT : tableau à remplir
     *
     * @return le nombre de cases remplies dans le tableau
     */
    public static int saisirTableau (int[] pfTab){
        Scanner clavier = new Scanner(System.in);
        int nbEl = 0;
        
        while(nbEl <= 0) {
            System.out.println("Veuillez saisir un nombre de cases à remplir strictement positif : ");
            nbEl = clavier.nextInt();
        }    
        
        for (int i=0; i<nbEl; i++) {
            System.out.println("Entrez la valeur de la case n°" + (i+1) + " : ");
            pfTab[i] = clavier.nextInt();
        }
        
        return nbEl;
    }

    /**
     * Affiche le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void afficherTableau(int[] pfTab, int pfNbEl) {
        String affichage = "[";
        
        for (int i = 0; i<pfNbEl-1; i++) {
            affichage += pfTab[i] + ","; 
        }   
        
        affichage += pfTab[pfNbEl-1] + "]";
        System.out.println("Votre tableau : " + affichage);        
    }

    /**
     * Inverse le contenu du tableau en paramètre.
     *
     * @param pfTab IN/OUT : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void inverserTableau(int[] pfTab, int pfNbEl) {
       int indInv = 0; 
               
       for (int i = 0; i<pfNbEl/2; i++) {
           indInv = pfTab[i];
           pfTab[i] = pfTab[pfNbEl-1-i];
           pfTab[pfNbEl-1-i] = indInv;           
       }            
    }    
        
    public static void afficherInverserTableau(int[] pfTab, int pfNbEl) {
        String affichage2 = "["; 
        
        for (int i = 0; i<pfNbEl-1; i++) {
            affichage2 += pfTab[pfNbEl-1-i] + ",";
        }
        affichage2 += pfTab[0] + "]";  
        System.out.println("Votre tableau inversé : " + affichage2);
    }    
    
    /**
     * Construit un nouveau tableau sans doublons, pourtant similaire au tableau donné en paramètre.
     *
     * @param pfTab IN/OUT : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     * @return la nouvelle taille du tableau sans doublons
     */
    public static int eliminerDoublons(int[] pfTab, int[] tabsansDoublons, int pfNbEl) {               
        int newNbEl = 0;
        int a = 0;
                
        /*1er élement du tableau renseigné, reporté au nouveau tableau à la même place*/
        for (int i=0; i<pfNbEl; i++)  {
            boolean doublons = false;
            for (int j=0; j<i; j++) {                
                if (tabsansDoublons[j] == pfTab[i]) {
                    doublons = true;
                }    
            }
            /*S'il n'y a pas de doublons, on peut réafficher le contenu*/
            if (!doublons) {
                tabsansDoublons[a] = pfTab[i];
                newNbEl++;
                a++;
            }            
        }       
        return newNbEl;        
    }   
    
    /**
     * Affiche le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void afficherTableauSansDoublons(int[] pfTab, int pfNbEl) {
        String affichage = "[";
        
        for (int i = 0; i<pfNbEl-1; i++) {
            affichage += pfTab[i] + ","; 
        }   
        
        affichage += pfTab[pfNbEl-1] + "]";
        System.out.println("Votre tableau sans doublons : " + affichage);        
    }
    
    /*
     * Retourne la valeur maximale d'un tableau
     * @param pfTab IN : un tableau de valeurs entières
     * @param pfNbEl IN : le nombre de valeurs
     * @return la valeur entière maximale
     */
    public static int valMaxTab(int pfNbEl, int pfTab[]) {
        int valMax = pfTab[0];
        for (int i=1; i<pfNbEl; i++) {
            if (pfTab[i] > valMax) {
                valMax = pfTab[i];
            }
        }
        return valMax;
    }
        
    /**
     * Stocke les indices des occurences du maximum
     *
     * @param pfTab    IN  : un tableau de valeurs entières
     * @param pfNbEl   IN  : le nombre de valeurs
     * @param pfIndice OUT : le tableau des indices
     *
     * @return le nombre d'occurrences du max
    **/
    public static int indicesMax(int[] pfTab, int pfNbEl, int[] pfIndices) {
        int valMax2 = valMaxTab(pfNbEl, pfTab);
        int nbOccurences = 0;
        int j = 0;
        
        for (int i = 0; i<pfNbEl; i++) {
            if (valMax2 == pfTab[i]) {
                pfIndices[j] = i;
                nbOccurences++;
                j++;
            }
        }
        return nbOccurences;
    }    
    
    /**
     * Affiche le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void afficherTableauIndices(int[] pfTab, int pfNbEl) {
        String affichage = "[";
        
        for (int i = 0; i<pfNbEl-1; i++) {
            affichage += pfTab[i] + ","; 
        }   
        
        affichage += pfTab[pfNbEl-1] + "]";
        System.out.println("Votre tableau avec le/les indice(s) de/des occurence(s) du maximum du tableau : " + affichage);        
    }
       
    public static void main(String[] args) {

        /* Declaration des variables */
        int nbVal; // variables de nombres de valeurs a traiter
        int nbVal2;
        int[] tab = new int[100]; // tableaux permettant de stocker les valeurs
        int[] tabSD = new int[100];
        int[] tabMax = new int[100];
        int[] indices = new int[10];
        int nbOccurences;
        
        // Ajouter les appels aux algorithmes :
        //   - à saisirTableau
        nbVal = saisirTableau(tab);
        //   - puis à afficherTableau
        afficherTableau(tab, nbVal);          
        for (int i=0; i<nbVal; i++) {            
            tabMax[i] = tab[i];
        }
        //   - puis à afficher inverserTableau        
        afficherInverserTableau(tab, nbVal);
        //   - puis à afficher eliminerDoublons        
        nbVal2 = eliminerDoublons(tab, tabSD, nbVal);       
        afficherTableauSansDoublons(tabSD, nbVal2); 
        //   - puis à afficher indicesMax
        nbOccurences = indicesMax(tabMax, tabMax.length, indices);
        afficherTableauIndices(indices, nbOccurences);
        
        /*Pour la fonction eliminerDoublons, il est très anormal de ne pas avoir un rendu avec
        des 0 s'ils sont renseignés dans le tableau (aux premiers tests) et aussi inversement !*/ 
    }    
}