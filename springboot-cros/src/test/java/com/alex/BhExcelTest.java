package com.alex;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BhExcelTest {
    @Test
    public void writeWithMultiHead() throws IOException {
        try (OutputStream out = new FileOutputStream("hello.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");

            List<List<String>> head = new ArrayList<List<String>>();
            List<String> headCoulumn1 = new ArrayList<String>();
            List<String> headCoulumn2 = new ArrayList<String>();
            headCoulumn1.add("机构名称:");
            headCoulumn2.add("社会信用代码");
            head.add(headCoulumn1);
            head.add(headCoulumn2);
            Table table1 = new Table(1);
            List<List<String>> data1 = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                List<String> item = new ArrayList<>();
                item.add("北京道口贷科技有限公司");
                item.add("9000212133546");
                data1.add(item);
            }
            table1.setHead(head);
            writer.write0(data1, sheet1, table1);

            Table table2 = new Table(2);
            table2.setClazz(MultiLineHeadExcelModel.class);
            List<MultiLineHeadExcelModel> data = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
                item.p1 = "p1" + i;
                item.p2 = "p2" + i;
                item.p3 = "p3" + i;
                item.p4 = "p4" + i;
                item.p5 = "p5" + i;
                item.p6 = "p6" + i;
                item.p7 = "p7" + i;
                item.p8 = "p8" + i;
                item.p9 = "p9" + i;
                item.p10 = "p10" + i;
                item.p11 = "p11" + i;
                item.p12 = "p12" + i;
                item.p13 = "p13" + i;
                item.p14 = "p14" + i;
                item.p15 = "p15" + i;
                item.p16 = "p16" + i;
                item.p17 = "p17" + i;
                item.p18 = "p18" + i;
                item.p19 = "p19" + i;
                data.add(item);
            }
            writer.write(data, sheet1, table2);
            writer.finish();
        }
    }

    public static class MultiLineHeadExcelModel extends BaseRowModel {

        @ExcelProperty(value = {"序号", "序号"}, index = 0)
        private String p1;

        @ExcelProperty(value = {"日期", "日期"}, index = 1)
        private String p2;

        @ExcelProperty(value = {"成功报送情况", "报送请求总数(项目+项目状态变更)"}, index = 2)
        private String p3;

        @ExcelProperty(value = {"成功报送情况", "项目总数"}, index = 3)
        private String p4;

        @ExcelProperty(value = {"成功报送情况", "项目变更总数"}, index = 4)
        private String p5;

        @ExcelProperty(value = {"项目异常情况", "失败请求总数"}, index = 5)
        private String p6;

        @ExcelProperty(value = {"项目异常情况", "失败项目总数"}, index = 6)
        private String p7;

        @ExcelProperty(value = {"项目异常情况", "重复报送项目个数"}, index = 7)
        private String p8;

        @ExcelProperty(value = {"项目异常情况", "重复报送项目次数"}, index = 8)
        private String p9;

        @ExcelProperty(value = {"项目异常情况", "补报项目数"}, index = 9)
        private String p10;

        @ExcelProperty(value = {"项目异常情况", "补报情况说明"}, index = 10)
        private String p11;

        @ExcelProperty(value = {"项目异常情况", "补报情况说明"}, index = 11)
        private String p12;

        @ExcelProperty(value = {"项目状态变更异常情况", "失败请求总数\r"}, index = 12)
        private String p13;

        @ExcelProperty(value = {"项目状态变更异常情况", "失败状态变更总数\r"}, index = 13)
        private String p14;

        @ExcelProperty(value = {"项目状态变更异常情况", "重复报送状态\r变更个数"}, index = 14)
        private String p15;

        @ExcelProperty(value = {"项目状态变更异常情况", "重复状态变更\r次数"}, index = 15)
        private String p16;

        @ExcelProperty(value = {"项目状态变更异常情况", "补报的状态\n变更数"}, index = 16)
        private String p17;

        @ExcelProperty(value = {"项目状态变更异常情况", "补报情况说明\r"}, index = 17)
        private String p18;

        @ExcelProperty(value = {"备注", "备注"}, index = 18)
        private String p19;

        public String getP1() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1 = p1;
        }

        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }

        public String getP3() {
            return p3;
        }

        public void setP3(String p3) {
            this.p3 = p3;
        }

        public String getP4() {
            return p4;
        }

        public void setP4(String p4) {
            this.p4 = p4;
        }

        public String getP5() {
            return p5;
        }

        public void setP5(String p5) {
            this.p5 = p5;
        }

        public String getP6() {
            return p6;
        }

        public void setP6(String p6) {
            this.p6 = p6;
        }

        public String getP7() {
            return p7;
        }

        public void setP7(String p7) {
            this.p7 = p7;
        }

        public String getP8() {
            return p8;
        }

        public void setP8(String p8) {
            this.p8 = p8;
        }

        public String getP9() {
            return p9;
        }

        public void setP9(String p9) {
            this.p9 = p9;
        }

        public String getP10() {
            return p10;
        }

        public void setP10(String p10) {
            this.p10 = p10;
        }

        public String getP11() {
            return p11;
        }

        public void setP11(String p11) {
            this.p11 = p11;
        }

        public String getP12() {
            return p12;
        }

        public void setP12(String p12) {
            this.p12 = p12;
        }

        public String getP13() {
            return p13;
        }

        public void setP13(String p13) {
            this.p13 = p13;
        }

        public String getP14() {
            return p14;
        }

        public void setP14(String p14) {
            this.p14 = p14;
        }

        public String getP15() {
            return p15;
        }

        public void setP15(String p15) {
            this.p15 = p15;
        }

        public String getP16() {
            return p16;
        }

        public void setP16(String p16) {
            this.p16 = p16;
        }

        public String getP17() {
            return p17;
        }

        public void setP17(String p17) {
            this.p17 = p17;
        }

        public String getP18() {
            return p18;
        }

        public void setP18(String p18) {
            this.p18 = p18;
        }

        public String getP19() {
            return p19;
        }

        public void setP19(String p19) {
            this.p19 = p19;
        }
    }
}
