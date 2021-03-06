//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.19 at 12:38:15 PM IST 
//


package com.cg.openbanking.payment.domesticPaymentAPI.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partyinfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partyinfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PartyType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Mobile" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="addressinfo" type="{http://www.example.org/party}addressinfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partyinfo", propOrder = {
    "partyType",
    "name",
    "emailAddress",
    "phone",
    "mobile",
    "addressinfo"
})
public class Partyinfo {

    @XmlElement(name = "PartyType", required = true)
    protected String partyType;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "EmailAddress", required = true)
    protected String emailAddress;
    @XmlElement(name = "Phone")
    protected long phone;
    @XmlElement(name = "Mobile")
    protected long mobile;
    @XmlElement(required = true)
    protected Addressinfo addressinfo;

    /**
     * Gets the value of the partyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyType() {
        return partyType;
    }

    /**
     * Sets the value of the partyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyType(String value) {
        this.partyType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     */
    public long getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     */
    public void setPhone(long value) {
        this.phone = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     */
    public long getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     */
    public void setMobile(long value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the addressinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Addressinfo }
     *     
     */
    public Addressinfo getAddressinfo() {
        return addressinfo;
    }

    /**
     * Sets the value of the addressinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Addressinfo }
     *     
     */
    public void setAddressinfo(Addressinfo value) {
        this.addressinfo = value;
    }

}
