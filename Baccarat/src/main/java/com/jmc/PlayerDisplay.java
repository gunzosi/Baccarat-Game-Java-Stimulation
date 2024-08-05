package com.jmc;

public class PlayerDisplay  implements GameObserver {
    @Override
    public void update(Player player) {
        System.out.println(player.getName() + " update: " + player);
    }
}
