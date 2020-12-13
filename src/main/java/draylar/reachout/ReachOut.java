package draylar.reachout;

import draylar.reachout.config.ReachOutConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ReachOut implements ModInitializer {

    public static final ReachOutConfig CONFIG = AutoConfig.register(ReachOutConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {

    }
}
