package my.custom.area;

import java.util.List;
import java.util.ArrayList;

public class ControllerIMPL implements Controller{
	TableRetriever tableManager;
	OpFacadeInter operations;
	
	@Override
	public void addRegion(String location) {
		this.tableManager.addRegion(location);
	}

	@Override
	public void addTimeSeries(String date1, String date2) {
		this.tableManager.addTimeSeries(date1, date2);
	}

	@Override
	public void resetData() {
		this.tableManager.reset();
	}


	@Override
	public void setStatTest() {
		this.operations.setStatTest();
	}

	@Override
	public void setCompareNHPI() {
		this.operations.setCompareNHPI();
	}

	@Override
	public void setMLForecast() {
		this.operations.setMLForecast();
	}

	@Override
	public List<String> execute() {
		try {
			return this.operations.launchOperation(this.tableManager.getTables());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String errorString = "An error occured in the operation";
			List<String> result = new ArrayList<String>();
			result.add(errorString);
			return result;
		}
	}

}