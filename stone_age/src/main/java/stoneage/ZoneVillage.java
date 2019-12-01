package stoneage;

import java.util.ArrayList;

public class ZoneVillage extends Zone{

    /**
     * Le nombre maximum d'ouvriers sur la zone
     */
    private int nbOuvrierMaxSurZone;

    /**
     * Le nombre d'ouvriers sur la zone
     */
    private int nbOuvrierSurZone;

    /**
     * La liste du nombre d'ouvriers placés sur la zone par les joueurs
     */
    private ArrayList<Integer> nbOuvirerDuJoueur = new ArrayList<Integer>(); //Pour savoir cb d'ouvriers le joueur i a placé sur la zone z.

    /**
     * ZoneVillage est 0 si c'est le Champ
     * ZoneVillage est 1 si c'est la Fabrique d'outils
     * ZoneVillage est 2 si c'est la Hutte
     */
    private int type_zone;


    /**
     * Constructeur de la classe
     *
     * @param ressource           Le nom de la ressource
     * @param nbRessourcesZone    Le nombre de ressource de la zone
     * @param diviseur            Le diviseur de gain de la zone
     * @param nbOuvrierSurZone    Le nombre d'ouvriers sur la zone
     * @param nbOuvrierMaxSurZone Le nombre d'ouviers maximum sur la zone
     */
    ZoneVillage(Ressource ressource, int nbRessourcesZone, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone, int type_zone) {
        super(ressource, nbRessourcesZone, diviseur, nbOuvrierSurZone, nbOuvrierMaxSurZone);
        this.type_zone = type_zone;
    }

    public void gainZone(Inventaire inventaire, int nJoueur, Joueur IA){
        if(this.type_zone==0){
            inventaire.setNiveauAgriculture(inventaire.getNiveauAgriculture()+1);
        }
        else if (this.type_zone==1){
            inventaire.setNbOutils(inventaire.getNbOutils()+1);
        }
        else {
            inventaire.setNbOuvrier(inventaire.getNbOuvrier()+1);
        }
    }

}