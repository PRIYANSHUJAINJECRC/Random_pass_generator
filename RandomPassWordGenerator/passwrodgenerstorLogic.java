import java.util.Random;

public class passwrodgenerstorLogic {
    public static final String LOWER_CASE="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CASE="ABCDEFGHIJKMNOPQRSTUVWXYZ";
    public static final String SYMBOLS="!@#$%^&*(){}:'<>.,?/-+||_";
    public static final String NUMBERS="1234567890";
    private final Random random;
    public passwrodgenerstorLogic(){
        random=new Random();
    }
    public String generatepass(int length,boolean lower,boolean upper,boolean num,boolean symbol){
        StringBuilder password=new StringBuilder();
        String validpass="";
        if(lower){
            validpass=validpass+LOWER_CASE;
        }
        if(upper){
            validpass=validpass+UPPER_CASE;
        }
        if(num){
            validpass=validpass+NUMBERS;
        }if(symbol){
            validpass=validpass+SYMBOLS;
        }

        for(int i=0;i<length;i++){
            int randomIndex=random.nextInt(validpass.length());
            char ch=validpass.charAt(randomIndex);
            password.append(ch);
        }
        return password.toString();
    }

}
