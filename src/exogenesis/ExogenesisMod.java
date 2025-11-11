package exogenesis;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class ExogenesisMod extends Mod{

    public ExogenesisMod(){
        Log.info("Loaded ExogenesisMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Exogenesis");
                dialog.cont.add("Welcome to Exogenesis Redux!").row();
                dialog.cont.image(Core.atlas.find("exogenesis-icon")).pad(20f).row();
                dialog.cont.add("A mod that adds tons of new content.").row();
                dialog.buttons.button("OK", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading Exogenesis content.");
        // Load custom content here
        new ExoUnits().load();
    }

}
