package com.alex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

public class Test {

    public static void main(String[] args) {
        String branches = "\"Branches\": [{\"CompanyId\": \"8dc057af59e908b6a1c05d74de114134\",\"RegNo\": \"500902300083458\",\"Name\": \"北京小桔科技有限公司重庆分公司\",\"BelongOrg\": \"重庆市工商行政管理局南岸区分局经开区局\",\"CreditCode\": null,\"OperName\": null}]";

        if (!StringUtils.isEmpty(branches)) {
            String branch = branches.replaceAll("\"Branches\":", "").replaceAll("\\[", "").replaceAll("\\]", "");
            JSONObject branchesJson = JSON.parseObject(branch);
            //String branch = branches.replaceAll("\\[", "").replaceAll("\\]", "");
            //JSONObject branchesJson = JSON.parseObject(branch);
            //注册号
            System.out.println(branchesJson.getString("RegNo"));
        }
    }
}
