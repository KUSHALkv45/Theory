// function KMP (subString):

                     
    (String patt , String given)
{
                   
    int [] lps = new int [patt.length()];
        int j = 0;
        int i = 1;
        while(i < patt.length()){
            if(patt.charAt(i) == patt.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j > 0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0;
        j = 0;

        while(i < patt.length() && j < given.length()){
            char ci = patt.charAt(i); char cj = given.charAt(j);
            if(ci == cj){
                i++;j++;
            }
            else{
                if(i == 0){
                    j++;
                }
                else{
                    i = lps[i-1];
                }
                
            }
        }

        // System.out.println("first index at : " + (j-patt.length()) );

        return i == patt.length();
} 
