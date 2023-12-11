import java.util.*; //247

class Music {
    public int num;
    public String genre;
    public int play;
    
    public Music(int num, String genre, int play) {
        this.num = num;
        this.genre = genre;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int l = plays.length;
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> gMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        Music[] musics = new Music[l];
        
        for(int i = 0; i < l; i++) {
            String g = genres[i];
            int p = plays[i];
            
            if(!gMap.containsKey(g)) gMap.put(g, p);
            else gMap.put(g, gMap.get(g)+p);
        }
        
        for(int i = 0; i < l; i++) {
            musics[i] = new Music(i, genres[i], plays[i]);
        }
        
        Arrays.sort(musics, (m1, m2) -> {
            if(m1.genre.equals(m2.genre)) {
                if(m1.play == m2.play) {
                    return m1.num - m2.num;
                } else {
                    return m2.play - m1.play;
                }
            } else {
                return gMap.get(m2.genre)-gMap.get(m1.genre);
            }
            
        });
        
        for(int i = 0; i < l; i++) {
            String mg = musics[i].genre;
            
            if(!cMap.containsKey(mg)) {
                cMap.put(mg, 1);
                answer.add(musics[i].num);
            } 
            else if(cMap.containsKey(mg) && cMap.get(mg) == 1) {
                cMap.put(mg, 2);
                answer.add(musics[i].num);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}