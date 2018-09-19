1.构建项目
    http://start.spring.io/
2.目录结构
    src/main/java 程序开发以及主程序入口
    src/main/resources 配置文件
    src/test/java 测试程序
    
    com
      +- example
        +- myproject
          +- Application.java
          |
          +- domain
          |  +- Customer.java
          |  +- CustomerRepository.java
          |
          +- service
          |  +- CustomerService.java
          |
          +- controller
          |  +- CustomerController.java
          |

    1、Application.java 建议放到根目录下面,主要用于做一些框架配置
    2、domain目录主要用于实体（Entity）与数据访问层（Repository）
    3、service 层主要是业务类代码
    4、controller 负责页面访问控制
    
3.web模块
    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
     </dependency>
     
4.单元测试（MockMvc）

@RunWith(SpringRunner.class)
@SpringBootTest

5.开发环境的调试
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
</dependency>


	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<fork>true</fork>
				</configuration>
			</plugin>
		</plugins>
	</build>