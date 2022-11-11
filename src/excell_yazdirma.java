import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class excell_yazdirma {

    public static void main(String[] args) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Data");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] { "ID", "ISIM", "SOYISIM" });
        data.put("2", new Object[] { 1, "Fadi", "Data" });
        data.put("3", new Object[] { 2, "Ercument", "Ercument" });
        data.put("4", new Object[] { 3, "Eyup", "Guler" });
        data.put("5", new Object[] { 4, "Yasemin", "Yol" });

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            // Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xls"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
