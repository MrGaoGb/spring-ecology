package com.mrgao.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "o")
public class Ordinary implements Serializable {

    @XmlElement
    private BigDecimal amt;
    @XmlElement
    private BigDecimal rate;
}
