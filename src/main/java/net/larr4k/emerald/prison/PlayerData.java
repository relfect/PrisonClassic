package net.larr4k.emerald.prison;

import lombok.Getter;
import lombok.NonNull;

public class PlayerData {

    @Getter
    double blocks;
    @Getter
    long balance;
    @Getter
    String player;
    @Getter
    int level;

    public PlayerData(String player, @NonNull long balance, @NonNull double blocks, @NonNull int level) {
        this.player = player;
        this.balance = 0L;
        this.blocks = blocks;
        this.level = level;
    }

    public void setBalance(long balance) {
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
