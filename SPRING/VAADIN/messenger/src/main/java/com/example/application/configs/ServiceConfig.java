package com.example.application.configs;


public class ServiceConfig {

    // CONSTS:
    public long DURATION_100_MS = 100;

    // CSS_TAGS:
    public String CSS_LOGO_IMAGE = "logo_image";
    public String CSS_MESSAGE_INPUT = "message_input";
    public String CSS_MESSAGE_INPUT_LAYOUT = "message_input_layout";
    public String CSS_MESSAGE_LIST = "message_list";
    public String CSS_MESSAGE_LIST_LAYER = "message_list_layer";
    public String CSS_MESSAGE_LIST_SCROLLER = "message_list_scroller";
    public String CSS_PAGE_TABS = "page_tabs";
    public String CSS_SCROLL_TO_BOTTOM_ICON =  "scroll_to_bottom_icon";

    // LINKS:
    public String LOGO_LINK = "https://firebasestorage.googleapis.com/v0/b/spring-base-238608.appspot.com/o/logo.png?alt=media&token=427f1442-8caf-481c-9e5a-4df319d9d0fb";

    // JS INJECTION:
    public String ScrollToBottomJS() {
        return """
                var el = this;
                el.scrollTo(0, el.scrollHeight);
                """;
    }

    public String GetHeightLayoutJS() {
        return """
                return $0.clientHeight;
                """;
    }

    public String GetHeightDifferenceScrollerJS() {
        return """
                return $0.scrollTop + $0.clientHeight - $0.scrollHeight;
                """;
    }
}
