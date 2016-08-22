package app.feicui.edu.login.yz.server;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
public class SqServer {
    private final static String NAME_SPACE = "http://yourcompany.com/";
    //private final static String METHOD_NAME="insert";
    private final static String WSDL_URL = "http://192.168.1.163:8080/tset/UserPort?wsdl";

    public String bserver(String name, String passworld, String METHOD_NAME) {
        //1. 指定WebService的命名空间和调用的方法名
        SoapObject soapObject = new SoapObject(NAME_SPACE, METHOD_NAME);
        //2. 设置调用方法的参数值，这一步是可选的，如果方法没有参数，可以省略这一步
        soapObject.addProperty("arg0", name);
        soapObject.addProperty("arg1", passworld);
        //3. 生成调用WebService方法的SOAP请求信息。该信息由SoapSeriali zationEnvelope对象描述
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        envelope.bodyOut = soapObject;
        //4. 创建HttpTransportSE对象。通过HttpTransportSE类的构造方法可以指定WebService的WSDL文档的URL
        HttpTransportSE ht = new HttpTransportSE(WSDL_URL);
        ht.debug = true;
        envelope.dotNet = false;//可以使用节点信息
        //5. 使用call方法调用WebService方法
        try {
            List headerList = ht.call(NAME_SPACE + METHOD_NAME, envelope, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        //6. 使用getResponse方法获得WebService方法的返回结果
        Object result = null;
        try {
            result = (Object) envelope.getResponse();
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        }
        String k = result.toString();
        return k;
    }


}
