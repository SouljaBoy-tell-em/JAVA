import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class SimpleXMLImpl implements SimpleXML{
    @Override
    public String createXML(String tagName, String textNode) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement(tagName);
            root.appendChild(document.createTextNode(textNode));
            document.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(source, result);
            return writer.toString();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public String parseRootElement(InputStream xmlStream) throws SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            RootElementHandler handler = new RootElementHandler();
            parser.parse(xmlStream, handler);

            return handler.getRootElement();
        } catch (ParserConfigurationException e) {
            throw new SAXException("Error configuring SAX parser", e);
        } catch (Exception e) {
            throw new SAXException("Error parsing XML", e);
        }
    }

    private static class RootElementHandler extends DefaultHandler {
        private String rootElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (rootElement == null) {
                rootElement = qName;
            }
        }

        public String getRootElement() {
            return rootElement;
        }

    }
}
