package com.fksrd.library;

public class ApplicationDownload {

    public ApplicationDownload(ApplicationData applicationData) {

        ApplicationReleaseList applicationReleaseList = applicationData.applicationReleaseList;

        ApplicationReleaseOS applicationReleaseOS = applicationReleaseList.ApplicationOs.get(0);

        FileGet.fileSave(applicationReleaseOS.ApplicationSetupUrl.toString(), applicationData.ApplicationName);


    }

}
