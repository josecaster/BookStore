package org.example.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.lang3.StringUtils;
import org.example.BookService;
import org.example.exceptions.DatabaseException;
import org.example.item.Books;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@PageTitle("First Page")
@Route(value = "books")
@RouteAlias(value = "books")
public class BooksLayout extends VerticalLayout {

//    String myString = "Jerry";

    private Grid<Books> grid;
    private List<Books> listOfBooks;

    public BooksLayout(BookService bookService) {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        TextField titleFld = new TextField();
        titleFld.setLabel("Title");

        TextField authorFld = new TextField();
        authorFld.setLabel("Author");

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setAcceptedFileTypes("application/pdf", ".pdf");

        int maxFileSizeInBytes = 10 * 1024 * 1024; // 10MB
        upload.setMaxFileSize(maxFileSizeInBytes);

        upload.addFileRejectedListener(event -> {
            String errorMessage = event.getErrorMessage();

            Notification notification = Notification.show(errorMessage, 5000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });

        Button button = new Button();
        button.setText("Submit");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(clicked -> {
            String title = titleFld.getValue();
            String author = authorFld.getValue();

            if (StringUtils.isNotBlank(title) && StringUtils.isNotBlank(author)) {
                Books books = new Books(null, title, author);
                try {
                    books.setBookPdf(buffer.getInputStream().readAllBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Books save = bookService.save(books);
                listOfBooks.add(save);
                grid.getDataProvider().refreshAll();
            } else {
                Notification.show("Please fill in all required field!", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(titleFld, authorFld, upload, button);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setAlignItems(Alignment.END);

        grid = new Grid<>();
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        listOfBooks = bookService.getAll();
        grid.setItems(listOfBooks);
        grid.addColumn(new ValueProvider<Books, Integer>() {
            @Override
            public Integer apply(Books books) {
                return books.getId();
            }
        }).setHeader("ID");
        grid.addColumn(Books::getNaam).setHeader("Title");
        grid.addColumn(Books::getAuthor).setHeader("Author");
        grid.addComponentColumn(books -> {
            if(books.getBookPdf() == null){
                return null;
            }
            return new Anchor(new StreamResource("mypdf.pdf", () -> {

                return new ByteArrayInputStream(books.getBookPdf());
            }), "Download pdf");
        });
        grid.addComponentColumn(new ValueProvider<Books, Component>() {
            @Override
            public Component apply(Books book) {
                Button button1 = new Button();
                button1.setIcon(VaadinIcon.TRASH.create());
                button1.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_ICON);
                button1.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
                    @Override
                    public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                        ConfirmDialog confirmDialog = new ConfirmDialog("Delete record", "Are you sure you want to delete this?", "Yes", l -> {

                            try {
                                bookService.delete(book.getId());
                                Notification.show("Your record is successfully deleted", 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                                listOfBooks.remove(book);
                                grid.getDataProvider().refreshAll();
                            } catch (DatabaseException e) {
                                Notification.show("Could not delete! " + e.getMessage(), 5000, Notification.Position.TOP_CENTER).addThemeVariants(NotificationVariant.LUMO_ERROR);
                            }

                        });
                        confirmDialog.setCancelable(true);
                        confirmDialog.open();


                    }
                });
                return button1;
            }
        });

        add(horizontalLayout, grid);


//        try {
//            doSomething();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//        if(true){
//            String myString = "Jerry";
//            System.out.println(myString);
//            System.out.println(this.myString);
//        }
//        if(true){
//            String myString = "Jerry";
//        }

    }

//    public void doSomething() throws Exception {
//
//    }


}
