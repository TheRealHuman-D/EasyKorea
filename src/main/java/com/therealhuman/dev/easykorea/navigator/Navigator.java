package com.therealhuman.dev.easykorea.navigator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Navigator to view in application.
 *
 * <p>
 * Singleton class managemnt current pane in scene of {@link Scene} class
 * <p>
 * Get instance of classs by static method Navigator.get()
 * 
 * @author Buffalo@200x
 * @since 1.0
 **/
public final class Navigator {
    private static final Navigator INSTANCE = new Navigator();

    public static Navigator get() {
        return INSTANCE;
    }

    private final Deque<View> backStack = new ArrayDeque<>();
    private final Map<View, Parent> cache = new EnumMap<>(View.class);
    private Consumer<Parent> host;

    private Navigator() {}

    /**
     * Switch root node
     *
     * <p>
     * Switch root node of {@link Scene}
     * 
     * @param scene
     */
    public void switchTo(Scene scene) {
        Objects.requireNonNull(scene);
        this.host = root -> scene.setRoot(root);
    }


    /**
     * Switch children node
     *
     * <p>
     * Switch chilrent node of {@link Pane}
     * 
     * @param container
     */
    public void switchTo(Pane container) {
        Objects.requireNonNull(container);
        this.host = root -> container.getChildren().setAll(root);
    }

    public void navigate(View view) {
        checkReady();
        Parent root = openView(view);
        backStack.push(view);
        showView(root);
    }

    public void goBack() {
        if (!canGoBack()) {
            return;
        }
        Parent root = openView(backStack.pop());
        showView(root);
    }

    private boolean canGoBack() {
        return !backStack.isEmpty();
    }

    private void showView(Parent root) {
        host.accept(root);
    }

    private Parent openView(View view) {
        Parent cached = view.cachealbe() ? cache.get(view) : null;
        if (cache.get(view) != null) {
            return cached;
        }
        cached = loadView(view);
        if (view.cachealbe()) {
            cache.put(view, cached);
        }
        return cached;
    }

    /**
     * Load View
     * 
     * @param view {@link View}
     * @return {@link Parent}
     */
    private Parent loadView(View view) {
        URL url = Navigator.class.getResource(view.viewPath());
        if (url == null) {
            throw new IllegalArgumentException("View path not found.");
        }
        FXMLLoader loader = new FXMLLoader(url);
        try {
            Parent root = loader.load();
            return root;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot load view.");
        }
    }

    private void checkReady() {
        if (host == null) {
            throw new IllegalArgumentException("Something field must be initialized.");
        }
        if (!Platform.isFxApplicationThread()) {
            throw new IllegalArgumentException(
                    "Method has invoke not in JavaFXApplication Thread.");
        }
    }

    public void reset(View view) {
        this.backStack.clear();
        this.backStack.push(view);
    }

}
