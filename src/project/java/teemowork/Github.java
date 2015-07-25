/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 * @version 2015/07/25 16:22:53
 */
public class Github {

    /** The service. */
    private final RepositoryService service = new RepositoryService();

    /** The teemowork repository. */
    private final Repository repository;

    /** The gh-pages branch. */
    private final RepositoryBranch pages;

    /**
     * @throws Exception
     */
    private Github() throws Exception {
        repository = service.getRepository("Teletha", "Teemowork");
        pages = searchGithubPages();
    }

    /**
     * <p>
     * Search gh-pages branch.
     * </p>
     * 
     * @return
     * @throws Exception
     */
    private RepositoryBranch searchGithubPages() throws Exception {
        List<RepositoryBranch> branches = service.getBranches(repository);

        for (RepositoryBranch branch : branches) {
            if (branch.getName().equals("gh-pages")) {
                return branch;
            }
        }

        // create new branch
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Github github = new Github();
    }
}
