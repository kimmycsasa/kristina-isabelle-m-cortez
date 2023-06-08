package com.example.application.views.projects;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Projects")
@Route(value = "Projects", layout = MainLayout.class)
public class ProjectsView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public ProjectsView() {
        constructUI();

        imageContainer.add(new ProjectsViewCard("Monopoly","images/monopoly.png", "Monopoly", "2022", "A recreation of the classic board game Monopoly with a Marvel theme. Created for my grade 12 computer science independent study unit.", "Java, Java Swing" ));
        imageContainer.add(new ProjectsViewCard("Water Purification Detector","", "Water Purification Detector", "2022", "A device that detects the safety of water for drinking, using a light sensor and a ph sensor to determine safety, and a display board to notify the user. Created for my Project Studio course during my first year of university.", "STM32, STM32CubeIDE, CQRobot Ocean Ambient Light Sensor, SPI TFT LCD Display Module, Liquid PH 0-14 Value Sensor Module"));
        imageContainer.add(new ProjectsViewCard("Snake","images/snake.png", "Snake", "2023", "A recreation of the online game Snake.",  "Java, Java Swing" ));
        imageContainer.add(new ProjectsViewCard("Website","images/website.png", "Personal Website", "2023", "A personal website to showcase myself, including my skills and projects. A platform to store my achievements for others to view.",  "Java, Spring Boot, Vaadin" ));
        imageContainer.add(new ProjectsViewCard("Geesespotter", "", "Geesespotter", "2022", "A recreation of the classic game Minesweeper with a goose theme using ASCII. Created for my C++ programming course during my first year of university.",  "C++" ));
        imageContainer.add(new ProjectsViewCard("Vision", "images/vision.png", "Sticker Verifying System", "2023", "A system that verifies the proper placement of stickers onto surfaces using machine vision. Created for the Toyota Innovation Challenge hackathon",  "Python, OpenCV, Orbbec Astra SDK, Orbbec Astra 3D Camera" ));

    }

    private void constructUI() {
        addClassNames("projects-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Projects");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        Paragraph description = new Paragraph("Made with different programming languages and tools, ranging from the beginning of my journey to my current skill level. The source code for these projects can be found in my GitHub.");
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Select<String> sortBy = new Select<>();
        sortBy.setLabel("Sort by");
        sortBy.setItems("Language", "Newest first", "Oldest first");
        sortBy.setValue("Filter");

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer, sortBy);
        add(container, imageContainer);

    }                                                 
}
