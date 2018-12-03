package com.lzq.managements.entity.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity implements Serializable {
    private static final long serialVersionUID = 5068793171634863975L;
    private Long serial;
    private String userNo;
    private String mediaNo;
    private String mediaName;
    private String link;
    private Date createTime;
    private String fileName;
    private String fileState;
    private Date loginTime;
    private String remark;
    private String filePath;
    private String empNo;
    private String empName;
    private String contacts;
}
