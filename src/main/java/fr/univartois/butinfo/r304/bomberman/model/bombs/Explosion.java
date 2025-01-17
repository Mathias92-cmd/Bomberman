/**
 * Ce package contient les classes représentant les bombes dans le jeu Bomberman.
 */
package fr.univartois.butinfo.r304.bomberman.model.bombs;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.EnemyWithLife;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Cette classe représente une explosion dans le jeu Bomberman.
 */
public class Explosion extends AbstractMovable {
    private static final Logger LOGGER = LogManager.getLogManager().getLogger(Bombe.class.getPackageName());
    private long dureeExplosion;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected Explosion(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.dureeExplosion = System.currentTimeMillis();
    }

    /**
     * Enlève l'explosion de la carte.
     *
     * @param delta Le temps écoulé depuis le dernier déplacement de cet objet (en
     *              millisecondes).
     * @return
     */
    @Override
    public boolean move(long delta) {
        if (System.currentTimeMillis() - dureeExplosion > 2000) {
            game.removeMovable(this);
        }
        return true;
    }

    /**
     * Elimine l'objet avec lequel cet objet est entré en collision.
     *
     * @param other L'objet avec lequel cet objet est entré en collision.
     */
    @Override
    public void collidedWith(IMovable other) {
        if (other instanceof EnemyWithLife) {
            // Decorator le fait
        } else {
            other.explode();
        }
    }

    /**
     * Enlève l'explosion de la carte.
     */
    @Override
    public void explode() {
        game.removeMovable(this);
    }

    /**
     * L'explosion a touché un ennemi.
     */
    @Override
    public void hitEnemy() {
        LOGGER.info("L'explosion a touché un ennemi");
    }

    /**
     * Permet de comparer deux objets.
     *
     * @param obj L'objet à comparer.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Retourne le code de hachage de cet objet.
     *
     * @return Le code de hachage de cet objet.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
