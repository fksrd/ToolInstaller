module com.fksrd {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.commons.codec;
    requires org.json;

    opens com.fksrd to javafx.fxml;
    exports com.fksrd;
}
