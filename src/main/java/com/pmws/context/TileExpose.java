package com.pmws.context;
/**
 * @author guruprasanna n
 *  This class is used for all expose java beans to jsp 
 */
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class TileExpose extends UrlBasedViewResolver{

	
	private Boolean exposeContextBeansAsAttributes;
    private String[] exposedContextBeanNames;

    public void setExposeContextBeansAsAttributes(boolean exposeContextBeansAsAttributes) {
        this.exposeContextBeansAsAttributes = exposeContextBeansAsAttributes;
    }

    public void setExposedContextBeanNames(String[] exposedContextBeanNames) {
        this.exposedContextBeanNames = exposedContextBeanNames;
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        AbstractUrlBasedView superView = super.buildView(viewName);
        if (superView instanceof TileExposeView) {
            TileExposeView view = (TileExposeView) superView;
            if (this.exposeContextBeansAsAttributes != null) view.setExposeContextBeansAsAttributes(this.exposeContextBeansAsAttributes);
            if (this.exposedContextBeanNames != null) view.setExposedContextBeanNames(this.exposedContextBeanNames);
        }
        return superView;
    }



}
