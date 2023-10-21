import java.util.*;

public final class JeffMap<Key,Objects>{
    private Map<Key,Objects> map;
    private List<Long> code;
    private boolean empty;
    private final Random random = new Random();
    public JeffMap(){
        try{
            map = new HashMap<Key, Objects>();
            code = new ArrayList<>();
        }catch (Exception e){
            e.printStackTrace();
        }
        check();
    }
    public void check(){
        if(map == null){
            try{
                throw new Exception("NO INSTALLER IN JEFF-MAP!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(map.size() == 0){
            empty = true;
        }
    }
    public void add(Key key,Objects object){
        check();
        map.put(key,object);
        empty = false;
    }
    public void print(boolean checkCode){
        if(map.size() != 0){
            if(checkCode){
                long code;
                code = random.nextLong();
                System.out.println((String) map.toString() + " checkCode: " + code);
                this.code.add(code);
            }else{
                System.out.println((String) map.toString());
            }
        }
    }
    public List<Long> getCode(){
        return code;
    }
    public boolean isEmpty(){
        return empty;
    }
}
