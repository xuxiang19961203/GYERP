package com.shudi.pojo.deliverys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Xux
 * @version V1.0
 * @Project: GyERP
 * @Package com.shudi.pojo.deliverys
 * @date Date : 2021年04月11日 22:37
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GYDeliverysVO {
    private boolean success;
    private String errorCode;
    private String subErrorCode;
    private String errorDesc;
    private String subErrorDesc;
    private String requestMethod;
    private List<GYDeliverys> deliverys;
    private int total;
}
