package org.harpia;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

import org.vaadin.sliderpanel.SliderPanel;
import org.vaadin.sliderpanel.SliderPanelBuilder;
import org.vaadin.sliderpanel.SliderPanelStyles;
import org.vaadin.sliderpanel.client.SliderMode;
import org.vaadin.sliderpanel.client.SliderTabPosition;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

@CDIUI("")
@Theme("mytheme")
public class HarpiaUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		layout.setSizeFull();
		layout.setMargin(false);
		layout.setSpacing(false);
		
		Button button = new Button("Botao teste");
		
		button.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				 
				Notification.show("Botão Testado com sucesso!",Notification.Type.HUMANIZED_MESSAGE);
				
				
			}
			
			
			
			
		});

		SliderPanel sliderPanel = new  SliderPanelBuilder(button)
				.caption("Janela 1")
				.mode(SliderMode.RIGHT)
				.tabPosition(SliderTabPosition.BEGINNING)				
				.style(SliderPanelStyles.COLOR_GRAY)
				.build();

		layout.addComponent(sliderPanel);
		layout.setComponentAlignment(sliderPanel,layout.ALIGNMENT_DEFAULT.TOP_RIGHT);
		 
	    

		setContent(layout);
	}
	
	
	public class Bean implements Serializable {
	    String name;
	    double energy; // Energy content in kJ/100g

	    public Bean(String name, double energy) {
	        this.name   = name;
	        this.energy = energy;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getEnergy() {
	        return energy;
	    }

	    public void setEnergy(double energy) {
	        this.energy = energy;
	    }
	}

}
