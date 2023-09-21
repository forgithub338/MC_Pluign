package bs.untitled10.Energy;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GetDrinkListener implements Listener {
    // 用於追蹤玩家冷卻時間的Map
    private final Map<UUID, Long> cooldowns = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory clickedInventory = e.getClickedInventory();

        // 確保事件來自玩家點擊伺服器菜單
        if (clickedInventory != null && e.getView().getTitle().equals("伺服器菜單")) {
            e.setCancelled(true);

            // 確保點擊的物品不為空
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem != null && clickedItem.hasItemMeta()) {
                String itemName = clickedItem.getItemMeta().getDisplayName();

                // 檢查點擊的物品是否是領取美味牛排
                if (itemName.equals("領取靈氣丹")) {
                    Player player = (Player) e.getWhoClicked();

                    // 檢查冷卻時間
                    if (!cooldowns.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldowns.get(player.getUniqueId()) >= 2 * 60 * 60 * 1000) {
                        ItemStack food = new ItemStack(Material.MILK_BUCKET, 1);
                        ItemMeta foodMeta = food.getItemMeta();
                        foodMeta.setDisplayName("靈氣丹");
                        foodMeta.setLore(Arrays.asList("官方出品", "定時領取牛排"));
                        food.setItemMeta(foodMeta);
                        player.getInventory().addItem(food);

                        // 設置冷卻時間為當前時間
                        cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
                    } else {
                        // 玩家仍處於冷卻時間，計算剩餘時間並通知玩家
                        long remainingTime =60 * 1000 - (System.currentTimeMillis() - cooldowns.get(player.getUniqueId()));
                        if (remainingTime > 0) {
                            int minutes = (int) (remainingTime / (60 * 1000));
                            int seconds = (int) ((remainingTime % (60 * 1000)) / 1000);
                            player.sendMessage("你仍在冷卻中，剩餘時間：" + minutes + "分" + seconds + "秒");
                        } else {
                            // 冷卻時間已過，給予牛排並重製冷卻時間
                            ItemStack food = new ItemStack(Material.MILK_BUCKET, 1);
                            ItemMeta foodMeta = food.getItemMeta();
                            foodMeta.setDisplayName("靈氣丹");
                            foodMeta.setLore(Arrays.asList("官方出品", "定時領取牛排"));
                            food.setItemMeta(foodMeta);
                            player.getInventory().addItem(food);

                            // 設置冷卻時間為當前時間
                            cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    }
                }
            }
        }
    }
}
