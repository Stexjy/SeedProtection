package stexjy.seedprotection.events;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SeedProtectionListener implements Listener {

    @EventHandler
    public void onSeedBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();

        if(player.isSneaking()) return;
        if(!isSeed(block)) return;

        final Ageable ageable = (Ageable) block.getState().getBlockData();

        if(ageable.getAge() == ageable.getMaximumAge()) return;

        player.sendMessage(ChatColor.RED + "Please shift to break the seed.");
        event.setCancelled(true);
    }

    private boolean isSeed(Block block) {
        switch (block.getType()) {
            case BEETROOT_SEEDS:
            case MELON_SEEDS:
            case PUMPKIN_SEEDS:
            case WHEAT_SEEDS:
                return true;
        }

        return false;
    }

}
