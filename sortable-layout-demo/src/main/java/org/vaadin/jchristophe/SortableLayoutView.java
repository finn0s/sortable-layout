package org.vaadin.jchristophe;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

@CssImport("./demo.css")
@Route(value = "")
public class SortableLayoutView extends DemoView {

    @Override
    protected void initView() {
        getElement().setAttribute("style","max-width:90%;");
        createBasicExample();
        createAnimationExample();
        createGroupExample();
        createFilterExample();
        createColorExample();
        //createMultiDragExample();
    }


    private void createBasicExample() {
        Div message = createMessageDiv("basic-message");

        // begin-source-example
        // source-example-heading: Basic Example
        UnorderedList list = new UnorderedList();
        list.add(new ListItem("item 1"),new ListItem("item 2"),new ListItem("item 3"));
        SortableLayout sortableLayout = new SortableLayout(list);
        // end-source-example

        addCard("Basic Example", sortableLayout, message);
    }


    private void createAnimationExample() {
        Div message = createMessageDiv("animation-message");

        // begin-source-example
        // source-example-heading: Animation Example
        UnorderedList list = new UnorderedList();
        list.add(new ListItem("item 1"),new ListItem("item 2"),new ListItem("item 3"));
        SortableConfig config = new SortableConfig();
        config.setAnimation(300);
        SortableLayout sortableLayout = new SortableLayout(list,config);
        // end-source-example

        addCard("Animation Example", sortableLayout, message);
    }


    private void createGroupExample() {
        Div message = createMessageDiv("group-message");

        // begin-source-example
        // source-example-heading: Group Example
        VerticalLayout layout = new VerticalLayout();
        UnorderedList foo = new UnorderedList();
        foo.add(new ListItem("foo 1"),new ListItem("foo 2"),new ListItem("foo 3"));
        SortableConfig sortableConfigFoo = new SortableConfig();
        sortableConfigFoo.setGroupName("foo");
        sortableConfigFoo.setAnimation(100);
        SortableGroupStore sortableGroupStore = new SortableGroupStore();
        SortableLayout sortableLayoutFoo = new SortableLayout(foo, sortableConfigFoo, sortableGroupStore);
        UnorderedList bar = new UnorderedList();
        bar.add(new ListItem("bar 1"),new ListItem("bar 2"),new ListItem("bar 3"));
        SortableConfig sortableConfigBar = new SortableConfig();
        sortableConfigBar.setGroupName("bar");
        sortableConfigBar.allowDragOut(true);
        sortableConfigBar.setAnimation(100);
        SortableLayout sortableLayoutBar = new SortableLayout(bar, sortableConfigBar, sortableGroupStore);

        UnorderedList qux = new UnorderedList();
        qux.add(new ListItem("qux 1"));
        SortableConfig sortableConfigQux = new SortableConfig();
        sortableConfigQux.setGroupName("qux");
        sortableConfigQux.addDragInGroupName("foo");
        sortableConfigQux.addDragInGroupName("bar");
        sortableConfigQux.setAnimation(100);
        SortableLayout sortableLayoutQux = new SortableLayout(qux, sortableConfigQux, sortableGroupStore);
        layout.add(sortableLayoutFoo,sortableLayoutBar,sortableLayoutQux);
        // end-source-example

        addCard("Group Example", layout, message);
    }


    private void createFilterExample() {
        Div message = createMessageDiv("filter-message");

        // begin-source-example
        // source-example-heading: Filter Example
        UnorderedList list = new UnorderedList();
        list.add(new ListItem("item 1"));
        ListItem listItemFilterable = new ListItem("item 2 - is not draggable");
        listItemFilterable.addClassName("ignore-elements");
        list.add(listItemFilterable);
        list.add(new ListItem("item 3"));
        SortableConfig sortableConfig = new SortableConfig();
        sortableConfig.addFilter("ignore-elements");
        SortableLayout sortableLayout = new SortableLayout(list, sortableConfig);
        // end-source-example

        addCard("Filter Example", sortableLayout, message);
    }


    private void createColorExample() {
        Div message = createMessageDiv("color-message");

        // begin-source-example
        // source-example-heading: Color Example
        UnorderedList list = new UnorderedList();
        list.add(new ListItem("item 1"),new ListItem("item 2"),new ListItem("item 3"));
        SortableConfig sortableConfig = new SortableConfig();
        sortableConfig.setChosenClass("custom-sortable-chosen");
        sortableConfig.setDragClass("custom-sortable-drag");
        sortableConfig.setGhostClass("custom-sortable-ghost");
        SortableLayout sortableLayout = new SortableLayout(list, sortableConfig);
        // end-source-example

        addCard("Color Example", sortableLayout, message);
    }


    /// Not working on the server side
    private void createMultiDragExample() {
        Div message = createMessageDiv("multi-drag-message");

        // begin-source-example
        // source-example-heading: Multi Drag Example
        UnorderedList list = new UnorderedList();
        list.add(new ListItem("item 1"),new ListItem("item 2"),
                new ListItem("item 3"),new ListItem("item 4"),
                new ListItem("item 5"),new ListItem("item 6"),
                new ListItem("item 7"));
        SortableConfig sortableConfig = new SortableConfig();
        sortableConfig.setMultiDrag(true);
        sortableConfig.setSelectedClass("selected");
        sortableConfig.setAnimation(150);
        SortableLayout sortableLayout = new SortableLayout(list, sortableConfig);
        // end-source-example

        addCard("Multi Drag Example", sortableLayout, message);
    }

    private Div createMessageDiv(String id) {
        Div message = new Div();
        message.setId(id);
        message.getStyle().set("whiteSpace", "pre");
        return message;
    }
}
