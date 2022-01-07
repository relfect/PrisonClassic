package net.larr4k.emerald.prison;

import lombok.Getter;
import lombok.NonNull;

public class PlayerData {

    @Getter
    double blocks;
    @Getter
    int balance;
    @Getter
    String player;
    @Getter
    int level;

    public PlayerData(@NonNull String player, @NonNull int balance, @NonNull double blocks, @NonNull int level) {
        this.player = player;
        this.balance = balance;
        this.blocks = blocks;
        this.level = level;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBlocks(double blocks) {
        this.blocks = blocks;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayer(String player) {
        this.player = player;
    }


}
