package com.mrgao.demo.entity.jacksonxml;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author Mr.Gao
 * @date 2023/4/10 9:59
 * @apiNote:
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class AgentInfo {
    @JacksonXmlProperty(localName = "user_no")
    private String userNo;
    @JacksonXmlProperty(localName = "user_name")
    private String userName;
    @JacksonXmlProperty(localName = "user_pwd")
    private String userPwd;
}
