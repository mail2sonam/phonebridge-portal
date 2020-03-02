/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.row.campaign;

import java.util.List;

import com.phonebridge.portalservice.row.BasePojo;

import lombok.Data;

@Data
public class Disposition extends BasePojo{
    private String dispositionID;
    private EnumDispositionDataType fieldDataType;
    private List<String> dropDownValues;
    private String fieldLabel;
    private String callWorkFlow;
    private List<Disposition> dependantDisp;
    private boolean sendSMS;
    private String smsText;
    private boolean conversion;
}
