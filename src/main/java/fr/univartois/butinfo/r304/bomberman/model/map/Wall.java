/**
 * Ce logiciel est distribué à des fins éducatives.
 * <p>
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 * <p>
 * (c) 2022-2024 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.Sprite;

/**
 * La classe {@link Wall} représente un mur de briques sur la carte du jeu.
 * Il s'agit d'un élément qui ne peut pas être traversé, mais qui peut être détruit par
 * une explosion.
 *
 * @author Romain Wallon
 * @version 0.1.0
 */
public final class Wall {

    /**
     * L'état du mur.
     */
    private IWallState state;


    /**
     * Crée une nouvelle instance de Wall.
     *
     * @param state Le sprite représentant le mur sur la carte.
     */
    public Wall(IWallState state) {
        this.state = state;
    }

    /**
     * Change l'état du mur.
     *
     * @param newState Le nouvel état du mur.
     */
    public void setState(IWallState newState) {
        this.state = newState;
    }

    /**
     * Récupère l'état du mur.
     *
     * @return L'état du mur.
     */
    public IWallState getState() {
        return state;
    }


    /**
     * Degradation du mur.
     */
    public void degrade() {
        state.degrade(this);
    }

    /**
     * Donne le sprite représentant ce mur sur la carte.
     *
     * @return Le sprite représentant ce mur sur la carte.
     */
    public Sprite getSprite() {
        return state.getSprite();
    }

}
