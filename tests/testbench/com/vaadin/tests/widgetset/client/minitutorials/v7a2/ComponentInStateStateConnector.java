/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.tests.widgetset.client.minitutorials.v7a2;

import com.google.gwt.user.client.ui.Label;
import com.vaadin.terminal.gwt.client.ComponentConnector;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;
import com.vaadin.tests.minitutorials.v7a2.ComponentInStateComponent;

@Connect(ComponentInStateComponent.class)
public class ComponentInStateStateConnector extends AbstractComponentConnector {
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().setText(
                "Client-side type of other component: "
                        + getOtherComponent().getClass().getName());
    }

    public ComponentConnector getOtherComponent() {
        return (ComponentConnector) getState().getOtherComponent();
    }

    @Override
    public ComponentInStateState getState() {
        return (ComponentInStateState) super.getState();
    }

    @Override
    public Label getWidget() {
        return (Label) super.getWidget();
    }
}
