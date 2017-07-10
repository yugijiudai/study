http://www.imooc.com/learn/767
http://www.imooc.com/learn/810
运行方法:
1.执行main函数
2.mvn spring-boot:run
3.到target文件夹下执行java -jar xx.jar --spring.profiles.active=prod(注:要执行这个target文件夹下必须有.jar.original文件才行,如果父依赖不是spring,则插件要写成以下形式:)
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>${spring_boot_version}</version>
    <!--//如果是用dependency import这种方式引入springboot的话,这里的打包插件要加这个,不然打包出来没有original,这样就不能用jar命令启动了-->
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
        </execution>
    </executions>
</plugin>


想spring-boot-starter-parent作为parent引入要这样写,子类不用依赖这个
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>${spring_boot_version}</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>

parent如果引入了其他spring的依赖要小心,因为springboot自己会引入很多spring的依赖,所以要看springboot中其他spring的版本和原来引入的spring版本是否一致,不一致时springboot有可能会启动不了,必要时可以删除原来和springboot中重复的依赖
