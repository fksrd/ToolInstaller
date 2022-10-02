package com.fksrd;

import com.fksrd.library.*;
import javafx.scene.control.ListView;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainPageController {

    @FXML
    public ListView<String> listView;

    ApplicationList applicationList;

    @FXML
    public void initialize() throws IOException {

        applicationList = ReadCache.ReadCache();

        reloadListView();

    }

    public void reloadListView() {

        for (int i = 0; i < applicationList.ApplicationData.size(); i++) {

            listView.getItems().add(applicationList.ApplicationData.get(i).ApplicationName);

        }

    }

    @FXML
    public void InstallButtonClicked() throws IOException {

        if (applicationList != null) {

            ApplicationDownload applicationDownload = new ApplicationDownload(applicationList);

            DebFileInstaller.Installer("JD-GUI.deb");

        }
    }

}
