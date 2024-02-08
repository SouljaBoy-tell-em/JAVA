import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.*;

public class XPathCallerImpl implements XPathCaller{

    private final String EMP = "content/emp/employee";

    @Override
    public Element[] getEmployees(Document src, String deptno, String docType) {

        try {
            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "";
            if(docType.equals("emp"))
                expression = "content/emp/employee[@deptno='" + deptno + "']";
            else
                expression = "//employee[@deptno='" + deptno + "']";
            NodeList nodeList = (NodeList) xPath.evaluate(expression, src, XPathConstants.NODESET);
            Element[] elements = new Element[nodeList.getLength()];
            for(int i = 0; i < nodeList.getLength(); i++)
                elements[i] = (Element) nodeList.item(i);

            return elements;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String getHighestPayed(Document src, String docType) {

        try {
            XPath xPath = XPathFactory.newInstance().newXPath();

            String expressionPrice = "";
            String expressionName  = "";
            if(docType.equals("emp")) {
                expressionName  = "content/emp/employee/ename/text()";
                expressionPrice = "content/emp/employee/sal/text()";
            }
            else {
                expressionName  = "//employee/ename/text()";
                expressionPrice = "//employee/sal/text()";
            }

            NodeList nameNodes  = (NodeList)  xPath.evaluate(expressionName,
                                               src, XPathConstants.NODESET);
            NodeList priceNodes = (NodeList) xPath.evaluate(expressionPrice,
                                               src, XPathConstants.NODESET);
            double max = Double.MIN_VALUE + 1;
            String name = null;
            for(int i = 0; i < priceNodes.getLength(); i++) {
                if(Double.parseDouble(priceNodes.item(i).getTextContent()) > max) {
                    max = Double.parseDouble(priceNodes.item(i).getTextContent());
                    name = nameNodes.item(i).getTextContent();
                }
            }

            return name;
        } catch (Exception e) {

        }
       return null;
    }

    @Override
    public String getHighestPayed(Document src, String deptno, String docType) {

        try {
            XPath xPath = XPathFactory.newInstance().newXPath();

            String expressionPrice = "";
            String expressionName  = "";
            if(docType.equals("emp")) {
                expressionName  = "content/emp/employee[@deptno='" + deptno + "']/ename/text()";
                expressionPrice = "content/emp/employee[@deptno='" + deptno + "']/sal/text()";
            }
            else {
                expressionName  = "//employee[@deptno='" + deptno + "']/ename/text()";
                expressionPrice = "//employee[@deptno='" + deptno + "']/sal/text()";
            }

            NodeList nameNodes  = (NodeList)  xPath.evaluate(expressionName,
                    src, XPathConstants.NODESET);
            NodeList priceNodes = (NodeList) xPath.evaluate(expressionPrice,
                    src, XPathConstants.NODESET);
            double max = Double.MIN_VALUE + 1;
            String name = null;
            for(int i = 0; i < priceNodes.getLength(); i++) {
                if(Double.parseDouble(priceNodes.item(i).getTextContent()) > max) {
                    max = Double.parseDouble(priceNodes.item(i).getTextContent());
                    name = nameNodes.item(i).getTextContent();
                }
            }

            return name;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Element[] getTopManagement(Document src, String docType) {

        try {

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = null;

            if(docType.equals("emp")) {
                expression  = "content/emp/employee[not(@mgr)]";
            }
            else {
                expression  = "//employee[not(../sal)]";
            }

            NodeList list = (NodeList) xPath.evaluate(expression, src, XPathConstants.NODESET);
            Element[] elements = new Element[list.getLength()];
            System.out.println(elements.length);
            for(int i = 0; i < list.getLength(); i++)
                elements[i] = (Element) list.item(i);
            return elements;
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Element[] getOrdinaryEmployees(Document src, String docType) {

        try {

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = null;

            if(docType.equals("emp")) {
                expression  = "//employee[not(@empno = ../employee/@mgr)]";
            }
            else {
                expression  = "//employee[not(./employee)]";
            }

            NodeList list = (NodeList) xPath.evaluate(expression, src, XPathConstants.NODESET);
            Element[] elements = new Element[list.getLength()];
            for(int i = 0; i < list.getLength(); i++)
                elements[i] = (Element) list.item(i);
            return elements;
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Element[] getCoworkers(Document src, String empno, String docType) {

        try {

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = null;

            if(docType.equals("emp")) {
                expression  = "//employee[@mgr = ../employee[@empno=" + empno + "]/@mgr and @empno !=" + empno + "]";
            }
            else {
                expression  = "//employee[../employee/@empno=" + empno + " and @empno !=" + empno + "]";
            }

            NodeList list = (NodeList) xPath.evaluate(expression, src, XPathConstants.NODESET);
            Element[] elements = new Element[list.getLength()];
            for(int i = 0; i < list.getLength(); i++) {
                elements[i] = (Element) list.item(i);
            }
            return elements;
        } catch (Exception e) {}

        return null;
    }
}
