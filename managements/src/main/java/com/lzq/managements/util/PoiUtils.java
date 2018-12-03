package com.lzq.managements.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : huhy on 2018/7/21.
 * @Project_name:pumpingstation
 * @LOCAL:com.xf.station.utils
 * @description:关于文件导出的工具类
 */
public class PoiUtils {

    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 14:33 
     * @Description: 处理controller请求
     */
    public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
        //调打印方法
        exportExcel(data, response.getOutputStream());
    }
    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 14:35 
     * @Description: 形成导出文档
     */
    public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
        /**
         *         1. 使用 HSSFWorkbook 对象实现excel导出。导出的行数 至多为 65535 行
         *
         *         2. 使用 XSSFWorkbook 对象实现excel导出。 最多可以 导出 104 万行（创建的book sheet row cell都在内存中，数据量一大容易OOM--内存溢出）
         *
         *         3. 使用 SXSSFWorkbook 对象实现excel导出。 一般是导出百万级数据的excel，设置条数rowAccessWindowSize（如：new SXSSFWorkbook(5000);），行数达到rowAccessWindowSize时，把内存持久化写到文件中，以此逐步写入避免OOM
         *
         *         4. 使用 template.xls 格式模板，实现excel导出（即使用本地模板）。 一般是导出有固定字段的excel
         *               使用本地模板创建workbook的代码如下：
         *
         *               工程目录下：    InputStream in = this.getClass().getResourceAsStream("/templates/template.xls");
         *               本地磁盘目录下：InputStream in = new FileInputStream(new File("E:\\template.xls");
         *                             POIFSFileSystem poifsFileSystem = new POIFSFileSystem(in);
         *                           1.HSSFWorkbook workbook1 = new HSSFWorkbook(poifsFileSystem);
         *                           2.XSSFWorkbook workbook2 = new XSSFWorkbook(in);
         *                           3.SXSSFWorkbook workbook3 = new SXSSFWorkbook(workbook2,5000);--使用SXSSFWorkbook对象应用本地模板时，得先用XSSFWorkbook对象读取文件流，再注入
         */
        SXSSFWorkbook sxssfWB = new SXSSFWorkbook(5000);
        try {
            //传入名字
            String sheetName = data.getName();
            if (null == sheetName) {
                sheetName = "Sheet1";
            }
            SXSSFSheet sheet = sxssfWB.createSheet(sheetName);
            //对数据进行处理
            writeExcel(sxssfWB, sheet, data);
            sxssfWB.write(out);
        } finally {
            sxssfWB.close();
        }
    }
    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 14:36 
     * @Description: 对数据进行处理
     */
    private static void writeExcel(SXSSFWorkbook sxssfWB, SXSSFSheet sheet, ExcelData excelData) {
        writeDatasToExcel(sxssfWB, sheet, excelData.getData(), excelData.getTitlelist(), excelData.getHeadnums(), excelData.getLogo(),
                excelData.getTitle(), excelData.getDisplay(), excelData.getLinkFieldName(), excelData.getUrlFieldName());
        List<List<String>> titlelist = excelData.getTitlelist();
        sheet.trackAllColumnsForAutoSizing();
        autoSizeColumns(sheet, titlelist.get(0).size() + 1);
    }
    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 14:37 
     * @Description: 表头的操作
     */
    private static int writeTitlesToExcel(SXSSFWorkbook sxssfwb, Sheet sheet, List<List<String>> titlelist, List<String> headnums,
                                          byte[] logo, String title, CellStyle titleStyle , CellStyle tstytle) {

        int rowIndex = 0;
        if (logo != null) {
            //加logo
            Drawing patriarch = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, rowIndex, rowIndex, rowIndex + 1, rowIndex + 1);
            anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
            patriarch.createPicture(anchor, sxssfwb.addPicture(logo, SXSSFWorkbook.PICTURE_TYPE_PNG));
        }
        if (title != null){
            //加大标题
            Row trow = sheet.createRow(rowIndex);
            trow.setHeight((short) (20 * 30));
            Cell tcell = trow.createCell(1);
            tcell.setCellValue(title);
            tcell.setCellStyle(tstytle);
        }
        if (logo != null || title != null){
            rowIndex++;
        }
        //创建表头
        for (List<String> list : titlelist){
            Row titleRow = sheet.createRow(rowIndex);
            int colIndex = 0;
            for (String field : list) {
                Cell cell = titleRow.createCell(colIndex);
                cell.setCellValue(field);
                cell.setCellStyle(titleStyle);
                colIndex++;
            }
            rowIndex++;
        }
        //合并单元格
        for (String headnum : headnums){
            String[] strings = headnum.split(",");
            addMergedRegion(sheet,Integer.valueOf(strings[0]),Integer.valueOf(strings[1]),Integer.valueOf(strings[2]),Integer.valueOf(strings[3]));
        }
        return rowIndex;
    }
    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 15:38 
     * @Description: 表体进行操作
     * * @param wb
     * @param sheet
     * @param datas    表体数据
     * @param titlelist  表头列表
     */
    private static <T> void writeDatasToExcel(SXSSFWorkbook sxssfwb, Sheet sheet, List<T> datas, List<List<String>> titlelist ,
                                              List<String> headnums, byte[] logo, String title, List<String> display, String linkFieldName, String urlFieldName) {

        Map<String, CellStyle> styles = createStyles(sxssfwb);
        CellStyle dataStyle = styles.get("data1Style");
        CellStyle linkStyle = styles.get("linkStyle");
        CellStyle titleStyle = styles.get("titleStyle");
        CellStyle tstyle = styles.get("tstyle");

        //对表头进行填充
        int rowIndex = writeTitlesToExcel(sxssfwb, sheet, titlelist, headnums, logo, title, titleStyle, tstyle);

        int colIndex;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //创建画图管理器
        Drawing patriarch = sheet.createDrawingPatriarch();
        //填充表体的数据
        for (T t : datas) {
            Row dataRow = sheet.createRow(rowIndex);
            colIndex = 0;
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0;i < fields.length;i++) {
                //跳过不需要展示的字段
                if (!display.contains(fields[i].getName())){
                    continue;
                }
                //超链接地址
                String link = null;
                if (linkFieldName != null && urlFieldName != null) {
                    if (linkFieldName.equals(fields[i].getName())) {
                        try {
                            Field field = t.getClass().getDeclaredField(urlFieldName);
                            field.setAccessible(true);
                            link = (String) field.get(t);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                //创建表体数据填充
                Cell cell = dataRow.createCell(colIndex);
                Object object = null;
                String value = null;
                try {
                    //反射获取该属性的值
                    fields[i].setAccessible(true);
                    object = fields[i].get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (object != null && object instanceof Date){
                    value = sdf.format((Date)object);
                }else if (object != null && object instanceof byte[]){
                    //这里byte[]当图片处理，具体情况具体处理

                    //创建锚点，用来设置X轴、Y轴偏移，图片位置，是否移动、调整等
                    XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, colIndex,rowIndex, colIndex+1, rowIndex+1);
                    //MOVE_AND_RESIZE表示：移动且调整
                    anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
                    patriarch.createPicture(anchor, sxssfwb.addPicture((byte[])object, SXSSFWorkbook.PICTURE_TYPE_JPEG));
                }else if (object != null && object instanceof BigDecimal){
                    //BigDecimal四舍五入保留两位小数
                    value = ((BigDecimal)object).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
                }else {
                    value = object == null ? null : object.toString();
                }
                //加超链接
                if (link != null){
                    cell.setCellFormula("HYPERLINK(\"" + link + "\",\""+ value+"[案例]" +"\")");
                    //设置超链接样式
                    cell.setCellStyle(linkStyle);
                }else if (link == null && value != null) {
                    cell.setCellValue(value);
                    cell.setCellStyle(dataStyle);
                } else {
                    cell.setCellValue("");
                    cell.setCellStyle(dataStyle);
                }
                colIndex++;
            }
            rowIndex++;
        }
    }

    private static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i,true);
            int newWidth = sheet.getColumnWidth(i) + 100;
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }

    /**
     * @author huhy
     * @ClassName:PoiUtils
     * @date 2018/7/21 15:01 
     * @Description: 表格样式设置
     */
    public static Map<String, CellStyle> createStyles(SXSSFWorkbook sxssfwb){
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        //表头格式
        CellStyle cellStyle = sxssfwb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderRight(BorderStyle.NONE);
        cellStyle.setBorderLeft(BorderStyle.NONE);
        cellStyle.setBorderTop(BorderStyle.NONE);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        //以下两项一起用背景色才会生效
        //titleStyle.setFillForegroundColor((short) 25);
        //titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font titleFont = sxssfwb.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 12);
        titleFont.setBold(true);
        cellStyle.setFont(titleFont);
        styles.put("titleStyle", cellStyle);

        //表体格式设置
        CellStyle cellStyle1 = sxssfwb.createCellStyle();
        cellStyle1.setDataFormat(sxssfwb.createDataFormat().getFormat(BuiltinFormats.getBuiltinFormat(4)));
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setBorderRight(BorderStyle.THIN);
        cellStyle1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle1.setBorderLeft(BorderStyle.THIN);
        cellStyle1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle1.setBorderTop(BorderStyle.THIN);
        cellStyle1.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle1.setBorderBottom(BorderStyle.THIN);
        cellStyle1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
       // dataRn1FormatStyle.setFillBackgroundColor(HSSFColor.RED.index);
       // dataRn1FormatStyle.setFillForegroundColor(HSSFColor.RED.index);
       // dataRn1FormatStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font data5Font = sxssfwb.createFont();
        data5Font.setFontName("宋体");
        data5Font.setFontHeightInPoints((short) 11);
        cellStyle1.setFont(data5Font);
        styles.put("data1Style", cellStyle1);

        //设置超链接样式
        CellStyle linkStyle = sxssfwb.createCellStyle();
        Font font = sxssfwb.createFont();
        font.setUnderline((byte) 1);
        font.setColor(IndexedColors.BLUE.index);
        linkStyle.setFont(font);
        linkStyle.setAlignment(HorizontalAlignment.CENTER);
        linkStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        styles.put("linkStyle",linkStyle);
        //大标题样式
        CellStyle tstyle = sxssfwb.createCellStyle();
        Font tfont = sxssfwb.createFont();
        tfont.setFontName("宋体");
        tfont.setFontHeightInPoints((short)20);
        tfont.setColor(IndexedColors.RED.index);
        tstyle.setFont(tfont);
        tstyle.setAlignment(HorizontalAlignment.LEFT);
        tstyle.setVerticalAlignment(VerticalAlignment.CENTER);
        styles.put("tstyle",tstyle);

        return styles;
    }



    /**
     * Discription:[自由合并行列函数]
     * @param firstRow
     * @param lastRow
     * @param firstCol
     * @param lastCol
     *             sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
     */
    public static void addMergedRegion(Sheet sheet,int firstRow, int lastRow, int firstCol, int lastCol){
        sheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow, firstCol, lastCol));
    }

}
