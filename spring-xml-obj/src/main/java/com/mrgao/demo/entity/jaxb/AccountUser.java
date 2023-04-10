package com.mrgao.demo.entity.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * @author Mr.Gao
 * @date 2023/3/21 17:22
 * @apiNote:
 */
@Data
@XmlRootElement(name = "xml")
public class AccountUser extends User {
    /**
     * 账户uuid
     */
    @XmlElement(name = "account_uuid")
    private UUID accountUUid;

}
