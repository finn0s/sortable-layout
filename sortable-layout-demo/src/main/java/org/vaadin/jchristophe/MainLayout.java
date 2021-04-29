package org.vaadin.jchristophe;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

@CssImport("./demo.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        final DrawerToggle drawerToggle = new DrawerToggle();
        final RouterLink simple = new RouterLink("Simple demos", SortableLayoutView.class);
        final RouterLink twoLayout = new RouterLink("TwoLayout", TwoLayoutsView.class);
        final RouterLink trello = new RouterLink("Trello-like", TrelloLayoutView.class);
        final RouterLink card = new RouterLink("Card", CardSortableLayoutView.class);
        final VerticalLayout menuLayout = new VerticalLayout(twoLayout, simple, trello, card);
        addToDrawer(menuLayout);
        addToNavbar(drawerToggle);
    }

}