package com.fksrd.library;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonObjectToApplicationDataList {

    public ApplicationList applicationList;

    public JsonObjectToApplicationDataList(JSONObject jsonObject) {

        applicationList = new ApplicationList();

        for (int i = 0; i < jsonObject.length(); i++) {

            JSONObject applicationDataJson = jsonObject.getJSONObject(String.valueOf(i));

            ApplicationData applicationData = new ApplicationData();

            applicationData.ApplicationName = applicationDataJson.getString("name");

            try {

                applicationData.ApplicationIconUrl = new URL(applicationDataJson.getString("icon"));
                applicationData.ApplicationLicense = new URL(applicationDataJson.getString("license"));
                applicationData.ApplicationWebPage = new URL(applicationDataJson.getString("webPage"));
                applicationData.ApplicationGitHubPage = new URL(applicationDataJson.getString("githubPage"));

                JSONObject applicationReleaseDataJson = applicationDataJson.getJSONObject("release");

                ApplicationReleaseList applicationReleaseList = new ApplicationReleaseList();
                applicationList.ApplicationData = new ArrayList<ApplicationData>();
                applicationReleaseList.ApplicationOs = new ArrayList<ApplicationReleaseOS>();
                applicationData.applicationReleaseList = new ApplicationReleaseList();
                applicationData.applicationReleaseList.ApplicationOs = new ArrayList<ApplicationReleaseOS>();

                for (int j = 0; j < applicationReleaseDataJson.length(); j++) {

                    JSONObject applicationReleaseOSDataJson = applicationReleaseDataJson.getJSONObject(String.valueOf(j));

                    try {
                        JSONObject applicationReleaseWindowsOSJson = applicationReleaseOSDataJson.getJSONObject("windows");

                        if (!applicationReleaseWindowsOSJson.isEmpty()) {

                            ApplicationReleaseOS applicationReleaseOS = new ApplicationReleaseOS();
                            applicationReleaseOS.ApplicationOSName = "windows";
                            applicationReleaseOS.ApplicationSetupType = applicationReleaseWindowsOSJson.getString("type");
                            applicationReleaseOS.ApplicationSetupVersion = applicationReleaseWindowsOSJson.getString("version");
                            applicationReleaseOS.ApplicationSetupUrl = new URL(applicationReleaseWindowsOSJson.getString("url"));

                            applicationData.applicationReleaseList.ApplicationOs.add(applicationReleaseOS);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    try {
                        JSONObject applicationReleaseMacOSOSJson = applicationReleaseOSDataJson.getJSONObject("linux");

                        if (!applicationReleaseMacOSOSJson.isEmpty()) {

                            ApplicationReleaseOS applicationReleaseOS = new ApplicationReleaseOS();
                            applicationReleaseOS.ApplicationOSName = "linux";
                            applicationReleaseOS.ApplicationSetupType = applicationReleaseMacOSOSJson.getString("type");
                            applicationReleaseOS.ApplicationSetupVersion = applicationReleaseMacOSOSJson.getString("version");
                            applicationReleaseOS.ApplicationSetupUrl = new URL(applicationReleaseMacOSOSJson.getString("url"));

                            applicationData.applicationReleaseList.ApplicationOs.add(applicationReleaseOS);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    try {
                        JSONObject applicationReleaseLinuxOSJson = applicationReleaseOSDataJson.getJSONObject("macos");

                        if (!applicationReleaseLinuxOSJson.isEmpty()) {

                            ApplicationReleaseOS applicationReleaseOS = new ApplicationReleaseOS();
                            applicationReleaseOS.ApplicationOSName = "macos";
                            applicationReleaseOS.ApplicationSetupType = applicationReleaseLinuxOSJson.getString("type");
                            applicationReleaseOS.ApplicationSetupVersion = applicationReleaseLinuxOSJson.getString("version");
                            applicationReleaseOS.ApplicationSetupUrl = new URL(applicationReleaseLinuxOSJson.getString("url"));

                            applicationData.applicationReleaseList.ApplicationOs.add(applicationReleaseOS);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }


                    applicationList.ApplicationData.add(applicationData);

                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }



        }

    }
    
}
