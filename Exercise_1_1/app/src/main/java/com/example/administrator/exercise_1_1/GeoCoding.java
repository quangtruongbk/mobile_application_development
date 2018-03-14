package com.example.administrator.exercise_1_1;

import android.util.Log;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 * Created by Administrator on 3/6/2018.
 */

public class GeoCoding {
    GeoCoding(){}
    public String getAddress(String latlong) {
        String address = null;
        String gURL = "https://maps.googleapis.com/maps/api/geocode/xml?latlng="+latlong+"&key=AIzaSyDR6Zd0hKBRS8ncWQ93HGn3HjmP8-Fr9Zo";
        Log.d("abc", "getAddress1: ");
        try {
            Log.d("abc", "getAddress: ");
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Document dom = db.parse(gURL);
            Element docEl = dom.getDocumentElement();
            NodeList nl = docEl.getElementsByTagName("result");
            if (nl != null && nl.getLength() > 0) {
                address = ((Element) nl.item(0)).getElementsByTagName("formatted_address").item(0).getTextContent();
                for (int i = 0; i < nl.getLength(); i++) {
                }
            }
        } catch (Exception ex) {
            Log.d("abc", ex.toString());
            address = "Error Occurs, please try again!!!";
        }
        return address;
    }

    public String getAddress(String lat, String lon) {
        return getAddress(lat + "," + lon);
    }

    public String getAddress(double lat, double lon) {
        return getAddress("" + lat, "" + lon);
    }
}
