package lr10;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelExample {

    static final String FILE = "src/lr10/example.xlsx";

    public static void main(String[] args) throws Exception {
        new File("src/lr10").mkdirs();
        createExcel();
        System.out.println();
        readExcel();
    }
    static void createExcel() throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Товары");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Название");
        header.createCell(1).setCellValue("Характеристики");
        header.createCell(2).setCellValue("Стоимость");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Книга");
        row1.createCell(1).setCellValue("Java Programming, 500 стр.");
        row1.createCell(2).setCellValue(1500.0);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("Компьютер");
        row2.createCell(1).setCellValue("Intel i7, 16GB RAM, 512GB SSD");
        row2.createCell(2).setCellValue(75000.0);

        try (FileOutputStream fos = new FileOutputStream(FILE)) {
            workbook.write(fos);
        }
        workbook.close();
        System.out.println("Excel файл создан: " + FILE);
    }

    static void readExcel() throws Exception {
        try (FileInputStream fis = new FileInputStream(FILE);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("Лист: " + sheet.getSheetName());

            for (Row row : sheet) {
                StringBuilder sb = new StringBuilder();
                for (Cell cell : row) {
                    sb.append(cell.toString()).append("\t");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}
