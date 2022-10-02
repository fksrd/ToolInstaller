package com.fksrd;

import com.fksrd.library.*;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;

public class MainPageController {

    @FXML
    public ListView<String> listView;

    ApplicationData applicationData;

    @FXML
    public void initialize() {

        String json = FileGet.getData("https://gist.githubusercontent.com/fksrd/ba95cebfda52cfb49bc587c13397732e/raw/e0526ab6808f789c04983ab4dffea79a74539a13/data.json");

        JSONObject jsonObject = new JSONObject(json);

        JsonObjectToApplicationDataList jsonObjectToApplicationDataList = new JsonObjectToApplicationDataList(jsonObject);

        ApplicationList list = jsonObjectToApplicationDataList.applicationList;

        applicationData = list.ApplicationData.get(0);

        listView.getItems().add(applicationData.ApplicationName);
    }

    @FXML
    public void InstallButtonClicked() {

        ApplicationDownload applicationDownload = new ApplicationDownload(applicationData);

    }

}
