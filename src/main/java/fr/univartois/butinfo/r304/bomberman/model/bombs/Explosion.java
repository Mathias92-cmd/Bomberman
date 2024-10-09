package fr.univartois.butinfo.r304.bomberman.model.bombs;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

import java.util.logging.LogManager;
import java.util.logging.Logger;

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

    @Override
    public boolean move(long delta) {
        if (System.currentTimeMillis() - dureeExplosion > 2000) {
            game.removeMovable(this);
        }
        return true;
    }

    @Override
    public void collidedWith(IMovable other) {
        other.explode();
    }

    @Override
    public void explode() {
        game.removeMovable(this);
    }

    @Override
    public void hitEnemy() {
        LOGGER.info("L'explosion a touché un ennemi");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
