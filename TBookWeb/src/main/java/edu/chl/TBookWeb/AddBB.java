
package edu.chl.TBookWeb;

import edu.chl.tbook.core.Exercise;
import edu.chl.tbook.core.ExerciseCatalogue;
import edu.chl.tbook.core.IExerciseCatalogue;
import edu.chl.tbook.core.IUserCatalogue;
import edu.chl.tbook.core.IWorkoutCatalogue;
import edu.chl.tbook.core.TBook;
import edu.chl.tbook.core.Workout;
import java.util.ArrayList;  
import java.util.Calendar;
import java.util.List;  
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.TransferEvent;  
  
import org.primefaces.model.DualListModel;  
@Named("add")
@RequestScoped  
public class AddBB {  
    private IExerciseCatalogue exCat = TBook.INSTANCE.getExerciseCatalogue(); 
    private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();
    private IWorkoutCatalogue workCat = TBook.INSTANCE.getWorkoutCatalogue();
    private DualListModel<String> cities;
    private String name="";

    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
  
    public AddBB() {  
          
          
        //Cities  
        List<String> citiesSource = new ArrayList<String>();  
        List<String> citiesTarget = new ArrayList<String>();  
        List<Exercise> exes = exCat.getAll();
        for(Exercise e :exes){
            citiesSource.add(e.getEname());
            
        }
          
          
        cities = new DualListModel<String>(citiesSource, citiesTarget);  
    }  
      
    public DualListModel<String> getCities() {  
        return cities;    
}  
    public void setCities(DualListModel<String> cities) {  
        this.cities = cities;  
    }  
    
    public String action() {
        List<Exercise> ex = new ArrayList<Exercise>();
        List<String> extarget = cities.getTarget();
        for (String e : extarget) {
            ex.add(exCat.find(e));
        }

        workCat.add(new Workout(userCat.find(request.getRemoteUser()), ex,
                name,
                Calendar.getInstance().getTimeInMillis() + 1350551775));
        name="";
        return "index?faces-redirect=true";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
   

