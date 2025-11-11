package exogenesis;

import arc.struct.*;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class ExoUnits{
    public static UnitType
        // Genesux faction mining drones
        ambassador, backwater;

    public void load(){
        // Load units from content folder
        // The units are defined in JSON, we just need to set their AI here

        // Find the units after content is loaded
        content.units().each(unit -> {
            if(unit.name.equals("exogenesis-drone-m")){
                ambassador = unit;
                setupMiningDrone(ambassador);
            }
            else if(unit.name.equals("exogenesis-drone-m2")){
                backwater = unit;
                setupMiningDrone(backwater);
            }
        });
    }

    private void setupMiningDrone(UnitType unit){
        if(unit == null) return;

        // Set up the unit to use mining AI
        unit.controller = u -> new MinerAI();
        unit.defaultController = MinerAI::new;

        // Ensure it's configured as a mining unit
        if(unit.mineTier < 0){
            unit.mineTier = 2; // Default mining tier
        }
        if(unit.mineSpeed <= 0){
            unit.mineSpeed = 3f; // Default mining speed
        }
    }
}
