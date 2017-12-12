/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttestsystem;

import org.w3c.dom.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author User
 */
public class ProjectTestSystem {
    public static void main(String[] args) {
        Storage.init();
        XMLRW myrw = new XMLRW();
        myrw.myRead("testfile.xml");
        //Storage.printUsers();
        //Storage.printAnswers();
        Adding.run();
        
        myrw.myWrite("testfile.xml");
    
    
    
    System.out.println("Hello, World!");
    }
}
