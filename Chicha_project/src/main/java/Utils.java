import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Utils {
    public static ArrayList<Group> parse(String fileName) {
        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Group> groups = new ArrayList<Group>();

        for (int i = 0; i < Objects.requireNonNull(workBook).getNumberOfSheets(); i++) {
            Group group = new Group();
            ArrayList<ArrayList<Double>> StudentCells = new ArrayList<ArrayList<Double>>();

            //разбираем i-ый лист входного файла на объектную модель
            Sheet sheet = workBook.getSheetAt(i);

            int n = 0;

            Iterator<Row> it = sheet.iterator();
            //проходим по всему листу
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                ArrayList<Double> currentStudentCells = new ArrayList<Double>();
                if (n == 0){
                    String name = cells.next().getStringCellValue();
                    group.setName(name);
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        String[] data = cell.getStringCellValue().split(":");
                        group.addTeacher(data[1]);
                        group.addLessonName(data[0]);
                    }
                }
                else {
                    String studentName = cells.next().getStringCellValue();
                    group.addStudent(studentName);
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        currentStudentCells.add(cell.getNumericCellValue());
                    }
                    group.addCells(currentStudentCells);
                }
                n += 1;
            }
            groups.add(group);
        }

        return groups;
    }
}
