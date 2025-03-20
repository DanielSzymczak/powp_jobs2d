package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class Jobs2dDriverDrawAdapter extends DrawPanelController implements Job2dDriver {
	private int startX = 0, startY = 0;
	private final ILine lineType;

	public Jobs2dDriverDrawAdapter() {
		super();
		this.lineType = LineFactory.getBasicLine();
	}

	public Jobs2dDriverDrawAdapter(ILine lineType){
		this.lineType=lineType;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = lineType;
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		setPosition(x,y);

		edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController().drawLine(line);

	}

	@Override
	public String toString() {
		return "@Q!$!@$!#@$(*#@&Q(%^*#@";
	}
}
