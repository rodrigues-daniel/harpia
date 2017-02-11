package org.harpia;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

import org.atmosphere.util.analytics.GoogleAnalytics_v1_URLBuildingStrategy;
import org.vaadin.sliderpanel.SliderPanel;
import org.vaadin.sliderpanel.SliderPanelBuilder;
import org.vaadin.sliderpanel.SliderPanelStyles;
import org.vaadin.sliderpanel.client.SliderMode;
import org.vaadin.sliderpanel.client.SliderTabPosition;

import com.google.gwt.maps.client.LoadApi.Language;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;

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
		final VerticalLayout mainLayout = new VerticalLayout();
		final HorizontalLayout subLayout = new HorizontalLayout();

		mainLayout.setSizeFull();
		subLayout.setSizeFull();
		
		
		
		SliderPanel sliderPanel = new  SliderPanelBuilder(new Label("Conteudo HTML",ContentMode.HTML))
				.caption("Controle de Atendimentos")
				.mode(SliderMode.TOP)
				.tabPosition(SliderTabPosition.MIDDLE)				
				.style(SliderPanelStyles.COLOR_BLUE)
				.build();

		
		mainLayout.addComponent(sliderPanel);
		
		
		
		
		GoogleMap gmap = new GoogleMap("AIzaSyAV5v_BKb3vie085zaF3Ehl2zDAiZDd8s0",null,"english");
		gmap.setSizeFull();	
		gmap.setHeight("800");			
			
	 
		subLayout.addComponent(gmap);
	
	 
		 
		
		
		
		mainLayout.addComponent(subLayout);
		mainLayout.setComponentAlignment(subLayout,Alignment.MIDDLE_CENTER);
		
	   
	  
	   mainLayout.setExpandRatio(subLayout,5);
		 
	    

		setContent(mainLayout);
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
