package ability;

import org.bukkit.entity.Player;

public interface Ability {
    void onLeftClick(Player player);

    void onRightClick(Player player);

    void registerPassive();

    boolean validateLeftClick(Player player);

    boolean validateRightClick(Player player);

    int getLeftCooldown();

    int getRightCooldown();
}
