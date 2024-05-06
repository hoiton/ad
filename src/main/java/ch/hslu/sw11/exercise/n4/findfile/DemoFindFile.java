/*
 * Copyright 2024 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw11.exercise.n4.findfile;

import java.io.File;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LoggerFactory.getLogger(ch.hslu.sw11.exercise.n4.findfile.DemoFindFile.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "find.me";
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info("Start searching '{}' recurive in '{}'", search, rootDir);
        var start = System.nanoTime();
        FindFile.findFile(search, rootDir);
        var elapsed = System.nanoTime() - start;
        var ms = elapsed / 1_000_000_000.0;
        LOG.info("Found in {} msec.", ms);

        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        start = System.nanoTime();
        final FindFileTask root = new FindFileTask(search, rootDir);
        LOG.info(root.invoke());
        elapsed = System.nanoTime() - start;
        ms = elapsed / 1_000_000_000.0;
        LOG.info("Found in {} msec.", ms);
    }
}
