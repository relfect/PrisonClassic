package net.larr4k.emerald.commands;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import net.larr4k.emerald.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import ru.abstractcoder.benioapi.command.impl.ParentCommand;

import javax.inject.Inject;

import static ru.abstractcoder.benioapi.command.availability.CommandAvailabilities.bukkitPerm;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class MenuCommand extends ParentCommand {

    @Inject
    public MenuCommand(String label) {
        super("navigator");

        executingStrategy()
                .aliases("")
                .addAvailability(bukkitPerm(""))
                .withSubcommand(new PlayerSubcommand("menu") {
                    @Override
                    protected void execute(Player player, String[] strings, String s) {
                        player.getInventory().addItem(new ItemBuilder(Material.BOOK).setName("§eПутеводитель").setLore("", "§eНажмите §f- §cПКМ", "§fЧтобы открыть меню").toItemStack());
                    }
                });
    }
}
