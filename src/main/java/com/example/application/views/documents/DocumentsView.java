package com.example.application.views.documents;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.component.html.H4;

@PageTitle("Documents")
@Route(value = "Documents", layout = MainLayout.class)
public class DocumentsView extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    public DocumentsView() {

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Documents");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE, Gap.MEDIUM, Margin.NONE, Padding.NONE);
        Paragraph description = new Paragraph("Below are my current resume and my transcript. You can download these .png files below their images.");
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Image resume = new Image("images/resume.png", "Resume");
        resume.setWidth("800px");
        
        Image resume2 = new Image("images/resume2.png", "Resume");
        resume2.setWidth("800px");

        Image transcript = new Image("images/transcript.png", "Transcript");
        transcript.setWidth("800px");

        H4 resumeHeader = new H4("Resume");
        resumeHeader.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);

        H4 trHeader = new H4("Transcript");
        trHeader.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);

        container.add(headerContainer);
        add(container);
        add(resumeHeader, resume, resume2, trHeader, transcript); 

        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        
        
	}

}
