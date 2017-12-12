/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttestsystem;

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

public class XMLRW {
    public int myRead(String fileName){	 
		Document doc =  docInit(fileName);
 
		if (!doc.getDocumentElement().getNodeName().equals("Tables")){
			System.err.println("root must be <Tables>");
		}
		NodeList fLevelNodes = doc.getChildNodes();
		//System.err.println(fLevelNodes.item(0).getNodeName());
		NodeList nList = fLevelNodes.item(0).getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals("Users")){				
				//nList = nList.item(i).getChildNodes();
                                Storage.fillUsers(fillUsersList(nList.item(i).getChildNodes()));
			}
                        if (nList.item(i).getNodeName().equals("Answers")){				
                                Storage.fillAnswers(fillAnswersList(nList.item(i).getChildNodes()));
                    	}
                        if (nList.item(i).getNodeName().equals("Courses")){				
                                Storage.fillCourses(fillCoursesList(nList.item(i).getChildNodes()));
                    	}
                        if (nList.item(i).getNodeName().equals("Questions")){				
                                Storage.fillQuestions(fillQuestionsList(nList.item(i).getChildNodes()));
                    	}
                        if (nList.item(i).getNodeName().equals("Tests")){				
                                Storage.fillTests(fillTestsList(nList.item(i).getChildNodes()));
                    	}
                        if (nList.item(i).getNodeName().equals("UsersCourses")){				
                                Storage.fillUsersCourses(fillUsersCoursesList(nList.item(i).getChildNodes()));
                    	}
                        if (nList.item(i).getNodeName().equals("UsersTEstsResults")){				
                                Storage.fillUsersTestsResults(fillUsersTestsResultsList(nList.item(i).getChildNodes()));
                    	}
		}
		//Storage.fillUsers(fillUsersList(nList));		
                
                
            return 0; 
	}	
    
    public void myWrite(String fileName){
		 Document doc = null;       
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
	        try {
	            DocumentBuilder db = factory.newDocumentBuilder();
	            DOMImplementation domImplementation = db.getDOMImplementation();
	            doc = domImplementation.createDocument(null, "Tables", null);
	            
	            buildTree(doc, doc.getDocumentElement());
	            
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            
	            Properties transfProps = new Properties();
	            transfProps.put("method", "xml");
	            transfProps.put("indent", "yes");
	            transformer.setOutputProperties(transfProps);
	            
	            DOMSource source = new DOMSource(doc);
	            OutputStream out = new FileOutputStream(new File(fileName));
	            StreamResult result =  new StreamResult(out);
	            //StreamResult result =  new StreamResult(System.out);
	            transformer.transform(source, result);
	            try {
	                out.close();
	            } catch (Exception ex) {}            
	        } catch (Exception ex) {
	            System.err.println("XML error\n"+ex.toString());
	        }		
	}	
	
	
    private Element createXmlObj(Document doc, String root, String[] args, String ... values){
		Element e = createElement(doc, root, null);
		for(int i = 0; i < args.length; i++){
			e.appendChild(createElement(doc, args[i], values[i]));
		}
		return e;
	}	
	
    private Element createElement(Document doc, String name, String textContent) {
		Element elem = doc.createElement(name);        
        if(textContent!=null)
            elem.setTextContent(textContent);
        return elem;
    } 
	
    private void buildTree(Document doc, Element root) {
        // setting up document
        doc.setXmlStandalone(true);
        doc.setStrictErrorChecking(true);
        doc.setXmlVersion("1.0");
        
        Element subRoot = createElement(doc, "Users", null);       
        Element e;
        
        for(Map.Entry<Long, User> i:  Storage.getUsers()){	
        	String[] args = {"userId", "firstName", "lastName",
        			"login", "password"};
        	e = createXmlObj(doc,"User", args, 
        			((Long)i.getValue().getUserId()).toString(),
        			i.getValue().getFirstName(),
        			i.getValue().getLastName(),
                                i.getValue().getLogin(),
                                i.getValue().getPassword());
        	subRoot.appendChild(e); 
		}	  
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Answers", null);   
        for(Map.Entry<Long, Answer> i: Storage.getAnswers()){
        	String[] args = {"answerId", "questionId", "answerText", "right", "points"};
        	e = createXmlObj(doc,"Answer", args,
        			((Long)i.getValue().getAnswerId()).toString(),
                                ((Long)i.getValue().getQuestionId()).toString(),
                                i.getValue().getAnswerText(),
                                ((Boolean)i.getValue().getRight()).toString(),
        			((Integer)i.getValue().getPoints()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Courses", null);   
        for(Map.Entry<Long, Course> i: Storage.getCourses()){
        	String[] args = {"courseId", "courseName"};
        	e = createXmlObj(doc,"Course", args,
        			((Long)i.getValue().getCourseId()).toString(),
                                i.getValue().getCourseName());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Questions", null);   
        for(Map.Entry<Long, Question> i: Storage.getQuestions()){
        	String[] args = {"questionId", "testId", "questionText"};
        	e = createXmlObj(doc,"Question", args,
        			((Long)i.getValue().getQuestionId()).toString(),
                                ((Long)i.getValue().getTestId()).toString(),
                                i.getValue().getQuestionText());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "Tests", null);   
        for(Map.Entry<Long, Test> i: Storage.getTests()){
        	String[] args = {"testId", "courseId"};
        	e = createXmlObj(doc,"Test", args,
        			((Long)i.getValue().getTestId()).toString(),
                                ((Long)i.getValue().getCourseId()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "UsersCourses", null);   
        for(Map.Entry<Long, UserCourse> i: Storage.getUsersCourses()){
        	String[] args = {"id", "userId", "courseId"};
        	e = createXmlObj(doc,"UserCourse", args,
        			((Long)i.getValue().getId()).toString(),
                                ((Long)i.getValue().getUserId()).toString(),
                                ((Long)i.getValue().getCourseId()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        subRoot = createElement(doc, "UsersTestsResults", null);   
        for(Map.Entry<Long, UserTestResult> i: Storage.getUsersTestsResults()){
        	String[] args = {"id", "userId", "testId", "points", "maxPoints"};
        	e = createXmlObj(doc,"UserCourse", args,
        			((Long)i.getValue().getId()).toString(),
                                ((Long)i.getValue().getUserId()).toString(),
                                ((Long)i.getValue().getTestId()).toString(),
                                ((Integer)i.getValue().getPoints()).toString(),
                                ((Integer)i.getValue().getMaxPoints()).toString());
        	subRoot.appendChild(e);
        } 
        root.appendChild(subRoot);
        
        
    } 	
	
	private Document docInit(String fileName){
		try{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch(Exception e){
			return null;
		}
		
	}
	
	private Map<Long, User> fillUsersList(NodeList nList){
		Map<Long, User> elementsMap = new HashMap<Long, User>();
		User e;
                String elementName = "User";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new User();
					Element eElement = (Element) nNode;		     			      		
					e.setUserId(getTagValue("userId", eElement));		      
					e.setFirstName(getTagValue("firstName", eElement));	
					e.setLastName(getTagValue("lastName", eElement));
                                        e.setLogin(getTagValue("login", eElement));
                                        e.setPassword(getTagValue("Password", eElement));
					elementsMap.put(e.getUserId(),e);
                                       if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getUserId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getUserId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, Answer> fillAnswersList(NodeList nList){
		Map<Long, Answer> elementsMap = new HashMap<Long, Answer>();
		Answer e;		
                String elementName = "Answer";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new Answer();
					Element eElement = (Element) nNode;		     			      		
					e.setAnswerId(getTagValue("answerId", eElement));
                                        e.setQuestionId(getTagValue("questionId", eElement));
					e.setAnswerText(getTagValue("answerText", eElement));	
					e.setRight(getTagValue("right", eElement));
                                        e.setPoints(getTagValue("points", eElement));
					elementsMap.put(e.getAnswerId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getAnswerId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getAnswerId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, Course> fillCoursesList(NodeList nList){
		Map<Long, Course> elementsMap = new HashMap<Long, Course>();
		Course e;		
                String elementName = "Course";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new Course();
					Element eElement = (Element) nNode;		     			      		
					e.setCourseId(getTagValue("courseId", eElement));
                                        e.setCourseName(getTagValue("courseName", eElement));
					elementsMap.put(e.getCourseId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getCourseId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getCourseId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, Question> fillQuestionsList(NodeList nList){
		Map<Long, Question> elementsMap = new HashMap<Long, Question>();
		Question e;		
                String elementName = "Question";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new Question();
					Element eElement = (Element) nNode;		     			      		
					e.setQuestionId(getTagValue("questionId", eElement));
                                        e.setTestId(getTagValue("testId", eElement));
					e.setQuestionText(getTagValue("questionText", eElement));
					elementsMap.put(e.getQuestionId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getQuestionId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getQuestionId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, Test> fillTestsList(NodeList nList){
		Map<Long, Test> elementsMap = new HashMap<Long, Test>();
		Test e;		
                String elementName = "Test";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new Test();
					Element eElement = (Element) nNode;		     			      		
					e.setTestId(getTagValue("testId", eElement));
                                        e.setCourseId(getTagValue("courseId", eElement));
					elementsMap.put(e.getTestId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getTestId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getTestId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, UserCourse> fillUsersCoursesList(NodeList nList){
		Map<Long, UserCourse> elementsMap = new HashMap<Long, UserCourse>();
		UserCourse e;		
                String elementName = "UserCourse";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new UserCourse();
					Element eElement = (Element) nNode;		     			      		
					e.setId(getTagValue("id", eElement));
                                        e.setUserId(getTagValue("userId", eElement));
                                        e.setCourseId(getTagValue("courseId", eElement));
					elementsMap.put(e.getId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
        private Map<Long, UserTestResult> fillUsersTestsResultsList(NodeList nList){
		Map<Long, UserTestResult> elementsMap = new HashMap<Long, UserTestResult>();
		UserTestResult e;		
                String elementName = "UserTestResult";
		for (int i = 0; i < nList.getLength(); i++) {
			//System.err.println(nList.item(i).getNodeName());
			if (nList.item(i).getNodeName().equals(elementName)){				
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					e = new UserTestResult();
					Element eElement = (Element) nNode;		     			      		
					e.setId(getTagValue("id", eElement));
                                        e.setUserId(getTagValue("userId", eElement));
                                        e.setTestId(getTagValue("testId", eElement));
                                        e.setPoints(getTagValue("points", eElement));
                                        e.setMaxPoints(getTagValue("maxPoints", eElement));
					elementsMap.put(e.getId(),e);
                                        if (!Storage.getMaxIds().containsKey(elementName)) {
                                            Storage.addMaxId(elementName, Long.MIN_VALUE);
                                        }
                                        if (e.getId() > Storage.getMaxIds().get(elementName)) {
                                            Storage.setMaxId(elementName, e.getId());
                                        }
				}				
			} 
	    }
		return elementsMap;
	}
        
	private static String getTagValue(String sTag, Element eElement) {
		try{
			NodeList nList = eElement.getChildNodes(); //.getElementsByTagName(sTag).item(0)			
			for (int i = 0; i < nList.getLength(); i++){ //Node n = nList.item(i);
				if (nList.item(i).getNodeName().equals(sTag)){
					return nList.item(i).getChildNodes().item(0).getNodeValue(); //.getTextContent();//
				}
			}	//Node nValue = (Node) nlList.item(0);
			return null; //return nValue.getNodeValue();
		}catch (Exception e){
			return null;
		}       
	}
}
