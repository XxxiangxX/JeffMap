import java.util.*;

public final class JeffMap<Key,Objects> extends HashMap<Key,Objects>{
    private Map<Key,Objects> map;
    private List<Long> code;
    private boolean empty;
    private final List<Key> c_key = new ArrayList<>();
    private final List<Objects> c_value = new ArrayList<>();
    private final JeffCode jeffCode = new JeffCode();
    private final Random random = new Random();
    public JeffMap(){
        try{
            map = new HashMap<>();
            code = new ArrayList<>();
        }catch (Exception e){
            e.printStackTrace();
        }
        check();
    }
    private void check(){
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
    public void add(final Key key,final Objects object) {
        check();
        map.put(key, object);
        c_key.add(key);
        c_value.add(object);
        empty = false;
    }
    public void removeFromKey(final Key key){
        check();
        map.remove(key);
        empty = false;
    }
    public Boolean containKey(final Key key){
        for(Key key1 : c_key){
            if(key == key1){
                return true;
            }
        }
        return false;
    }
    public Boolean containObjects(final Objects value){
        for(Objects objects : c_value){
            if(objects == value){
                return true;
            }
        }
        return false;
    }
    public void print(boolean checkCode){
        if(map.size() != 0){
            if(checkCode){
                System.out.println((String) map.toString() + " checkCode: " + jeffCode.jeffCode());
                this.code.add(jeffCode.jeffCode());
            }else{
                System.out.println((String) map.toString());
            }
        }
    }
    public void printRandom(boolean checkCode){
        int randomNumber;
        if(map.size() != 0){
            if(checkCode){
                long code;
                code = random.nextLong();
                randomNumber = random.nextInt(map.size());
                System.out.println(map.values().toArray()[randomNumber] + " checkCode: " + jeffCode.jeffCode());
                this.code.add(jeffCode.jeffCode());
            }else{
                randomNumber = random.nextInt(map.size());
                System.out.println(map.values().toArray()[randomNumber]);
            }
        }
    }
    public List<Long> getCode(){
        return code;
    }

    @Override
    public boolean isEmpty(){
        return empty;
    }

}
