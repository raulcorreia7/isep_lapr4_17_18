/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Car
 */
@RemoteServiceRelativePath("exportToXMLFormatServices")
public interface ExportToXMLFormatService extends  RemoteService{
    
    String exportWorkbook(String[][][] workbook, String filename); 
    
}
