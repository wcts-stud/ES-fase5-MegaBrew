package br.org.catolica.distribuidora.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class AdaptadorData extends XmlAdapter<XMLGregorianCalendar, Date> {
	
	// Marshal: apresenta ao cliente;
	@Override
	public XMLGregorianCalendar marshal(Date date) throws Exception {


		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = 
				DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		
		xmlGregorianCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
		xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		
		return xmlGregorianCalendar;
	}

	
	// UnMarshal: armazena no server;
	@Override
	public Date unmarshal(XMLGregorianCalendar v) throws Exception {
		
		Date date = v.toGregorianCalendar().getTime();
		
		// TODO Auto-generated method stub
		return date;
	}	
	
}
