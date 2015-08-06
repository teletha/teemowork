
/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;

import bee.api.Command;
import bee.api.Task;
import kiss.I;

/**
 * @version 2015/08/06 20:35:56
 */
public class Site extends Task {

    @Command("Upload application to the Github Pages.")
    public void upload() throws Exception {
        Path gitDirectory = I.locate(".git").toAbsolutePath();
        System.out.println(gitDirectory.toAbsolutePath());

        if (Files.notExists(gitDirectory)) {
            throw new Error(".git directory is not found.");
        }

        Repository repository = new RepositoryBuilder().readEnvironment().findGitDir(gitDirectory.toFile()).build();

        try (Git git = new Git(repository)) {
            AddCommand add = git.add();
            add.addFilepattern("index.html");
            add.addFilepattern("application.js");
            add.addFilepattern("apllication.css");
            add.call();

            git.commit().setMessage("Update application.").call();
        }
    }
}
