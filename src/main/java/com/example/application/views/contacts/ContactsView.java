package com.example.application.views.contacts;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import jakarta.annotation.Nonnull;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;



@PageTitle("Contacts")
@Route(value = "Contacts", layout = MainLayout.class)
public class ContactsView extends Div {

        private class Contact{
            @Nonnull
            private String domain; 

            @Nonnull
            private String username; 

            @Nonnull
            private String url; 

            @Nonnull
            private String pic; 

            Contact(String domain, String username, String url, String pic){
                this.domain = domain; 
                this.username = username; 
                this.url = url; 
                this.pic = pic;

            } 

            public String getDomain(){
                return domain; 
            }
            
            public String getUser(){
                return username; 
            }

            public String getURL(){
                return url; 
            }

            public String getPic(){
                return pic; 
            }

        }

        Contact git = new Contact("GitHub", "kimmycsasa", "https://github.com/kimmycsasa", "images/gitHub.png"); 
        Contact link = new Contact("LinkedIn", "Kristina Isabelle (M.) Cortez", "linkedin.com/in/kristina-isabelle-cortez-540765215", "images/linkedIn.png");
        Contact outlook = new Contact("Outlook", "kimcorte@uwaterloo.ca", "", "images/outlook.png");
        Contact gmail = new Contact("Gmail", "kisabellecortez@gmail.com", "", "images/gmail.png"); 

        private ComponentRenderer<Component, Contact> contactCardRenderer = new ComponentRenderer<>(
            contact -> {

                HorizontalLayout cardLayout = new HorizontalLayout();
                cardLayout.setMargin(true);
                setSizeFull();

                Avatar avatar = new Avatar(contact.getDomain(),
                contact.getPic());
                avatar.setHeight("64px");
                avatar.setWidth("64px");

                VerticalLayout infoLayout = new VerticalLayout();
                infoLayout.setSpacing(false);
                infoLayout.setPadding(false);
                infoLayout.getElement().appendChild(
                        ElementFactory.createStrong(contact.getDomain()));
                infoLayout.add(new Div(new Text(contact.getUser())));

                VerticalLayout contactLayout = new VerticalLayout();
                contactLayout.setSpacing(false);
                contactLayout.setPadding(false);
                contactLayout.add(new Div(new Text(contact.getURL())));
                infoLayout
                        .add(new Details("Link", contactLayout));

                cardLayout.add(avatar, infoLayout);
                return cardLayout;


            }
        );

        public ContactsView() {
            VirtualList<Contact> list = new VirtualList<>();
            list.setItems(git, link, outlook, gmail);
            list.setRenderer(contactCardRenderer);
            add(list);
        }
        
    //}



} 



