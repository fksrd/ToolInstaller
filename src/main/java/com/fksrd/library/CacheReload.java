package com.fksrd.library;

import java.io.FileWriter;
import java.io.IOException;

public class CacheReload {

    public static void CacheReload() throws IOException {

        String json = FileGet.getData("https://gist.githubusercontent.com/fksrd/ba95cebfda52cfb49bc587c13397732e/raw/27e9b181a075ac32cb9b6fd47194797ff39a0ee3/data.json");

        FileWriter fileWriter = new FileWriter("data.json");

        fileWriter.write(json);

        fileWriter.close();

    }

}
