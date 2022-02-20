package com.example.application.views.list;

import com.example.application.data.entity.Quote;
import com.example.application.data.service.QuoteService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;

@Route(value = "")
@Theme(themeFolder = "fortunequotes")
@PageTitle("Fortune | Quotes")
public class ListView extends VerticalLayout {
    Paragraph displayQuote = new Paragraph();
    QuoteService service;

    public ListView(QuoteService service) {
        this.service = service;
        addClassName("list-view");
        setSizeFull();
        add(getToolbar(), getContent());
        updateText();
    }

    private HorizontalLayout getContent() {
        Button refresh = new Button("Refresh quote");
        refresh.addClickListener(click -> updateText());

        VerticalLayout innerContent = new VerticalLayout(displayQuote, refresh);
        innerContent.setSizeFull();
        innerContent.setJustifyContentMode(JustifyContentMode.AROUND);
        innerContent.setAlignItems(Alignment.CENTER);

        HorizontalLayout content = new HorizontalLayout(innerContent);
        content.addClassNames("content");
        content.setSizeFull();
        content.setAlignItems(Alignment.CENTER);

        displayQuote.addClassName("quote");

        return content;
    }

    private HorizontalLayout getToolbar() {
        TextArea newQuote = new TextArea();
        newQuote.setPlaceholder("Create a new quote");
        newQuote.setClearButtonVisible(true);
        newQuote.setSizeFull();
        newQuote.setValueChangeMode(ValueChangeMode.LAZY);

        Button save = new Button("Add quote");
        save.setMinWidth("fit-content");
        save.addClickListener(click -> {
            saveQuote(newQuote.getValue());
            newQuote.setValue("");
        });

        HorizontalLayout toolbar = new HorizontalLayout(newQuote, save);
        toolbar.addClassName("toolbar");
        toolbar.setWidthFull();

        return toolbar;
    }

    private void saveQuote(String quote) {
        if (quote.isBlank() || quote.isEmpty()) {
            return;
        }
        Quote newQuote = new Quote();
        newQuote.setQuote(quote);
        service.saveQuote(newQuote);
        displayQuote.setText(quote);
    }

    private void updateText() {
        String quote = service.findQuote();
        String q = quote.replaceAll("\n", "<br>");
        displayQuote.getElement().setProperty("innerHTML", q);
    }
}