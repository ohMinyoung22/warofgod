package gui;

import channel.Channel;
import datacontrol.InformationManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeamList {
    private Inventory inventory;
    private Channel channel;
    private String title;

    public TeamList(Channel channel) {
        this.channel = channel;
        title = channel.getChannelName() + " Team list";
        inventory = Bukkit.createInventory(null, 54, title);
    }

    public void updateItem() {
        ItemStack item = new ItemStack(Material.EMERALD);
        ;
        ItemMeta meta;
        ArrayList<String> lore;

        for (int i = 0; i < channel.getGameManager().getDataContainer().getTeamManager().getTeamList().size(); i++) {
            lore = InformationManager.getTeamLore(channel, channel.getGameManager().getDataContainer().getTeamManager().getTeamList().get(i));

            meta = item.getItemMeta();
            meta.setDisplayName(channel.getGameManager().getDataContainer().getTeamManager().getTeamList().get(i).getTeamName());
            meta.setLore(lore);

            item.setItemMeta(meta);
            inventory.setItem(i, item);
        }
    }

    public Inventory getInventory() {
        updateItem();
        return inventory;
    }
}
