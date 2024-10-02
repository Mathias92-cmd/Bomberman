package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur extends AbstractMovable {

    private IntegerProperty score;

    private IntegerProperty pointsDeVie;


    public Joueur(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.score = new SimpleIntegerProperty(0);
        this.pointsDeVie = new SimpleIntegerProperty(3);
    }


    @Override
    public void collidedWith(IMovable other) {
        if (other instanceof Ennemi || other instanceof Explosion) {
            decrementPointsDeVie(1);
        }
    }

    @Override
    public void explode() {
        decrementPointsDeVie(1);
    }

    @Override
    public void hitEnemy() {
        decrementPointsDeVie(1);
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public IntegerProperty pointsDeVieProperty() {
        return pointsDeVie;
    }

    public int getScore() {
        return score.get();
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public int getPointsDeVie() {
        return pointsDeVie.get();
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie.set(pointsDeVie);
    }

    public void incrementScore(int score){
        this.score.set(this.score.get() + score);
    }

    public void decrementPointsDeVie(int pointsDeVie){
        this.pointsDeVie.set(this.pointsDeVie.get() - pointsDeVie);
    }
}