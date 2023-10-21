import java.util.HashMap;
import java.util.Random;

public class JeffCode{
    private final Random random = new Random();
    private long code;
    public Long jeffCode(){
        long temp_code = random.nextLong();
        if(temp_code < 0){
            temp_code = 2 * (-temp_code);
        }
        code = temp_code;
        return code;
    }
    public Long mixJeffCode(){
        final HashMap long_z = new HashMap();
        code = long_z.hashCode();
        return code;
    }
}