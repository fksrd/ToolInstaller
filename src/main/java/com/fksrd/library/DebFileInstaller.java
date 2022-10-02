package com.fksrd.library;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class DebFileInstaller {

    public static void Installer(String file) throws IOException {

        CommandLine commandLine = new CommandLine("sudo dpkg -i" + file);

        DefaultExecutor defaultExecutor = new DefaultExecutor();

        defaultExecutor.setExitValue(0);

        try {
            defaultExecutor.execute(commandLine);
        }
        catch (ExecuteException e) {

            System.err.println("Execution failed.");
            e.printStackTrace();

        } catch (IOException e) {

            System.err.println("permission denied.");
            e.printStackTrace();

        }

    }

}
