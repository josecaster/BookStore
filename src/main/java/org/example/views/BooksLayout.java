package org.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.apache.commons.lang3.StringUtils;
import org.example.BookService;
import org.example.item.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PageTitle("First Page")
@Route(value = "books")
@RouteAlias(value = "books")
public class BooksLayout extends VerticalLayout {


    private Grid<Books> grid;
    private List<Books> listOfBooks;

    public BooksLayout(BookService bookService) {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        TextField titleFld = new TextField();
        titleFld.setLabel("Title");

        TextField authorFld = new TextField();
        authorFld.setLabel("Author");

        Button button = new Button();
        button.setText("Submit");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(clicked -> {
            String title = titleFld.getValue();
            String author = authorFld.getValue();

            if(StringUtils.isNotBlank(title) && StringUtils.isNotBlank(author)){
                Books books = new Books(null,title, author);
                Books save = bookService.save(books);
                listOfBooks.add(save);
                grid.getDataProvider().refreshAll();
            } else {
                Notification.show("Please fill in all required field!", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(titleFld,authorFld, button);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setAlignItems(Alignment.END);

        grid = new Grid<>(Books.class);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        listOfBooks = bookService.getAll();
        grid.setItems(listOfBooks);
        add(horizontalLayout, grid);
    }
}
