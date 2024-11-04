package fr.univartois.butinfo.r304.bomberman.model.movables;

public class VulnerableState implements PlayerState {

    @Override
    public void takeDamage(Joueur player, int damage) {
        player.decrementPointsDeVie(damage);
        if (player.getPointsDeVie() <= 0) {
            // player.setSprite(player.getSpriteStore().getSprite("goblin"));
            player.game.playerIsDead();
        } else {
            player.makePlayerInvulnerable();
        }
    }

    @Override
    public void updateAppearance(Joueur player) {
        player.setSprite(player.getSpriteStore().getSprite("agent"));
    }
}
