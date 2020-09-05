public class subStringIndex {
    public static void main(String args[]) {
        String haystack = "mississippi";
        String needle = "issip";
        int index = needleIndex(haystack, needle);
        System.out.println("Index is" + index);
    }

    public static int needleIndex(String haystack, String needle) {
        if (needle.length( ) == 0)
            return 0;
        if (haystack.length( ) < needle.length( ))
            return -1;
        int index = nextCommonIndex(haystack,0,needle),j = 0,i;
        System.out.println("Got "+index);
        if(index < 0)
            return -1;
        i = index;
        while (j < needle.length() && i != -1 && i < haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else
            {
                i = nextCommonIndex(haystack, index+1,needle);
                index = i;
                j = 0;
                System.out.println("Got "+i);
            }
        }
        if(j == needle.length())
            return index;
        else
            return -1;
    }
    public static int nextCommonIndex(String haystack, int fromIndex, String needle){
        int index = -1;
        for (int i = fromIndex; i < haystack.length( ); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
