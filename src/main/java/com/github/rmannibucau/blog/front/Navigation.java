package com.github.rmannibucau.blog.front;

import com.github.rmannibucau.blog.front.security.LoggedInUserVoter;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.security.api.authorization.annotation.Secured;

@View(basePath = "/", extension = "xhtml", navigation = View.NavigationMode.REDIRECT)
public interface Navigation extends ViewConfig {
    @View
    class Index implements Navigation {}

    @View
    class Login implements Navigation {}

    @View(basePath = "/post/")
    interface PostsNavigation extends Navigation {}

    @View(name = "create-post")
    @Secured(LoggedInUserVoter.class)
    class CreatePost implements PostsNavigation {}

    @View
    class Post implements PostsNavigation {}
}
