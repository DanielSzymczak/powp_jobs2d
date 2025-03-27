package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{
    private final ArrayList<DriverCommand> commandsList;

    public ComplexCommand(){
        this.commandsList = new ArrayList<>();
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand driverCommand : commandsList){
            driverCommand.execute(driver);
        }
    }

    public void addCommand(DriverCommand driverCommand){
        commandsList.add(driverCommand);
    }

}