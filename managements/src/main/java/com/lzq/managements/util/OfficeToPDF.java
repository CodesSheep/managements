package com.lzq.managements.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Office2003-2007全部格式的文档(.doc|.docx|.xls|.xlsx|.ppt|.pptx)转化为pdf文件,Office2010的没测试
 * @author zhangbao
 * @date 2017-03-03
 */
public class OfficeToPDF {

    private static final Log LOG = LogFactory.getLog(OfficeToPDF.class);

    /**
     * 转pdf文件
     * @param inputFilePath  源文件路径
     * @return
     */
    public static File officeToPdf(String inputFilePath) {
        OfficeManager officeManager = null;
        try {
            boolean empty = StringUtils.isEmpty(inputFilePath);
            if (empty) {
                LOG.info("输入文件地址为空，转换终止!");
                return null;
            }

            File inputFile = new File(inputFilePath);
            // 转换后的文件路径
            String outputFilePath = getOutputFilePath(inputFilePath);

            if (!inputFile.exists()) {
                LOG.info("输入文件不存在，转换终止!");
                return null;
            }

            // 获取OpenOffice的安装路径并启动
            officeManager = getOfficeManager();
            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);

            return converterFile(inputFile, outputFilePath, converter);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("转化出错!", e);
        } finally {
            // 停止openOffice
            if (officeManager != null) {
                officeManager.stop();
            }
        }
        return null;
    }

    /**
     * 获取输出文件
     * @param inputFilePath
     * @returnf
     */
    public static String getOutputFilePath(String inputFilePath) {
        String postfix = inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1);
        String outputFilePath = inputFilePath.replaceAll("." + postfix, ".pdf");
        return outputFilePath;
    }

    /**
     * 连接OpenOffice 并且启动OpenOffice
     * @return
     */
    public static OfficeManager getOfficeManager() {
        DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();
        // 设置OpenOffice.org 3的安装目录
        config.setOfficeHome(getOfficeHome());
        // 启动OpenOffice的服务
        OfficeManager officeManager = config.buildOfficeManager();
        officeManager.start();
        return officeManager;
    }

    /**
     * 根据操作系统的名称，获取OpenOffice的安装目录<br>
     * 如我的OpenOffice安装在：C:/Program Files (x86)/OpenOffice 4<br>
     * @return OpenOffice的安装目录
     */
    public static String getOfficeHome() {
        String osName = System.getProperty("os.name");
        System.out.println("操作系统名称:" + osName);

        if (Pattern.matches("Linux.*", osName)) {
            return "/opt/openoffice.org3";
        } else if (Pattern.matches("Windows.*", osName)) {
            return "C:\\Program Files (x86)\\OpenOffice 4"
                    + "";
        } else if (Pattern.matches("Mac.*", osName)) {
            return "/Applications/OpenOffice.org.app/Contents/";
        }
        return null;
    }

    /**
     * 转换文件
     * @param inputFile
     * @param outputFilePath
     * @param converter
     */
    public static File converterFile(File inputFile, String outputFilePath,OfficeDocumentConverter converter) {
        File outputFile = new File(outputFilePath);
        // 假如目标路径不存在,则新建该路径
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        converter.convert(inputFile, outputFile);
        return outputFile;
    }

    public static void main(String[] args) {
        File file = officeToPdf("C:\\Users\\Administrator\\Desktop\\office2pdf\\三亚站点清单20180824.xlsx");
    }
}