package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.Jobs2dDriverDrawAdapter;
import edu.kis.powp.jobs2d.figures.Figures;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Figures actionFigure = getFigureEnum(e.getActionCommand());

		if (actionFigure == null) {
			System.out.println("Unknown action: " + e.getActionCommand());
			return;
		}

		switch (actionFigure) {
			case FIG_JOE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;

			case FIG_JOE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;

			case FIG_SQUARE:
				executeFigureSquareCommands();
				break;

			case FIR_TRIANGLE:
				executeFigureTriangleCommands();
				break;

			case FIG_CUSTOM:
				executeCustomFigureCommands();
				break;
		}
	}

	private Figures getFigureEnum(String command) {
		for (Figures figure : Figures.values()) {
			if (figure.getFigure().equals(command)) {
				return figure;
			}
		}
		return null;
	}


	private void executeFigureSquareCommands() {
		DriverCommand[] commands = {
				new SetPositionCommand(-200, -200),
				new OperateToCommand(200, -200),
				new OperateToCommand(200, 200),
				new OperateToCommand(200, -200),
				new OperateToCommand(-200, -200)
		};
		for (DriverCommand command : commands) {
			command.execute(driverManager.getCurrentDriver());
		}
	}

	private void executeFigureTriangleCommands() {
		ComplexCommand complexCommand = new ComplexCommand();
		complexCommand.addCommand(new SetPositionCommand(-200, 0));
		complexCommand.addCommand(new OperateToCommand(200, 0));
		complexCommand.addCommand(new OperateToCommand(0, -200));
		complexCommand.addCommand(new OperateToCommand(-200, 0));
		complexCommand.execute(driverManager.getCurrentDriver());
	}

	private void executeCustomFigureCommands() {
		ComplexCommand complexCommand = new ComplexCommand();
		complexCommand.addCommand(new SetPositionCommand(-200, -200));
		complexCommand.addCommand(new OperateToCommand(-100, 200));
		complexCommand.addCommand(new OperateToCommand(0, -200));
		complexCommand.addCommand(new OperateToCommand(100, 200));
		complexCommand.addCommand(new OperateToCommand(200, -200));
		complexCommand.execute(driverManager.getCurrentDriver());
	}


}
