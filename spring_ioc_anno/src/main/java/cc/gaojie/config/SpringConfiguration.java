package cc.gaojie.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/16 18:13
 * @since 1.8
 */
//标准该类是Spring核心配置类，代替之前的xml文件
@Configuration
//<context:component-scan base-package="cc.gaojie"/>
@ComponentScan("cc.gaojie")  //代替上面的组件扫描
//<import resource="applicationContext-goods.xml"/>
@Import(DataSourceConfiguration.class)  //加载数据源配置器，加载多个用，分隔
public class SpringConfiguration {

}
