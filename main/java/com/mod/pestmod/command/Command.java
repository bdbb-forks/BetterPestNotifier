package com.mod.pestmod.command;

import net.minecraft.command.CommandBase;

public abstract class Command extends CommandBase {
    private final String DESCRIPTION;

    public Command(final String DESCRIPTION) {
        super();
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }


    //Make all instances of command need 0 permission level to execute the command, because I'm an awesome programmer and follow DRY!
    @Override
    public final int getRequiredPermissionLevel() {
        return 0;
    }


}
