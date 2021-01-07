package algoExpert;

import java.util.ArrayList;
import java.util.List;

//Recursion
public class LowestCommonManager {

	public static void main(String[] args) {
		
		
	}

}
//using another class beacuse we have to return the manager and the number of manger found matching
class OrgInfo
{
	OrgChart lowestCommonManager;
	int number;
	public OrgInfo(OrgChart lowestCommonManager, int number) {
		super();
		this.lowestCommonManager = lowestCommonManager;
		this.number = number;
	}

	
}


 class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
