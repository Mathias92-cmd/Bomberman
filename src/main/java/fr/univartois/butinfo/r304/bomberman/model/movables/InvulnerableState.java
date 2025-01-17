/**
 * Classe InvulnerableState : permet de gérer l'état invulnérable du joueur.
 */
package fr.univartois.butinfo.r304.bomberman.model.movables;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 * Classe InvulnerableState : permet de gérer l'état invulnérable du joueur.
 */
public class InvulnerableState implements PlayerState {

    /**
     * La durée de l'invulnérabilité du joueur.
     */
    private static final int INVULNERABLE_DURATION = 3;

    /**
     * Permet de faire prendre des dégâts au joueur.
     *
     * @param player Le joueur qui prend des dégâts.
     * @param damage Les dégâts à infliger.
     */
    @Override
    public void takeDamage(Joueur player, int damage) {
        // Le joueur ne peut pas prendre de dégâts
    }

    /**
     * Permet de mettre à jour l'apparence du joueur.
     *
     * @param player Le joueur à mettre à jour.
     */
    @Override
    public void updateAppearance(Joueur player) {
        player.setSprite(player.getSpriteStore().getSprite("punker"));
    }

    /**
     * Permet de rendre le joueur invulnérable.
     *
     * @param player Le joueur à rendre invulnérable.
     */
    public static void makePlayerInvulnerable(Joueur player) {
        player.setState(new InvulnerableState());
        player.setSprite(player.getSpriteStore().getSprite("punker"));
        PauseTransition pause = new PauseTransition(Duration.seconds(INVULNERABLE_DURATION));
        pause.setOnFinished(event -> {
            player.setState(new VulnerableState());
            player.setSprite(player.getSpriteStore().getSprite("agent"));
        });
        pause.play();
    }
}
