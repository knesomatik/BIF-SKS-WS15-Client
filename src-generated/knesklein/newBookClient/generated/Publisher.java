
package knesklein.newBookClient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publisher complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="publisher">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="pubName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pubAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pubTelNum" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisher")
public class Publisher {

    @XmlAttribute(name = "pubName")
    protected String pubName;
    @XmlAttribute(name = "pubAddress")
    protected String pubAddress;
    @XmlAttribute(name = "pubTelNum")
    protected Long pubTelNum;

    /**
     * Gets the value of the pubName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubName() {
        return pubName;
    }

    /**
     * Sets the value of the pubName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubName(String value) {
        this.pubName = value;
    }

    /**
     * Gets the value of the pubAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubAddress() {
        return pubAddress;
    }

    /**
     * Sets the value of the pubAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubAddress(String value) {
        this.pubAddress = value;
    }

    /**
     * Gets the value of the pubTelNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPubTelNum() {
        return pubTelNum;
    }

    /**
     * Sets the value of the pubTelNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPubTelNum(Long value) {
        this.pubTelNum = value;
    }

}
