import java.util.Random;

public class Market {
    Random rand = new Random();

    double sugar;
    double sugarPieces;
    double salt;
    double saltPieces;
    double bread;
    double breadPieces;
    double uvLight;
    double uvLightPieces;
    int rounds = 0;
    int activeEvent = 0;
    int lastRounds = 0;
    /* 
    fast Increase = 0
    slow Increase = 1
    fast Decrase = 2
    slow Decrase = 3
    Stabil = 4
    */
    //Creating variables.

    public Market(){
        sugar = rand.nextDouble(0, 10);
        salt = rand.nextDouble(0, 10);
        bread = rand.nextDouble(0, 10);
        uvLight = rand.nextDouble(0, 10);
        //Defining some of it.
    }

    public void SkipTurn(){
        if(lastRounds == 0){
            activeEvent = rand.nextInt(0, 5);
            //Choosing active event.
            lastRounds =  rand.nextInt(2, 7);
            //Choosing how many turns will it last.
        }

        if(activeEvent == 0){
            sugar = rand.nextDouble(sugar*1, sugar*3);
            salt = rand.nextDouble(salt*1, salt*3);
            bread = rand.nextDouble(bread*1, bread*3);
            uvLight = rand.nextDouble(uvLight*1, uvLight*3);
            //Fast Increase
        }else if(activeEvent == 1){
            sugar = rand.nextDouble(sugar*0.75, sugar*2);
            salt = rand.nextDouble(salt*0.75, salt*2);
            bread = rand.nextDouble(bread*0.75, bread*2);
            uvLight = rand.nextDouble(uvLight*0.75, uvLight*2);
            //Slow Increase
        }else if(activeEvent == 2){
            sugar = rand.nextDouble(sugar*0.0001, sugar*0.5);
            salt = rand.nextDouble(salt*0.0001, salt*0.5);
            bread = rand.nextDouble(bread*0.0001, bread*0.5);
            uvLight = rand.nextDouble(uvLight*0.0001, uvLight*0.5);
            //Fast Decrease
        }else if(activeEvent == 3){
            sugar = rand.nextDouble(sugar*0.0001, sugar*1.25);
            salt = rand.nextDouble(salt*0.0001, salt*1.25);
            bread = rand.nextDouble(bread*0.0001, bread*1.25);
            uvLight = rand.nextDouble(uvLight*0.0001, uvLight*1.25);
            //Slow Decrease
        }else if(activeEvent == 4){
            sugar = rand.nextDouble(sugar*0.1, sugar*2);
            salt = rand.nextDouble(salt*0.1, salt*2);
            bread = rand.nextDouble(bread*0.1, bread*2);
            uvLight = rand.nextDouble(uvLight*0.1, uvLight*2);
            //Stabil
        }

        rounds ++;
        lastRounds --;
        //The change in their prices
    }

    public double getSugarPrice(){
        return sugar;
    }
    public void setSugarPiece(double sugarPieces){
        this.sugarPieces = sugarPieces;
    }
    public double getSugarValue(){
        return sugar*sugarPieces;
    }

    public double getSaltPrice(){
        return salt;
    }
    public void setSaltPieces(double saltPieces){
        this.saltPieces = saltPieces;
    }
    public double getSaltValue(){
        return salt*saltPieces;
    }

    public double getBreadPrice(){
        return bread;
    }
    public void setBreadPieces(double breadPieces){
        this.breadPieces = breadPieces;
    }
    public double getBreadValue(){
        return bread*breadPieces;
    }

    public double getUVPrice(){
        return uvLight;
    }
    public void setUVPieces(double uvLightPieces){
        this.uvLightPieces = uvLightPieces;
    }
    public double getUVValue(){
        return uvLight*uvLightPieces;
    }

    public double getTotalValue(){
        return getSugarValue() + getSaltValue() + getBreadValue() + getUVValue();
    }
    //Getter and setter methods
}
