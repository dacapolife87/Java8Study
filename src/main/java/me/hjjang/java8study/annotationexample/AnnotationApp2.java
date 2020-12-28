package me.hjjang.java8study.annotationexample;


import java.util.Arrays;

@JokBal("오리지날")
@JokBal("마늘")
@JokBal("불족")
public class AnnotationApp2 {

    public static void main(String[] args) {

        //getAnnotationsByType 어노테이션타입으로 가져오기
        JokBal[] jokbals = AnnotationApp2.class.getAnnotationsByType(JokBal.class);
        Arrays.stream(jokbals).forEach(jokBal -> {
            System.out.println(jokBal.value());
        });

        // 컨테이너를 통해 가져오기
        JokBalContatiner jokBalContatiner = AnnotationApp2.class.getAnnotation(JokBalContatiner.class);
        Arrays.stream(jokBalContatiner.value()).forEach(jokBal -> {
            System.out.println(jokBal.value());
        });

        //  여러개를 등록한 어노테이션인 경우는 해당 어노테이션으로 못가져옴
//        JokBal jokbals2 = AnnotationApp2.class.getAnnotation(JokBal.class);
//        Arrays.stream(jokBalContatiner.value()).forEach(jokBal -> {
//            System.out.println(jokBal.value());
//        });
    }


}
