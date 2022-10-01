package com.fksrd;

import org.json.JSONObject;

import com.fksrd.library.FileGet;

import javafx.fxml.FXML;

public class MainPageController {

    @FXML
    public void initialize() {

        String json = FileGet.getJsonData("https://gist.githubusercontent.com/fksrd/ba95cebfda52cfb49bc587c13397732e/raw/e0526ab6808f789c04983ab4dffea79a74539a13/data.json");

        JSONObject jsonObject = new JSONObject(json);

        

        
    }

}
