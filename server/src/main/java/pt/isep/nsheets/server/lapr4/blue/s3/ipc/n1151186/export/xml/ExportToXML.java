/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1151186.export.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1151708.export.csv.NewExportStrategy;
import pt.isep.nsheets.shared.core.Spreadsheet;

/**
 *
 * @author Car
 */
public class ExportToXML implements NewExportStrategy {

    String tag1 = "workbook";
    String tag2 = "SpreadSheet";
    String tag3 = "Cells";
    String tag4 = "Content";
    String tag5 = "Row";
    String tag6 = "Column";

    public boolean changetag1(String tag1) {
        if (tag1.length() != 1) {
            return false;
        } else {
            this.tag1 = tag1;
            return true;
        }
    }

    public boolean changetag2(String tag2) {
        if (tag2.length() != 1) {
            return false;
        } else {
            this.tag2 = tag2;
            return true;
        }
    }

    public boolean changetag3(String tag3) {
        if (tag3.length() != 1) {
            return false;
        } else {
            this.tag3 = tag3;
            return true;
        }
    }

    public boolean changetag4(String tag4) {
        if (tag4.length() != 1) {
            return false;
        } else {
            this.tag4 = tag4;
            return true;
        }
    }

    public boolean changetag5(String tag5) {
        if (tag5.length() != 1) {
            return false;
        } else {
            this.tag5 = tag5;
            return true;
        }
    }

    public boolean changetag6(String tag6) {
        if (tag6.length() != 1) {
            return false;
        } else {
            this.tag6 = tag6;
            return true;
        }
    }

    public String getInicialTag(String tag1) {
        return "<" + tag1 + ">";
    }

    public String getFinalTag(String tag1) {
        return "</" + tag1 + ">";

    }

    @Override
    public String exportWorkbook(String[][][] workbook, String filename) {
        PrintWriter pw = null;
        try {
            if (filename.isEmpty()) {
                return "Error";
            }
            StringBuilder a = new StringBuilder();
            Spreadsheet s;
            pw = new PrintWriter(new File("server/export/" + filename + ".xml"));
            a.append("< ? xml  version = " + "1.0" + " encoding = " + "UTF-8" + " ?>");
            a.append("\n");
            a.append("\n");
            a.append(getInicialTag(tag1));
            for (int i = 0; i < workbook.length; i++) {

                a.append(tag2);
                for (int j = 0; j < workbook[i].length; j++) {
                    for (int k = 0; k < workbook[i][j].length; k++) {

                        a.append(tag3);
                        a.append(tag4 + workbook[i][j][k] + tag4);
                        a.append(tag6+ j + tag6);
                        a.append(tag5 + k + tag5);
                        a.append(tag3);

                    }
                }
                a.append(tag2);
            }
            pw.write(a.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportToXML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }

        return filename + ".xml";
    }

}
