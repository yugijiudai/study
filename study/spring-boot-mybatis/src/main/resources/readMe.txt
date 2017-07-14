http://i.youku.com/i/UMjM3MTgwNzI4/videos?spm=a2hzp.8244740.0.0
https://github.com/pagehelper/Mybatis-PageHelper/tree/master/wikis/en
修改tomcat启动时候在控制台的显示
1.在yml里增加  main: banner-mode: "off"
2.在main方法里增加
SpringApplication app = new SpringApplication(MyBatisApp.class);
app.setBannerMode(Banner.Mode.OFF);
app.run(args);
3.在resources文件目录下添加banner.txt


修改tomcat的logo
在resources文件目录下添加favicon.ico