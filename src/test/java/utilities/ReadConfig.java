package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	String FilePath;

	public ReadConfig() {
		FilePath = ".//Configuration/ReadConfig.properties";
		try {
			FileInputStream fis = new FileInputStream(FilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error message " + e.getMessage());
		}

	}

	public void setPropertyBatchName(String BatchName) {
		try {

			System.out.println("Set property");
			// modifies existing or adds new property
			prop.setProperty("updatedBatch", BatchName);

			// save modified property file
			FileOutputStream output = new FileOutputStream(FilePath);
			prop.store(output, "This description goes to the header of a file");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Get Updated Batch Name
	public String getUpdatedBatchName() {
		return prop.getProperty("updatedBatch");
	}

	// Get Application baseURl
	public String getApplicationURL() {
		return prop.getProperty("baseurl");
	}

	// Get browser Name
	public String getBrowserName() {
		return prop.getProperty("browser");
	}

	// Get Search Batch
	public String getSearchBatch() {
		return prop.getProperty("searchBatch");
	}

	// Get Edit Batch Description
	public String getEditbatchDescription() {
		return prop.getProperty("EditbatchDescription");
	}

	// GetEdit Batch No Of Classes
	public String EditBatchNoOfClasses() {
		return prop.getProperty("editBatchNoOfClasses");
	}

	// Data Driven
	public String getExcelSheet() {
		return prop.getProperty("ExcelSheet");
	}

	// Get user name
	public String getsearchuser() {
		return prop.getProperty("searchuser");

	}
	public String getsearchassign() {
		return prop.getProperty("searchassign");
	}
	public String assigngrade() {
		return prop.getProperty("assigngrade");
	}
	public String assigndescription() {
		return prop.getProperty("assigndesc");
	}

}
