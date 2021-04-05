package com.lvxiao.spring.boot.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-02-25
 */
@Lazy
@Service
public class TestLazyServiceImpl {

    @PostConstruct
    public void init() {
        System.out.println("TestLazyServiceImpl被加载了");
        testPostConstract1.test();
    }

    @Autowired
    private TestLazyServiceImpl2 testLazyServiceImpl2;
    @Autowired
    private TestPostConstract1Impl testPostConstract1;

    public String test() {
        return testLazyServiceImpl2.test();
    }

    private static class Test {
        public Test() {
        }
    }

    public static void main(String[] args) {
        String s = "{\"status\":\"OK\",\"module\":[{\"moduleId\":1275,\"moduleName\":\"新回签到任务模块\","
                + "\"moduleType\":\"SIGN_IN_MODULE\",\"description\":\"\",\"task\":[{\"taskId\":1494,"
                + "\"taskName\":\"新设备激励7天实验第一天签到任务\",\"description\":\"\",\"reward\":{\"rewardId\":1470,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":26,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}},{\"taskId\":1495,\"taskName\":\"新设备激励7天实验第二天签到任务\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1471,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":40,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1496,"
                + "\"taskName\":\"新设备激励7天实验第三天签到任务\",\"description\":\"\",\"reward\":{\"rewardId\":1472,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":39,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}},{\"taskId\":1497,\"taskName\":\"新设备激励7天实验第四天签到任务\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1473,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":50,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1498,"
                + "\"taskName\":\"新设备激励7天实验第五天签到任务\",\"description\":\"\",\"reward\":{\"rewardId\":1474,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":69,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}},{\"taskId\":1499,\"taskName\":\"新设备激励7天实验第六天签到任务\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1475,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":39,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1500,"
                + "\"taskName\":\"新设备激励7天实验第七天签到任务\",\"description\":\"\",\"reward\":{\"rewardId\":1476,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":68,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}}],\"priority\":0,\"taskGroup\":[]},{\"moduleId\":1279,"
                + "\"moduleName\":\"观看直播常驻\",\"moduleType\":\"COMMON_MODULE\",\"description\":\"\","
                + "\"task\":[{\"taskId\":1247,\"taskName\":\"观看直播1分钟\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1264,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":136,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}}],\"priority\":4,\"taskGroup\":[]},"
                + "{\"moduleId\":1282,\"moduleName\":\"新回每日切换任务模块\",\"moduleType\":\"COMMON_MODULE\","
                + "\"description\":\"\",\"task\":[{\"taskId\":1246,\"taskName\":\"点赞3个作品\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1058,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":72,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1243,\"taskName\":\"评论1个作品\","
                + "\"description\":\"\",\"reward\":{\"rewardId\":1262,\"rewardName\":\"\","
                + "\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\",\"rewardCount\":103,"
                + "\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}}],"
                + "\"priority\":3,\"taskGroup\":[]},{\"moduleId\":1277,\"moduleName\":\"关注用户梯度\","
                + "\"moduleType\":\"COMMON_MODULE\",\"description\":\"\",\"task\":[{\"taskId\":1260,"
                + "\"taskName\":\"关注1个用户\",\"description\":\"\",\"reward\":{\"rewardId\":1262,\"rewardName\":\"\","
                + "\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\",\"rewardCount\":132,"
                + "\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},"
                + "{\"taskId\":1261,\"taskName\":\"关注3个用户\",\"description\":\"\",\"reward\":{\"rewardId\":1395,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":225,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}}],\"priority\":2,\"taskGroup\":[]},{\"moduleId\":1273,"
                + "\"moduleName\":\"看视频、赚积分\",\"moduleType\":\"APP_STARTUP_MODULE\",\"description\":\"\","
                + "\"task\":[{\"taskId\":1236,\"taskName\":\"观看视频1分钟\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1220,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":365,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1256,\"taskName\":\"观看视频3分钟\","
                + "\"description\":\"\",\"reward\":{\"rewardId\":1265,\"rewardName\":\"\","
                + "\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\",\"rewardCount\":436,"
                + "\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},"
                + "{\"taskId\":1257,\"taskName\":\"观看视频5分钟\",\"description\":\"\",\"reward\":{\"rewardId\":1220,"
                + "\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\","
                + "\"rewardCount\":337,\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,"
                + "\"rewardLinkUrl\":\"\"}},{\"taskId\":1258,\"taskName\":\"观看视频12分钟\",\"description\":\"\","
                + "\"reward\":{\"rewardId\":1266,\"rewardName\":\"\",\"rewardType\":\"UNKNOWN_REWARD_TYPE\","
                + "\"rewardIconUrl\":\"\",\"rewardCount\":570,\"rewardDisplayName\":\"\","
                + "\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}},{\"taskId\":1259,"
                + "\"taskName\":\"观看视频20分钟\",\"description\":\"\",\"reward\":{\"rewardId\":1265,\"rewardName\":\"\","
                + "\"rewardType\":\"UNKNOWN_REWARD_TYPE\",\"rewardIconUrl\":\"\",\"rewardCount\":362,"
                + "\"rewardDisplayName\":\"\",\"rewardCouponDenomination\":0,\"rewardLinkUrl\":\"\"}}],"
                + "\"priority\":1,\"taskGroup\":[]}]}";
        System.out.println(s.getBytes(StandardCharsets.UTF_8).length);
    }
}

