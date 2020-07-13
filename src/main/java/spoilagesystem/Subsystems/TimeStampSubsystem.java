package spoilagesystem.Subsystems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import spoilagesystem.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeStampSubsystem {

    Main main = null;

    String pattern = "MM/dd/yyyy HH";

    public TimeStampSubsystem(Main plugin) {
        main = plugin;
    }

    public ItemStack assignTimeStamp(ItemStack item, int hoursUntilSpoilage) {
        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.WHITE + "Created:");
        lore.add(ChatColor.WHITE + "" + getDateString());
        lore.add("");
        lore.add(ChatColor.WHITE + "" + "Expiry Date:");
        lore.add(ChatColor.WHITE + "" + getDateStringPlusTime(hoursUntilSpoilage));

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private String getDateString() {
        DateFormat df = new SimpleDateFormat(pattern);

        Date now = getDate();

        return df.format(now);
    }

    private Date getDate() {
        return Calendar.getInstance().getTime();
    }

    private String getDateStringPlusTime(int hours) {
        DateFormat df = new SimpleDateFormat(pattern);

        Date now = getDatePlusTime(hours);

        return df.format(now);
    }

    private Date getDatePlusTime(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public boolean timeStampAssigned(ItemStack item) {
        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.getLore();

        for (String string : lore) {
            if (string.equalsIgnoreCase(ChatColor.WHITE + "" + "Expiry Date:")) {
                return true;
            }
        }
        return false;
    }

    public boolean timeReached(ItemStack item) {
        String timestamp = getTimeStamp(item);

        if (timestamp != null) {

            DateFormat df = new SimpleDateFormat(pattern);

            Date date = null;
            try {
                date = df.parse(timestamp);
            } catch (Exception e) {
                System.out.println("Something went wrong parsing a date.");
            }

            if (date != null) {

                Date now = getDate();

                return now.after(date);

            }

        }
        return false;
    }

    private String getTimeStamp(ItemStack item) {
        if (timeStampAssigned(item)) {
            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();
            return lore.get(5);
        }
        return null;
    }

}
