package edu.unl.cc.kawsayfit.controller.converters;

import edu.unl.cc.kawsayfit.model.enums.Goal;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Named;

@Named("goalConverter")
@Dependent
public class GoalConverter implements Converter<Goal> {

    @Override
    public Goal getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        return Goal.valueOf(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Goal value) {
        if (value == null) return "";
        return value.name();
    }
}
