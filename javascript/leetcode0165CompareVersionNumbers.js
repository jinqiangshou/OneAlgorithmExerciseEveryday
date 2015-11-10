/**********************************Question***********************************
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *****************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-10
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 **/
var compareVersion = function(version1, version2) {
    var v1 = version1.split(".");
    var v2 = version2.split(".");
    for(var i=0; i<v1.length && i<v2.length; i++){
        var a = parseInt(v1[i]);
        var b = parseInt(v2[i]);
        if(a>b){return 1;}
        if(a<b){return -1;}
    }
    if(v1.length > v2.length){
        for(var k = v2.length; k<v1.length;k++){
            var c = parseInt(v1[k]);
            if(c>0){return 1;}
        }
    }
    if(v1.length < v2.length){
        for(var j = v1.length; j<v2.length; j++){
            var d = parseInt(v2[j]);
            if(d>0){return -1;}
        }
    }
    return 0;
};
