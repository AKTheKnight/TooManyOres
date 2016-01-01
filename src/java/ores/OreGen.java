package ores;

import com.aktheknight.toomanyores.TooManyOres;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;

public class OreGen {
	
	@SubscribeEvent
    public void onOreGenMinable(OreGenEvent.GenerateMinable e)
    {
		
        if (TooManyOres.VanillaGen == true) {
            e.setResult(Event.Result.DENY);
            return;
        }
        
        switch(e.type) {
            case DIRT:
                if (Configs.disableDirt == true) {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case GRAVEL:
                if (Configs.disableGravel == true) {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case COAL:
                if (Configs.disableCoal == true) {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case DIAMOND:
                if (Configs.disableDiamond == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case GOLD:
                if (Configs.disableGold == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case IRON:
                if (Configs.disableIron == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case LAPIS:
                if (Configs.disableLapis == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case REDSTONE:
                if (Configs.disableRedstone == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case QUARTZ:
                if (Configs.disableNetherQuartz == true)
                {
                    e.setResult(Event.Result.DENY);
                }
                break;
            default:
        }
    }
}
}
