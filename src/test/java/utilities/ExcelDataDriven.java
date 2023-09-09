package utilities;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.util.NumberToTextConverter;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelDataDriven {

		// Create a Array to save data
		ArrayList<String> arrData = new ArrayList<String>();

		static ReadConfig config = new ReadConfig();
		String DDexcelSheet = config.getExcelSheet();
		// Java method to read file
		@SuppressWarnings("deprecation")
		public ArrayList<String> dataDriven(String testCaseName) throws IOException {
			FileInputStream fis = new FileInputStream(DDexcelSheet);

			// Create a Excel workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			System.out.println("Number of Sheets: "+sheets);
			for (int i = 0; i < sheets; i++) {
				System.out.println("Sheet Name: "+workbook.getSheetName(i));
				if (workbook.getSheetName(i).equalsIgnoreCase("DataDriven")) {
					{
						XSSFSheet sheet = workbook.getSheetAt(i);
						// identify Testcase by scanning 1st row
						Iterator<Row> rows = sheet.iterator();
						Row firstrow = rows.next();

						Iterator<Cell> ce = firstrow.cellIterator();
						int k = 0;
						int column = 0;
						while (ce.hasNext()) {
							Cell values = ce.next();

							if (values.getStringCellValue().equalsIgnoreCase("Testcase")) {
								column = k;
							}
							k++;
						}
						System.out.println("TestCase at column index :" + column);
						// once column is identify then scan entire column to Register testcase
						while (rows.hasNext()) {

							Row r = rows.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
								// grab register testcase , pull all the data
								Iterator<Cell> cv = r.cellIterator();
								while (cv.hasNext()) {
									Cell c = cv.next();
									if (c.getCellTypeEnum() == CellType.STRING) {

										arrData.add(c.getStringCellValue());
									} else {

										arrData.add(NumberToTextConverter.toText(c.getNumericCellValue()));
									}
								}
							}
						}
					}
				}
			}
			return arrData;
		}
	}

