package org.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.apache.commons.lang3.StringUtils;
import org.example.BookService;
import org.example.MagazinesService;
import org.example.item.Books;
import org.example.item.Magazines;

import java.util.List;

@PageTitle("Magazines page")
@Route(value = "magazines")
@RouteAlias(value = "magazines")
public class MagazinesLayout extends VerticalLayout {


    private Grid<Magazines> grid;
    private List<Magazines> listOfMagazines;

    public MagazinesLayout(MagazinesService magazinesService) {
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
                Magazines magazines = new Magazines(null,title, author);
                Magazines save = magazinesService.save(magazines);
                listOfMagazines.add(save);
                grid.getDataProvider().refreshAll();
            } else {
                Notification.show("Please fill in all required field!", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(titleFld,authorFld, button);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setAlignItems(Alignment.END);

        grid = new Grid<>(Magazines.class);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        listOfMagazines = magazinesService.getAll();
        grid.setItems(listOfMagazines);

        add(horizontalLayout, grid);
    }
}
