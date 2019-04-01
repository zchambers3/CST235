
package business.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "getOrdersResponse", namespace = "http://business/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrdersResponse", namespace = "http://business/")

public class GetOrdersResponse {

    @XmlElement(name = "return")
    private java.util.List<beans.Order> _return;

    public java.util.List<beans.Order> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.List<beans.Order> new_return)  {
        this._return = new_return;
    }

}

