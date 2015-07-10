/* *************************************Question**************************************
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * ***********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-07-10
 * */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> store = new Stack<String>();
        String patharray[] = path.split("/");
        String result = "";
        int len = patharray.length;
        for(int i=0; i<len;i++){
            if(patharray[i].equals(".")){
                // continue;
            }else if(patharray[i].equals("..")){
                if(!store.empty()){
                    store.pop();
                }
            }else if(patharray[i].equals("")){
                // continue;
            }else{
                store.push(patharray[i]);
            }
        }
        if(store.empty()){
            result = "/";
        }
        while(!store.empty()){
            result = "/"+store.pop()+result;
        }
        return result;
    }
}
