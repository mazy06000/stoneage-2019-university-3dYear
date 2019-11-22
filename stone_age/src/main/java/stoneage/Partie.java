package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Random;

public class Partie {
    private int nbJoueur;
    private final Plateau plateau = new Plateau(2);
    private int[] score = new int[nbJoueur];
    private static Random rand = new Random();

    Partie(int nbJoueur){
        this.nbJoueur = nbJoueur;
    }


    public void jouer() {
        int tour = 1;
        System.out.println("Nb de joueur : " + nbJoueur);
        System.out.println("Nb d'ouvriers total non place : " + plateau.nbOuvrierDispoTotal());


        while(tour<5) {
            System.out.println("_________________________________________________");
            System.out.println("|                Tour : "+tour+"                      |");
            System.out.println("_________________________________________________");

            System.out.println("================PHASE DE PLACEMENT================");
            plateau.placementPhase();


            System.out.println("================PHASE DE RECUPERATION================");
            plateau.recuperationPhase();

            System.out.println("================PHASE NOURRIR================");
            plateau.phaseNourrir();

            tour++;
        }


        System.out.println("_____RESULTAT_____");
        resultat(plateau.getListeInventaire());
        this.indexGagnant(score);
        this.JoueurGagnant(score);
    }

    /*
    public static void placementPhase(ArrayList joueurs, ArrayList inventaires, ArrayList zoneDispo){

        while(Inventaire.getNbOuvrierDispo() > 0){
            for (int i=0; i < Joueur.getNbJoueur(); i++)
            {
                Joueur joueur = (Joueur) joueurs.get(i);
                Inventaire inventaire = (Inventaire) inventaires.get(i);
                if (inventaire.getNbOuvrier()==0)
                    continue;
                while(true)
                {
                    int indexZone = rand.nextInt(zoneDispo.size()); //IA choisit random une zone
                    System.out.println("Nb d'ouvriers  : " + inventaire.getNbOuvrier());
                    int nbOuvrier = new Random().nextInt(inventaire.getNbOuvrier())+1; //IA choisit random le nb d'ouvrier a placer
                    if(joueur.getZoneVisite().contains(zoneDispo.get(indexZone))==false)
                    {
                        if ((joueur.getZoneVisite().size()+1) == zoneDispo.size())
                        {
                            phasePlacement(joueur, inventaire, (Zone) zoneDispo.get(indexZone), inventaire.getNbOuvrier());
                            break;
                        }
                        else
                            {
                                phasePlacement(joueur, inventaire, (Zone) zoneDispo.get(indexZone), nbOuvrier);
                                break;
                            }
                    }
                    //if (inventaire.getNbOuvrier()==0) {break;}
                    }

                }

            }
        }*/
/*
    public static void recuperationPhase(ArrayList joueurs, ArrayList inventaires ){
        for (int i=0; i < Joueur.getNbJoueur(); i++){
            Joueur joueur = (Joueur) joueurs.get(i);
            Inventaire inventaire = (Inventaire) inventaires.get(i);
            int nbZone = joueur.getZoneVisite().size();
            for (int j=0; j< nbZone; j++){
                int ind = rand.nextInt(nbZone);
                phaseRecuperation(joueur, inventaire, joueur.getZoneVisite().get(ind));
                joueur.getZoneVisite().remove(ind);
            }
            Inventaire.setNbOuvrierDispo(Inventaire.getNbOuvrierDispo() + inventaire.getNbOuvrier());
        }
    }
*/
//    public static void resultat(ArrayList joueurs, ArrayList inventaires){
//        int arrayRessource[] = new int[joueurs.size()];
//        int max = 0;
//        int listGagnant[] = {};
//
//
//        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
//            Inventaire inventaire = (Inventaire) inventaires.get(i);
////            arrayRessource[i] = inventaire.getNbRessource();
////            if (inventaire.getNbRessource()> max){
////                max = inventaire.getNbRessource();
////            }
//        }
//        for (int i=0; i<arrayRessource.length; i++){
//            if (max == arrayRessource[i]){
//                listGagnant = ArrayUtils.add(listGagnant,i);
//            }
//        }
//
//        for (int i = 0; i < listGagnant.length; i++) {
//            if (listGagnant.length>1){
//                System.out.println("Egalité entre :");
//                for (int el : listGagnant){
//                    Joueur joueur = (Joueur) joueurs.get(el);
//                    System.out.println("joueur " + joueur.getNum());
//                }
//                break;
//            }
//            else{
//                Joueur joueur = (Joueur) joueurs.get(listGagnant[i]);
//                System.out.println("Le gagnant est le joueur " + joueur.getNum());
//            }
//        }
//    }

    public void resultat(ArrayList<Inventaire> listInventaire){
        for (int i = 0; i < listInventaire.size(); i++) {
            this.score[i] = listInventaire.get(i).calculPoint();
        }
    }

    public int indexGagnant(int[] points){
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            if (max < points[i]){
                max = points[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void JoueurGagnant(int[] points){
        int gagnant = indexGagnant(points);
        System.out.println("Le Gagnant est le joueur " + (gagnant+1));
    }

    /**
     * Lancement de la phase de jeu de placement
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */


//    /**
//     * Lancement de la phase de jeu de recuperation
//     *  @param j L'objet de la classe Joueur
//     * @param z L'objet de la classe Zone
//     */
//    public static void phaseRecuperation(Joueur j, Inventaire inventaire, Zone z) {
//        System.out.println("Joueur " + j.getNum() + " :");
//        z.gainZone(inventaire,j);
//        //System.out.println("Nb bois : : " + inventaire.getNbRessourceBois());
//        z.retirerOuvrierSurZone(inventaire, j.getNum());
//        //j.recupere(z);
//        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
//        //System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
//        System.out.println("********Joueur " + j.getNum() + "********");
//        //z.gainZone(j);
//        /*public void gainZone(){
//        int somme=0;
//        for(int i=0;i<z.getNbOuvrierDuJoueurI(j.getNum());i++){
//            somme += j.de();
//        }
//        if(somme >= 6)
//            double gain = somme/3; //formule qui change
//        j.getInventaireJoueur().setBois(getBois()+gain); //si zone est Foret
//        diminuerRessource(gain);
//        retirerOuvrier(getNbOuvrierDuJoueurI(j.getNum()));
//}*/
//        //j.recupere(z); //z.getNbOuvrierDuJoueur(j.getNum());
//
//        System.out.println("Nb d'ouvrier dans la zone "  + z.getClass().getSimpleName() + " : "+ z.getNbOuvrierSurZone());
//        System.out.println("Nb d'ouvrier du joueur " + j.getNum() + " dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierDuJoueurI(j.getNum()));
//        /*if (z instanceof ZoneRessource){
//            System.out.println("Nb de ressource dans la zone " + z.getClass().getSimpleName() + " : " + ((ZoneRessource) z).getNbRessourceZone());
//        }*/
//        System.out.println("niveauAgriculture pour le "+ j.getNum()+ " : "+ inventaire.getNiveauAgriculture() );
//        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbOuvrier());
//        //System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaire.getNbRessource());
//
//    }



//    /**
//     * Lancement de la phase de jeu "nourrir"
//     *
//     * @param j L'objet de la classe Joueur
//     */
//    public static void phaseNourrir(Joueur j, Inventaire inventaire) {
//        j.nourrir(inventaire);
//        System.out.println(" Quantitée de nouriture pour le joueur " + j.getNum() + " : " + inventaire.getNbNourriture());
//
//    }
}
