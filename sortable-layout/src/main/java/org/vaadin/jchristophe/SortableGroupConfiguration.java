package org.vaadin.jchristophe;

import com.vaadin.flow.component.JsonSerializable;
import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jcgueriaud
 */
public class SortableGroupConfiguration implements JsonSerializable {

    private String name;
    // put
    private final List<String> groupNameDragInAllowed = new ArrayList<>();
    // pull
    private final List<String> groupNameDragOutAllowed = new ArrayList<>();
    // pull
    private boolean dragOutAllowed = true;
    // pull
    private boolean clone = false;
    // put
    private boolean dragInAllowed = false;


    public String getName() {
        return name;
    }

    /**
     * Set the group name
     *
     * @param name group name
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean isDragOutAllowed() {
        return dragOutAllowed;
    }

    /**
     * Ability to move from the list.
     * - true to be able to move the items from the list
     * - false to allow only reorder
     * @see #addDragOutGroupName(String) to restrict the group which the elements may be put in
     *
     * @param dragOutAllowed  Defaults to true.
     */
    public void setDragOutAllowed(boolean dragOutAllowed) {
        this.dragOutAllowed = dragOutAllowed;
    }

    public boolean isDragInAllowed() {
        return dragInAllowed;
    }

    /**
     * whether elements can be added from other lists.
     * - true to be able to move in the list
     * - false to allow only reorder
     * @see #addDragInGroupName(String) to restrict the group from which elements can be added.
     *
     * @param dragInAllowed Defaults to true.
     */
    public void setDragInAllowed(boolean dragInAllowed) {
        this.dragInAllowed = dragInAllowed;
    }

    /**
     *
     * @param name group name
     */
    public void addDragInGroupName(String name) {
        groupNameDragInAllowed.add(name);
    }

    /**
     *
     * @param name group name
     */
    public void addDragOutGroupName(String name) {
        groupNameDragOutAllowed.add(name);
    }

    public boolean isClone() {
        return clone;
    }

    /**
     * Whether the previous list keeps a copy of the element
     * Warning: Can't be used with {@link #addDragOutGroupName(String)}
     * @param clone true to clone the item
     */
    public void setClone(boolean clone) {
        this.clone = clone;
    }
    @Override
    public JsonObject toJson() {
        JsonObject obj = Json.createObject();
        if (getName() != null) {
            obj.put("name", getName());
        }
        if (groupNameDragInAllowed.isEmpty()) {
            obj.put("put", dragInAllowed);
        } else {
            JsonArray array = Json.createArray();
            for (int i = 0; i < groupNameDragInAllowed.size(); i++) {
                array.set(i, groupNameDragInAllowed.get(i));
            }
            obj.put("put", array);
        }

        if (isClone()) {
            obj.put("pull", "clone");
        } else {
            if (groupNameDragOutAllowed.isEmpty()) {
                obj.put("pull", dragOutAllowed);
            } else {
                JsonArray array = Json.createArray();
                for (int i = 0; i < groupNameDragOutAllowed.size(); i++) {
                    array.set(i, groupNameDragOutAllowed.get(i));
                }
                obj.put("pull", array);
            }
        }
        return obj;
    }

    @Override
    public JsonSerializable readJson(JsonObject value) {
        return null;
    }
}
