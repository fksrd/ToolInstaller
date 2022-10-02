package com.fksrd.library;

public class ApplicationDownload {

    public ApplicationDownload(ApplicationList applicationList) {

        if (applicationList != null) {

            for (int i = 0; i < applicationList.ApplicationData.size(); i++) {

                ApplicationData applicationData = applicationList.ApplicationData.get(i);

                for (int j = 0; j < applicationData.applicationReleaseList.ApplicationOs.size(); j++) {

                    ApplicationReleaseOS applicationReleaseOS = applicationData.applicationReleaseList.ApplicationOs.get(j);

                    if (applicationReleaseOS.ApplicationOSName.startsWith(System.getProperty("os.name").toLowerCase())) {

                        FileGet.fileSave(applicationReleaseOS.ApplicationSetupUrl.toString(), applicationData.ApplicationName);

                    }

                }

            }

        }

    }

}
