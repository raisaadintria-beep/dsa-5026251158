package lw01.unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override 

    public int calculateCharge() {
        if (getDays()<= 3) {
            return getDays() * 60000 ;
        } else { 
            return (3 * 60000) + ( (getDays() - 3) * 45000) + (2 * 20000); //mas mbak saya gak tau cara kaliin sama unitnya :(
        }
         
    }

    @Override 

    public String label() {
        return "PROJECTOR" ;
    }  
    
}
