import java.util.*;
public class DeleteProducts {
        public static int deleteProducts(List<Integer> ids, int m) {
            // Write your code here
            Map<Integer, Integer> prodToFreq = new HashMap<>();
            for (int i = 0; i < ids.size(); i++) {
                Integer curr = ids.get(i);
                if(prodToFreq.containsKey(curr)) {
                    //System.out.println("Found "+ curr);
                    prodToFreq.put(curr, prodToFreq.get(curr) + 1);
                }else{
                    //System.out.println("New "+ curr);

                    prodToFreq.put(curr, 1);
                }
            }
            System.out.println(prodToFreq);
            Set<Map.Entry<Integer,Integer>> sorted = new TreeSet<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer,Integer>>() {
                @Override
                public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {

                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            System.out.println(prodToFreq.entrySet());
            //sorted.addAll(prodToFreq.entrySet());
            Iterator<Map.Entry<Integer, Integer>> itr1 = prodToFreq.entrySet().iterator();
            while(itr1.hasNext()) {
                Map.Entry<Integer, Integer> item = itr1.next();
                System.out.println(item.getValue());
                sorted.add(item);
            }

            System.out.println(sorted.size());
            Iterator<Map.Entry<Integer, Integer>> itr = sorted.iterator();

            int count = sorted.size();
            while(itr.hasNext() && m>0 && count > 0) {
                int freq = itr.next().getValue();
                if(m >= freq) {
                    m = m - freq;
                    count = count - 1;
                } else {
                    break;
                }
            }
            return count;
        }
    }
