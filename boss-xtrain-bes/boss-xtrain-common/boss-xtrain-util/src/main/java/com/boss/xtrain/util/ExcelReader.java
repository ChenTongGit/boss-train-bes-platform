package com.boss.xtrain.util;

import com.boss.xtrain.pojo.AbstractExcelDataVo;
import com.boss.xtrain.pojo.UserExcelVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;


public class ExcelReader {
    private static Logger logger = Logger.getLogger(ExcelReader.class.getName()); // 日志打印类

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private static final String DOT = ".";
    private static final List<String> CELLHEAD =MyReflectUtils.getFieldOneAnnotation(new UserExcelVo());
    private ExcelReader(){}
   /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws  IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List< AbstractExcelDataVo> readExcel(AbstractExcelDataVo dataVo,String fileName) {
        // 获取Excel后缀名
        String fileType = fileName.substring(fileName.lastIndexOf(DOT) + 1, fileName.length());
        // 获取Excel文件
        File excelFile = new File(fileName);
        try(FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook workbook = getWorkbook(inputStream, fileType)) {

            if (!excelFile.exists()) {
                logger.warning("指定的Excel文件不存在！");
                return new ArrayList<>();
            }

            // 获取Excel工作簿


            // 读取excel中的数据
            List<AbstractExcelDataVo> resultDataList = parseExcel(dataVo,workbook);

            return resultDataList;
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return new ArrayList<>();

        }
    }
    public static List<AbstractExcelDataVo> readExcel(AbstractExcelDataVo dataVo, MultipartFile file) {
        // 获取Excel后缀名
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isEmpty() || fileName.lastIndexOf(DOT) < 0) {
            logger.warning("解析Excel失败，因为获取到的Excel文件名非法！");
            return new ArrayList<>();
        }
        String fileType = fileName.substring(fileName.lastIndexOf(DOT) + 1, fileName.length());


        try( Workbook workbook = getWorkbook(file.getInputStream(), fileType)) {


            // 获取Excel工作簿

            // 读取excel中的数据
            List<AbstractExcelDataVo> resultDataList = parseExcel(dataVo,workbook);

            return resultDataList;
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名：" + file.getOriginalFilename() + " 错误信息：" + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List< AbstractExcelDataVo> parseExcel(AbstractExcelDataVo dataVo,Workbook workbook)  {
        List<AbstractExcelDataVo> resultDataList = new ArrayList<>();
        Class<?> clazz = dataVo.getClass();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }
                try {
                    Constructor<?> c = clazz.getConstructor();
                    Object resultDate = c.newInstance();
                    AbstractExcelDataVo resultData = convertRowToData((AbstractExcelDataVo) resultDate,row);
                    resultDataList.add(resultData);
                }catch (Exception e){
                    logger.info(e.getMessage());
                }

            }
        }

        return resultDataList;
    }

    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }

    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     *
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static AbstractExcelDataVo convertRowToData(AbstractExcelDataVo resultData,Row row) {
        Cell cell=null;
        int cellNum = 0;

        Field[] fields = MyReflectUtils.getAllField(resultData).toArray(new Field[0]);
        for (Field field:
             fields) {
            cell = row.getCell(cellNum++);
            String value= convertCellValueToString(cell);
            MyReflectUtils.setFieldValue(resultData,field,value);
        }

        return resultData;
    }

    /**
     * 生成Excel并写入数据信息
     * @param dataList 数据列表
     * @return 写入数据后的工作簿对象
     */

    public static Workbook exportData(List<AbstractExcelDataVo> dataList){
        // 生成xlsx的Excel
        Workbook workbook = new SXSSFWorkbook();
/**
        // 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也需更改为xls
        //Workbook workbook = new HSSFWorkbook();
**/
        // 生成Sheet表，写入第一行的列头
        Sheet sheet = buildDataSheet(workbook);
        //构建每行的数据内容
        int rowNum = 1;
        for (Iterator<AbstractExcelDataVo> it = dataList.iterator(); it.hasNext(); ) {
            AbstractExcelDataVo data = it.next();
            if (data == null) {
                continue;
            }
            //输出行数据
            Row row = sheet.createRow(rowNum++);
            convertDataToRow(data, row);
        }
        return workbook;
    }

    public static void writeToExcel(String pathName,List<AbstractExcelDataVo> list){
        // 写入数据到工作簿对象内
        Workbook workbook = ExcelReader.exportData(list);

        // 以文件的形式输出工作簿对象
        String exportFilePath = pathName;
        File exportFile = new File(exportFilePath);
        try(FileOutputStream fileOut= new FileOutputStream(exportFilePath)){
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warning("输出Excel时发生错误，错误原因：" + e.getMessage());
        }


    }
    /**
     * 生成sheet表，并写入第一行数据（列头）
     * @param workbook 工作簿对象
     * @return 已经写入列头的Sheet
     */
    private static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        // 设置列头宽度
        for (int i=0; i<CELLHEAD.size(); i++) {
            sheet.setColumnWidth(i, 4000);
        }
        // 设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        // 构建头单元格样式
        CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
        // 写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELLHEAD.size(); i++) {
            Cell cell = head.createCell(i);
            cell.setCellValue(CELLHEAD.get(i));
            cell.setCellStyle(cellStyle);
        }
        return sheet;
    }

    /**
     * 设置第一行列头的样式
     * @param workbook 工作簿对象
     * @return 单元格样式对象
     */
    private static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 下边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边框
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex()); // 右边框
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex()); // 上边框
        //设置背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字设置
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    /**
     * 将数据转换成行
     * @param data 源数据
     * @param row 行对象
     * @return
     */
    private static void convertDataToRow(AbstractExcelDataVo data, Row row){
        int cellNum = 0;
        Cell cell = null;
        Field[] fields = MyReflectUtils.getAllField(data).toArray(new Field[0]);
        for (Field field:
             fields) {
            cell = row.createCell(cellNum++);
            String value= (String) MyReflectUtils.getFieldValue(data,field);
            cell.setCellValue(null == value?"":value);
        }
    }
}
