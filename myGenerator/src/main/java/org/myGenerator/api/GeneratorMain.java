package org.myGenerator.api;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;

public class GeneratorMain {

    public static void main(String[] args) throws Exception {
        String rootFolder = "J:\\project\\myGenerator";
        GeneratorFacade g = new GeneratorFacade();
        Generator generator = g.getGenerator();
        generator.setOutRootDir(rootFolder + "\\generator-output");
//		g.printAllTableNames();				//打印数据库中的表名称
        generator.setTemplateRootDir(rootFolder + "\\template");
        g.deleteOutRootDir();
//		g.deleteByAllTable();							//删除生成器的输出目录
//		g.deleteByTable("T_EMPLOYEE");
        g.generateByTable("mm_uploadfile");
//		g.generateByTable(new String[]{"t_store_message"});	//通过数据库表生成文件,template为模板的根目录
//		g.generateByAllTable();	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
//		g.generateByClass(Blog.class);

//		g.deleteByTable("table_name"); //删除生成的文件
        //打开文件夹
        //Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
        Runtime.getRuntime().exec("cmd.exe /c start " + generator.getOutRootDir());

    }

}
