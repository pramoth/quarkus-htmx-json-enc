package th.co.geniustree.quarkus;

import io.quarkus.qute.TemplateExtension;

import java.util.Objects;

@TemplateExtension
public class StringExt {
    static boolean eq(String o1,String o2){
        return Objects.equals(o1,o2);
    }

    static String concat(String o1,String o2){
        return o1+o2;
    }

    static boolean eq(Long o1,Long o2){
        return Objects.equals(o1,o2);
    }

    static boolean neq(Object o1,Object o2){
        return Objects.equals(o1,o2);
    }
}
