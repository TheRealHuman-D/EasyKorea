package com.therealhuman.dev.easykorea.navigator;

public enum View {
    DASHBOARD_VIEW("Dashboard", "dashboard-view.fxml", true, true),
    MAIN_SHELL_VIEW("Home", "main-view.fxml", true, true),
    MY_PROGRESS_VIEW("Progress", "progress-view.fxml", true, true),
    SETTINGS_VIEW("Setting", "setting-view.fxml", true, true),
    PRACTICE_VIEW("Practice", "test-center.fxml", true, true),
    READING_PRACTICE_VIEW("Reading", "reading-practice-view.fxml", true, true),
    WRITTING_PRACTICE_VIEW("Writting", "writting-practice-view.fxml", true, true),
    LISTENING_PRACTICE_VIEW("Listening", "listening-practice-view.fxml", true, true),
    SPEAKING_PRACTICE_VIEW("Speaking", "speaking-practice.fxml", true, true),
    TEST_CENTER_VIEW("Test Center", "test-center-view.fxml", true, true),
    MY_COURSE_VIEW_VIEW("My Course", "courses-view.fxml", true, true),
    GRAMMAR_REFERENCE_VIEW("Grammar Reference", "grammar-reference-view.fxml", true, true),
    IMPORT_EXPORT_VIEW("Import/Export", "import-export-view.fxml", true, true),
    FLASHCARD_FRONT_VIEW_VIEW("Flash Card", "flashcard-front-view.fxml", true, true),
    FLASHCARD_RELATED_VIEW_VIEW("Flash Card", "flashcard-related-view.fxml", true, true),
    TOPIK_LISTEN_VIEW("Topik Listening", "topik-listen-view.fxml", true, true),
    TOPIK_WRITING_VIEW("Topik Writing", "topik-writting-view.fxml", true, true),
    TOPIK_READING_VIEW("Topik Reading", "topik-reading-view.fxml", true, true),
    TOPIK_SPEAKING_VIEW("Topik Speaking", "topik-speaking-view.fxml", true, true),
    TEST_RESULT_VIEW("Test Result", "test-result.fxml", true, true),
    VOCAUBULARY_VIEW_VIEW("Vocabulary", "vocabulary.fxml", true, true);

    private static final String BASE = "/com/therealhuman/dev/easykorea/fxml/";
    private final String viewName;
    private final String viewPath;
    private final boolean cacheable;
    private final boolean isRoot;

    View(String viewName, String viewPath, boolean cacheable, boolean isRoot) {
        this.viewName = viewName;
        this.viewPath = viewPath;
        this.cacheable = cacheable;
        this.isRoot = isRoot;
    }

    public String viewName() {
        return this.viewName;
    }

    public String viewPath() {
        return BASE + this.viewPath;
    }

    public boolean cachealbe() {
        return this.cacheable;
    }

    public boolean isRoot() {
        return this.isRoot;
    }

}
