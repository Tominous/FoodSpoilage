package spoilagesystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import spoilagesystem.EventHandlers.*;
import spoilagesystem.Subsystems.CommandSubsystem;
import spoilagesystem.Subsystems.StorageSubsystem;
import spoilagesystem.Subsystems.TimeStampSubsystem;

public final class Main extends JavaPlugin implements Listener {

    public String version = "v1.8";

    // subsystems
    public TimeStampSubsystem timestamp = new TimeStampSubsystem(this);
    public StorageSubsystem storage = new StorageSubsystem(this);

    @Override
    public void onEnable() {
        if (!storage.foodSpoilageFolderExists()) {
            System.out.println("Creating default files");
            storage.saveValuesToConfig();
            storage.saveCustomText();
        }
        else {
            storage.loadValuesFromConfig();
            storage.loadCustomText();
        }
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        storage.saveValuesToConfig();
        storage.saveCustomText();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSubsystem commandInterpreter = new CommandSubsystem(this);
        return commandInterpreter.interpretCommand(sender, label, args);
    }

    @EventHandler()
    public void onCraft(CraftItemEvent event) {
        CraftItemEventHandler handler = new CraftItemEventHandler(this);
        handler.handle(event);
    }

    
    @EventHandler()
    public void onInventoryClick(InventoryDragEvent event) {
        InventoryDragEventHandler handler = new InventoryDragEventHandler(this);
        handler.handle(event); // TODO: Fix null error associated with this method
    }

    @EventHandler()
    public void onRightClick(PlayerInteractEvent event) {
        PlayerInteractEventHandler handler = new PlayerInteractEventHandler(this);
        handler.handle(event);
    }

    @EventHandler()
    public void onDrop(ItemSpawnEvent event) {
        ItemSpawnEventHandler handler = new ItemSpawnEventHandler(this);
        handler.handle(event);
    }

    @EventHandler()
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        FurnaceSmeltEventHandler handler = new FurnaceSmeltEventHandler(this);
        handler.handle(event);
    }

    @EventHandler()
    public void onBlockCook(BlockCookEvent event) {
        BlockCookEventHandler handler = new BlockCookEventHandler(this);
        handler.handle(event);
    }
}
