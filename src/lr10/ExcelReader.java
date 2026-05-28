package lr10;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Scanner;

public class ExcelReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            readSafe(ExcelExample.FILE, "Товары");
            System.out.print("\nПовторить чтение? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("да")) break;
        }
        scanner.close();
    }

    static void readSafe(String filePath, String sheetName) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Ошибка: файл не найден - " + filePath);
            System.out.println("Подсказка: запустите ExcelExample для создания файла");
            return;
        }

        if (!filePath.endsWith(".xlsx")) {
            System.out.println("Ошибка: неверный формат файла '" + filePath + "'");
            System.out.println("Подсказка: программа поддерживает только файлы .xlsx");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Ошибка: лист '" + sheetName + "' не найден");
                System.out.println("Доступные листы:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.out.println("  - " + workbook.getSheetName(i));
                }
                return;
            }

            System.out.println("Лист: " + sheetName + ", строк: " + (sheet.getLastRowNum() + 1));

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String value;
                    try {
                        value = switch (cell.getCellType()) {
                            case STRING  -> cell.getStringCellValue();
                            case NUMERIC -> String.valueOf((long) cell.getNumericCellValue());
                            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                            default      -> cell.toString();
                        };
                    } catch (Exception e) {
                        value = "[ошибка чтения ячейки]";
                    }
                    System.out.print(value + "\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            System.out.println("Подсказка: убедитесь, что файл не открыт в другой программе");
        }
    }
}
