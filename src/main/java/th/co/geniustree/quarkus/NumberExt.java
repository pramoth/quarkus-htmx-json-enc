package th.co.geniustree.quarkus;

import io.quarkus.qute.TemplateExtension;

@TemplateExtension
public class NumberExt {
    static String asIndexOf(Number a,String s){
        return s+"["+a+"]";
    }
}
