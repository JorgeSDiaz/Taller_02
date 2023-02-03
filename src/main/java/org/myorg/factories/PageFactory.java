package org.myorg.factories;

import org.myorg.pages.FormPage;
import org.myorg.pages.Page;
import org.myorg.pages.SimplePage;

/**
 * Allows to generate pages according to the query in route
 */
public class PageFactory {
    public Page Page(String file) {
        if (file.equals("simple")) { return new SimplePage(); }
        return new FormPage();
    }
}
