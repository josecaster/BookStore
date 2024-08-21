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
import org.example.people.Worker;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Worker Page")
@Route(value = "worker")
@RouteAlias(value = "worker")
public class WorkerLayout extends VerticalLayout {


    private Grid<Worker> grid;
    private List<Worker> listOfWorker;

    public WorkerLayout() {

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        NumberField idFld = new NumberField();
        idFld.setLabel("ID#");

        TextField firstNameFld = new TextField();
        firstNameFld.setLabel("Firstname");

        TextField lastNameFld = new TextField();
        lastNameFld.setLabel("Surname");

        Button button = new Button();
        button.setText("Submit");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(clicked -> {
            Double id = idFld.getValue();
            String firstName = firstNameFld.getValue();
            String lastName = lastNameFld.getValue();

            if(id != null && StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName)){
                Worker worker = new Worker(firstName, lastName,id.intValue());
                listOfWorker.add(worker);
                grid.getDataProvider().refreshAll();
            } else {
                Notification.show("Please fill in all required field!", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(idFld,firstNameFld,lastNameFld, button);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setAlignItems(Alignment.END);

        grid = new Grid<>(Worker.class);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        listOfWorker = new ArrayList<>();
        grid.setItems(listOfWorker);
        add(horizontalLayout, grid);
    }
}
