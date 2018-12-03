package com.lzq.managements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable {

    private static final long serialVersionUID = 9012206378449255289L;
    private Long serial;
    private String teamNo;
    private String teamName;
    private String leaderName;
}
