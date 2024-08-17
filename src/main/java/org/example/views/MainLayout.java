package org.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.apache.commons.lang3.StringUtils;
import org.example.item.Books;

import java.util.ArrayList;
import java.util.List;

@PageTitle("First Page")
@Route(value = "")
@RouteAlias(value = "")
public class MainLayout extends VerticalLayout {


    private Grid<Books> grid;
    private List<Books> listOfBooks;

    public MainLayout() {

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        NumberField idFld = new NumberField();
        idFld.setLabel("ID#");

        TextField titleFld = new TextField();
        titleFld.setLabel("Title");

        TextField authorFld = new TextField();
        authorFld.setLabel("Author");

        Button button = new Button();
        button.setText("Submit");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(clicked -> {
            Double id = idFld.getValue();
            String title = titleFld.getValue();
            String author = authorFld.getValue();

            if(id != null && StringUtils.isNotBlank(title) && StringUtils.isNotBlank(author)){
                Books books = new Books(id.intValue(), title, author);
                listOfBooks.add(books);
                grid.getDataProvider().refreshAll();
            } else {
                Notification.show("Please fill in all required field!", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(idFld,titleFld,authorFld, button);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setAlignItems(Alignment.END);

        grid = new Grid<>(Books.class);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        listOfBooks = new ArrayList<>();
        grid.setItems(listOfBooks);
        add(horizontalLayout, grid);
    }
}
