package ch.viascom.groundwork.serviceresult.exception;

import ch.viascom.groundwork.serviceresult.util.NameValuePair;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a wrapped exception including some extra data.
 */
@Data
@NoArgsConstructor
public class ServiceFault implements Serializable {

    protected String code;
    protected String message;
    protected String requestUrl;
    protected String requestedType;

    protected int responseCode = 500;
    protected List<NameValuePair> requestParams;
    protected String exception;

    /**
     * Constructor.
     *
     * @param serviceFaultCode    Technical error code.
     * @param serviceFaultMessage Display error message.
     */
    public ServiceFault(String serviceFaultCode, String serviceFaultMessage) {
        code = serviceFaultCode;
        message = serviceFaultMessage;
    }

    public void setRequestedType(Class requestedType){
        this.requestedType = requestedType.getCanonicalName();
    }

    public void setRequestedType(String requestedType){
        this.requestedType = requestedType;
    }

    /**
     * Adds a name-value pair to the request parameter list.
     *
     * @return The fault which is used.
     */
    public ServiceFault addRequestParam(String key, String value) {
        if (requestParams == null)
            requestParams = new ArrayList<>();

        requestParams.add(new NameValuePair(key, value));

        return this;
    }
}
