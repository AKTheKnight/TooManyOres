package ores;

import java.util.Arrays;

import com.aktheknight.toomanyores.TooManyOres;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class OreGen {
	
	@SubscribeEvent
    public void onOreGenMinable(OreGenEvent.GenerateMinable e) {
		
		String[] types = {"COAL", "IRON", "GOLD", "DIAMOND", "LAPIS", "REDSTONE", "QUARTZ"};
		
		
        if (TooManyOres.VanillaGen == true) {
            e.setResult(Event.Result.DENY);
            return;
        }
        
        if(Arrays.asList(types).contains(e.type) && TooManyOres.VanillaOres == true) {
        	e.setResult(Event.Result.DENY);
        	return;
        }
        
        switch(e.type) {
            case DIRT:
                if (TooManyOres.Dirt == true) {
                    e.setResult(Event.Result.DENY);
                }
                break;
            case GRAVEL:
                if (TooManyOres.Gravel == true) {
                    e.setResult(Event.Result.DENY);
                }
                break;
            default:
        }
    }
}

