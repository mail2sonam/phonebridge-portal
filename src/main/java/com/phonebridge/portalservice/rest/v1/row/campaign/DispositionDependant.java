/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.rest.v1.row.campaign;

import java.util.Date;

import lombok.Data;

@Data
public class DispositionDependant{
	private String dependantID;
    private String fieldValue;
    private String fieldLabel;
    private String fieldType;
    private String dropDownValue;
    private Date dateValue;
    private boolean conversionDependant; 
}
