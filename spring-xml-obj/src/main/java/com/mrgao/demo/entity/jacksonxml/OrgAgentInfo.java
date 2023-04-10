package com.mrgao.demo.entity.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mr.Gao
 * @date 2023/4/10 10:38
 * @apiNote:
 */
@Getter
@Setter
@JacksonXmlRootElement(localName = "xml")
public class OrgAgentInfo extends AgentInfo {

    @JacksonXmlProperty(localName = "org_code")
    private String orgCode;
}
