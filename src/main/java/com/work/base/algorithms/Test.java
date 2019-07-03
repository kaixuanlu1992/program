//package com.work.base.algorithms;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.time.DateFormatUtils;
//
//import java.util.Calendar;
//import java.util.Random;
//import java.util.UUID;
//
//@Slf4j
//public class Test {
//    public static void main(String[] args) {
//        log2();
//    }
//
//    private static void log1(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 1, 6, 9, 12, 44);
//        Calendar endDate = Calendar.getInstance();
//        endDate.set(2019, 1, 9, 9, 12, 44);
//        log.info(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss") + " Compute 0"+(calendar.get(Calendar.MINUTE)%4+1)+" overload [cpu:84%]");
//        while (calendar.getTime().before(endDate.getTime())) {
//            Random random = new Random();
//            calendar.add(Calendar.MINUTE, random.nextInt(177));
//            calendar.add(Calendar.SECOND, random.nextInt(30));
//            int temp = random.nextInt(15)+5;
//            int value;
//            if (random.nextBoolean()) {
//                value = temp;
//            } else {
//                value = 100 - temp;
//            }
//
//            if (value <= 15) {
//                log.info(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss") + " Compute 0"+(calendar.get(Calendar.MINUTE)%4+1)+" underload [cpu:" + value + "%]");
//            } else if (value >= 85) {
//                log.info(DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss") + " Compute 0"+(calendar.get(Calendar.MINUTE)%4+1)+" overload [cpu:" + value + "%]");
//            }
//
//        }
//        log.info("2019-02-09 10:05:43" + " Compute 01"+" overload [cpu:" + 87 + "%]");
//        log.info("2019-02-09 10:06:22" + " Compute 01"+" overload [cpu:" + 90 + "%]");
//        log.info("2019-02-09 10:10:13" + " Compute 01"+" underload [cpu:" + 11 + "%]");
//    }
//
//    private static void log2(){
//        log.info("----------------------------HostINfo----------------------------");
//        log.info("'compute01':\n"+
//                "'cpu', 'total',{1549554158, 68}");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-0000145\n"+
//                "dom_id:6 cpu:38.0%");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-0000156\n"+
//                "dom_id:5 cpu:49.0%");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-00001d3\n"+
//                "dom_id:3 cpu:35.0%");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-0000187\n"+
//                "dom_id:1 cpu:70.0%");
//
//    }
//
//    private static void log3(){
//        //log.info(UUID.randomUUID().toString());
//        log.info("----------------------------HostINfo----------------------------");
//        log.info("compute01 --> compute01\n"+
//                "cpu={1;68%} time=1549554158");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-00000145 --> "+UUID.randomUUID().toString()+"\n"+
//                "cpu={1;12%} time=1549554158");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-00000156 --> "+UUID.randomUUID().toString()+"\n"+
//                "cpu={1;16%} time=1549554158");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-000001d3 --> "+UUID.randomUUID().toString()+"\n"+
//                "cpu={1;18%} time=1549554158");
//        log.info("----------------------------vmINfo----------------------------");
//        log.info("instance-00000187 --> "+UUID.randomUUID().toString()+"\n"+
//                "cpu={1;22%} time=1549554158");
//
//    }
//}
