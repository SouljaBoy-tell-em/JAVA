package com.example.application.views;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route("empty")
@AnonymousAllowed
public class EmptyView extends Div {

    public EmptyView() {
        setSizeFull();

        VerticalLayout layout = new VerticalLayout();
        layout.addClassNames("layout1");
        MessageInput messageInput = new MessageInput();
//        messageInput.setWidthFull();
        Icon icon2 = VaadinIcon.CHART_3D.create();
        layout.add(icon2);
        layout.setAlignSelf(FlexComponent.Alignment.END, icon2);
        messageInput.addClassNames("messageinput");
        layout.add(messageInput);
        layout.setAlignSelf(FlexComponent.Alignment.END, messageInput);
        add(layout);

    }
}
