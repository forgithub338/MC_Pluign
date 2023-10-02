package bs.untitled10;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static bs.untitled10.SetMainHand.playerMainHand;

public class ArmsSkill implements Listener {
    private final Map<UUID, Boolean> playerSneak = new HashMap<>();
    private final Map<UUID, Long>    playerCold  = new HashMap<>();
    private final Map<UUID, Boolean> isSkillCold = new HashMap<>();
    private final JavaPlugin         plugin;

    public ArmsSkill(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    //技能啟動
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player   = e.getPlayer();
        UUID   playerId = player.getUniqueId();
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!playerSneak.getOrDefault(playerId, false)) {
            return;
        }

        if (!isPlayerCold(playerId)) {
            player.sendMessage(ChatColor.RED + "尚在冷卻時間");
            return;
        }

        ItemStack arms = player.getInventory().getItem(playerMainHand.getOrDefault(playerId, 1) - 1);
        if (arms == null) {
            return;
        }

        ItemMeta armsMeta = arms.getItemMeta();
        if (armsMeta.getDisplayName().equals(ChatColor.DARK_GREEN + "玄鐵重劍")) {
            coldTime(playerId, 20);
            continueTime(playerId, arms, 5, true);
        }
        else if (armsMeta.getDisplayName().equals(ChatColor.AQUA + "忘憂劍")) {
            coldTime(playerId, 20);
            continueTime(playerId, arms, 1, false);
        }
        else if (armsMeta.getDisplayName().equals(ChatColor.DARK_AQUA + "赤霄劍")) {
            coldTime(playerId, 20);
            continueTime(playerId, arms, 1, false);
        }
        else if (armsMeta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "霜痕劍")) {
            coldTime(playerId, 20);
            continueTime(playerId, arms, 1, false);
        }
    }


    //判定潛行
    @EventHandler
    private void sneaking(PlayerToggleSneakEvent e) {
        Player player   = e.getPlayer();
        UUID   playerId = player.getUniqueId();
        if (e.isSneaking()) {
            playerSneak.put(playerId, true);
        }
        else {
            playerSneak.put(playerId, false);
        }
    }


    //冷卻及持續時間設置
    public void coldTime(UUID playerId, Integer coldTime) {
        long currentTime = System.currentTimeMillis();
        playerCold.put(playerId, currentTime + (coldTime * 1000));

        new BukkitRunnable() {
            @Override
            public void run() {
                Player player = Bukkit.getPlayer(playerId);
                if (player != null) {
                    player.sendMessage(ChatColor.GREEN + "技能冷卻時間結束");
                }
            }
        }.runTaskLater(plugin, coldTime * 20);
    }

    public void continueTime(UUID playerId, ItemStack arms, Integer continueTime, Boolean removeSkill) {
        Player player = Bukkit.getPlayer(playerId);
        isSkillCold.put(playerId, true);
        equipSkill(playerId, arms);


        new BukkitRunnable() {
            @Override
            public void run() {
                if (!(player == null)) {
                    isSkillCold.put(playerId, false);
                    if (removeSkill) {
                        equipSkill(playerId, arms);
                    }
                }
            }
        }.runTaskLater(plugin, continueTime * 20);
    }

    public boolean isPlayerCold(UUID playerId) {
        long currentTime = System.currentTimeMillis();
        return currentTime >= playerCold.getOrDefault(playerId, (long) 1);
    }

    //判定發動的技能
    public void equipSkill(UUID playerId, ItemStack arms) {
        Player   player   = Bukkit.getPlayer(playerId);
        ItemMeta armsMeta = arms.getItemMeta();
        if (isSkillCold.get(playerId)) {//技能發動
            if (armsMeta.getDisplayName().equals(ChatColor.DARK_GREEN + "玄鐵重劍")) {
                armsMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
                arms.setItemMeta(armsMeta);
                player.sendMessage("發動玄鐵重劍技能");
                return;
            }
            else if (armsMeta.getDisplayName().equals(ChatColor.AQUA + "忘憂劍")) {
                int radius = 5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 5 * 20, 1));
                    }
                }
                player.sendMessage("發動忘憂劍技能");
                return;
            }
            else if (armsMeta.getDisplayName().equals(ChatColor.DARK_AQUA + "赤霄劍")) {
                int radius = 5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        entity.setFireTicks(5 * 20);
                        BukkitRunnable runnable = new BukkitRunnable() {
                            int times = 0;

                            @Override
                            public void run() {
                                if (times < 5) {
                                    double currentHealth = livingEntity.getHealth();
                                    double newHealth     = currentHealth - 100;
                                    if (newHealth <= 0) {
                                        livingEntity.setHealth(0);
                                        livingEntity.damage(0);
                                    }
                                    else {
                                        livingEntity.setHealth(newHealth);
                                    }
                                    times++;
                                }
                                else {
                                    cancel();
                                }
                            }
                        };
                        runnable.runTaskTimer(plugin, 0L, 20L);
                    }
                }
                player.sendMessage("發動赤霄劍技能");
                return;
            }

            else if (armsMeta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "霜痕劍")) {
                int radius = 5;
                player.sendMessage("發動霜痕劍技能");
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * 20, 4));

                        BukkitRunnable runnable = new BukkitRunnable() {
                            int times = 0;

                            @Override
                            public void run() {
                                if (times < 5) {
                                    double currentHealth = livingEntity.getHealth();
                                    double newHealth     = currentHealth - 1;
                                    if (newHealth <= 0) {
                                        livingEntity.setHealth(0);
                                        livingEntity.damage(0);
                                    }
                                    else {
                                        livingEntity.setHealth(newHealth);
                                    }
                                    times++;
                                }
                                else {
                                    cancel();
                                }
                            }
                        };
                        runnable.runTaskTimer(plugin, 0L, 20L);
                    }
                }
                return;
            }

        }
        else {//技能結束
            //玄鐵重劍
            if (armsMeta.getDisplayName().equals(ChatColor.DARK_GREEN + "玄鐵重劍")) {
                armsMeta.removeEnchant(Enchantment.KNOCKBACK);
                arms.setItemMeta(armsMeta);
                player.sendMessage("玄鐵重劍技能結束");
            }
            //忘憂劍
            //赤霄劍
            //無
            //霜痕劍
            //無
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        isSkillCold.remove(e.getPlayer().getUniqueId());
    }
}
