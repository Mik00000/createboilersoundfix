package com.mik.createboilersoundfix;

import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CreateBoilerSoundFixMod.MOD_ID)
public class CreateBoilerSoundFixMod {
    public static final String MOD_ID = "createboilersoundfix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public CreateBoilerSoundFixMod() {
        LOGGER.info("Create Boiler Sound Fix loaded: Steam boiler sound spam & lag fixed.");
    }
}
